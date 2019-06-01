package ClientView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;

/**
 * 	洗牌、发牌（有序）
 * @author 幽竹
 *
 */
public class CardInfoInit {
	
	//建一个map集合，参数一，存放图片的jlabel的名字,参数二，存放的图片的的显示信息
	private static Map<JLabel,Integer> map = new HashMap<>();
	//
	private static List<JLabel> list = new ArrayList<>();
	//存放牌的名字和它对应的信息
	private static Map<Integer,Integer> cardShow = new HashMap<>();
	
	public CardInfoInit() {
		int[] cardInfo = {3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,
							12,12,12,12,13,13,13,13,14,14,14,14,15,15,15,15,16,17};
		int[] cardName = {3,23,43,63,4,24,44,64,5,25,45,65,6,26,46,66,7,27,47,67,8,28,48,68,9,29,49,69,10,30,50,70,
							11,31,51,71,12,32,52,72,13,33,53,73,14,34,54,74,15,35,55,75,98,99};
		for(int i = 0; i < CardInitPos.CARDNUM; i++) {
			cardShow.put(cardName[i], cardInfo[i]);
		}
	}
		
	public static Map<JLabel, Integer> getMap() {
		return map;
	}

	public static  Map<Integer,Integer> getCardShow() {
		return cardShow;
	}
	
	/**
	 * 存放牌的信息
	 * @param jl 控件信息
	 * @param x  控件对应的牌
	 */
	public void saveCardInfo(JLabel jl, int x) {
		map.put(jl, x);
		list.add(jl);
	}
	
	/**
	 * 	洗牌
	 * @return
	 */
	public JLabel[] getChangeCardOrder(){
		JLabel[] temp = sortJLbel(changeCardOrder());
		return temp;
	}
	
	/**
	 * 	打乱牌的顺序list
	 * 	将list集合里面的元素随机抽一个添加到temp集合里面，抽一个，list删一个，直到list里面的元素全部抽完
	 */
	private JLabel[] changeCardOrder() {	
		JLabel[] temp = new JLabel[CardInitPos.CARDNUM];
		//清空list列表，将list列表里面的东西打乱放到新属猪JLbel[] temp 里面
		for(int i = 0; i < 54; i++) {
			int num = createRandom(list.size());
			temp[i] = list.get(num);
			list.remove(num);
		}	
		return temp;
	}
	
	/**
	 * 	排序牌（无序）然后添加到新的牌力面（有序）
	 * @param temp
	 * @return
	 */
	private JLabel[] sortJLbel(JLabel[] temp) {
		JLabel[] jlabel = new JLabel[CardInitPos.CARDNUM];

		Map<JLabel,Integer> mL = new HashMap<>();
		Map<JLabel,Integer> mR = new HashMap<>();
		Map<JLabel,Integer> mB = new HashMap<>();
		for(int i = 0 ; i < temp.length; i++) {
			int x = cardShow.get(map.get(temp[i]));
			if(i % 3 == 0) {
				mL.put(temp[i],x);
			} else if (i % 3 == 1) {
				mB.put(temp[i],x);
			} else {
				mR.put(temp[i],x);	
			}
		}
		//对map集合的key值根据value值的大小进行排序
		List<Map.Entry<JLabel, Integer>> listL = new ArrayList<>(mL.entrySet());
		Collections.sort(listL, new Comparator<Map.Entry<JLabel, Integer>>() {
			@Override
			public int compare(Entry<JLabel, Integer> o1, Entry<JLabel, Integer> o2) {
				int t = - o2.getValue().compareTo(o1.getValue());
				return t;
			}
		});
		List<Map.Entry<JLabel, Integer>> listR = new ArrayList<>(mR.entrySet());
		Collections.sort(listR, new Comparator<Map.Entry<JLabel, Integer>>() {
			@Override
			public int compare(Entry<JLabel, Integer> o1, Entry<JLabel, Integer> o2) {
				int t = - o2.getValue().compareTo(o1.getValue());
				return t;
			}
		});
		List<Map.Entry<JLabel, Integer>> listB = new ArrayList<>(mB.entrySet());
		Collections.sort(listB, new Comparator<Map.Entry<JLabel, Integer>>() {
			@Override
			public int compare(Entry<JLabel, Integer> o1, Entry<JLabel, Integer> o2) {
				int t = - o2.getValue().compareTo(o1.getValue());
				return t;
			}
		});
		//将三个人的牌按照发牌顺序一张一张加到JLabel里面
		int a = 0, b = 0, c = 0;
		for(int i = 0 ; i < jlabel.length; i++) {			
			if(i % 3 == 0) {
				jlabel[i] = listL.get(a).getKey();
				a++;
			} else if (i % 3 == 1) {
				jlabel[i] = listB.get(b).getKey();
				b++;
			} else {
				jlabel[i] = listR.get(c).getKey();
				c++;
			}
		}
		return jlabel;
	}
	
	/**
	 * 	产生随机数，
	 * @param size 范围是[0,size)的整数
	 * @return 返回[0,size)的整数
	 */
	private int createRandom(int size) {
		return (int)(Math.random() * (size));
	}
}
