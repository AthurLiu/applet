package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import View.CardInfoInit;

/**
 * 	自动出牌的类
 * @author 13600
 *
 */
public class ConnectInfo {
	//三张表，用来放牌在界面里的的属性和对应的显示信息
	private Map<JLabel,Integer> mapL = new HashMap<>();
	private Map<JLabel,Integer> mapB = new HashMap<>();
	private Map<JLabel,Integer> mapR = new HashMap<>();
	//打牌的
	private List<Integer> listL = new ArrayList<>();
	private List<Integer> listB = new ArrayList<>();
	private List<Integer> listR = new ArrayList<>();
	
	//存放出牌信息的表（暂时还没有用到）
	private List<JLabel> list = new ArrayList<>();
	//不要次数，A出牌，b,c都不要，则A赢，a再次出牌
	private int ps;
	public int putCardPeople = 3;
		
	public List<JLabel> getList() {
		return list;
	}
	public List<Integer> getListL() {
		return listL;
	}
	public List<Integer> getListB() {
		return listB;
	}
	public List<Integer> getListR() {
		return listR;
	}
	
	/**
	 * 	经过一系列复杂的判断，确定收到牌的人出什么牌
	 *	 map 里面存的是单牌是哪几张，对子是哪几张，三个是哪几张，炸弹是哪几张
	 *	 mapT 存放牌的地址和牌显示的内容，方便根据指定的牌的内容查看牌的详细信息，方便界面对牌的操作
	 *	 temp 存放牌的大小，比如map里面找到单个是哪几张，temp里面找到该牌且大于上家的牌，再根据mapT找到对应牌的详细信息，否则，要不起，传给下一个人
	 */
	public void putCard() {
		List<Integer> temp = listB;
		Map<JLabel,Integer> mapT = mapB;
		if(Util.getGetter()[2].equals("1")) {
			temp = listR;
			mapT = mapR;
		}
		if(Util.getGetter()[2].equals("2")) {
			temp = listL;
			mapT = mapL;
		} 		
		Map<Integer,Integer> map = Util.getCardType(temp);
		
		int num = 0;
		boolean exit = false;
		if(Util.getGetter()[1].contains("单")) {
			String[] str1 = Util.getGetter()[1].split("-");
			for(int i = 0; i < temp.size(); i++) {
				//要出牌的那个人里面有大的牌
				if(map.get(temp.get(i)) == 1 && temp.get(i) > Integer.parseInt(str1[1])) {
					System.out.println(Util.getGetter()[0] + "出的牌是：" + Util.getGetter()[1] + "，" + Util.getGetter()[2] + "出的牌是：" + temp.get(i));
					num = temp.get(i);
					//判断收牌人是哪一个，从而进行相应的操作
					Util.setPutCardMeg(Integer.parseInt(Util.getGetter()[2]),":单-" + num + ":");	
					ps = 0;
					exit = true;
					break;
				} else if (map.get(temp.get(i)) == 4) {
					System.out.println(Util.getGetter()[0] + "出的牌是：" + Util.getGetter()[1] + "，" + Util.getGetter()[2] + "出的牌是炸弹！");
					num = temp.get(i);
					//判断收牌人是哪一个，从而进行相应的操作
					Util.setPutCardMeg(Integer.parseInt(Util.getGetter()[2]),":炸弹-" + num + ":");	
					ps = 0;
					exit = true;
					break;
				}
			}
			putCardJudge(exit,num,mapT);	
		} else if(Util.getGetter()[1].contains("对")) {
			String[] str1 = Util.getGetter()[1].split("-");
			for(int i = 0; i < temp.size(); i++) {
				//要出牌的那个人里面有大的牌
				if(map.get(temp.get(i)) == 2 && temp.get(i) > Integer.parseInt(str1[1])) {
					System.out.println(Util.getGetter()[0] + "出的牌是：" + Util.getGetter()[1] + "，" + Util.getGetter()[2] + "出的牌是：" + temp.get(i));
					num = temp.get(i);
					//判断收牌人是哪一个，从而进行相应的操作
					Util.setPutCardMeg(Integer.parseInt(Util.getGetter()[2]),":对-" + num + ":");	
					ps = 0;
					exit = true;
					break;
				} 
			}
			putCardJudge(exit,num,mapT);				
		} else if(Util.getGetter()[1].contains("三个")) {
			String[] str1 = Util.getGetter()[1].split("-");
			for(int i = 0; i < temp.size(); i++) {
				//要出牌的那个人里面有大的牌
				if(map.get(temp.get(i)) == 3 && temp.get(i) > Integer.parseInt(str1[1])) {
					System.out.println(Util.getGetter()[0] + "出的牌是：" + Util.getGetter()[1] + "，" + Util.getGetter()[2] + "出的牌是：" + temp.get(i));
					num = temp.get(i);
					//判断收牌人是哪一个，从而进行相应的操作
					Util.setPutCardMeg(Integer.parseInt(Util.getGetter()[2]),":三个-" + num + ":");	
					ps = 0;
					exit = true;
					break;
				} 
			}
			putCardJudge(exit,num,mapT);				
		} else if(Util.getGetter()[1].contains("炸弹")) {
			String[] str1 = Util.getGetter()[1].split("-");
			for(int i = 0; i < temp.size(); i++) {
				//要出牌的那个人里面有大的牌
				if(map.get(temp.get(i)) == 4 && temp.get(i) > Integer.parseInt(str1[1])) {
					System.out.println(Util.getGetter()[0] + "出的牌是：" + Util.getGetter()[1] + "，" + Util.getGetter()[2] + "出的牌是：" + temp.get(i));
					num = temp.get(i);
					//判断收牌人是哪一个，从而进行相应的操作
					Util.setPutCardMeg(Integer.parseInt(Util.getGetter()[2]),":炸弹-" + num + ":");	
					ps = 0;
					exit = true;
					break;
				} 
			}
			putCardJudge(exit,num,mapT);
		}
	}
	
	/**
	 * 从putCard（）方法里面抽出来的，对于能不能要起上家的牌
	 * @param exit 能要起上家的牌则为true，不能为false
	 * @param num 能要起上家的牌的大小
	 * @param mapT 根据mapT可以查出该牌的具体详细信息
	 */
	private void putCardJudge(boolean exit, int num,Map<JLabel,Integer> mapT) {
		if(exit) {
			//根据找到的value确定要出什么牌
			for(Map.Entry<JLabel,Integer> str2 : mapT.entrySet()){
			   if(num == str2.getValue()){
				   list.add(str2.getKey());
			   }
			}
		} else {
			//要不起，传给下一个人
			if(ps < 2) {
				if(Util.getGetter()[2].equals("1")) {
					Util.saveInfo(Util.getGetter()[0] + ":" + Util.getGetter()[1] + ":" + 2);
				} else if(Util.getGetter()[2].equals("2")) {
					Util.saveInfo(Util.getGetter()[0] + ":" + Util.getGetter()[1] + ":" + 0);
				} else {	
					Util.saveInfo(Util.getGetter()[0] + ":" + Util.getGetter()[1] + ":" + 1);
				}						
				ps++;
				if(ps == 2) {
					putCardPeople = Integer.parseInt(Util.getGetter()[0]);
					System.out.println("当前出牌人是：" + Util.getGetter()[0] + ",出的牌是" + Util.getGetter()[1] + "," + ps + "个牌友都要不起，他继续出牌！");
					putCard1(Integer.parseInt(Util.getGetter()[0]));						
				} else {
					putCard();
				}					
			}			
		}		
	}
	
	/**
	 *	 有人出了两次单牌没人要，这个人赢了一轮，可以再次出牌，继续出单牌（最小）
	 *	当某个人赢了，而他的单牌也恰好出完了，这个时候开始打对子
	 * @param x 出牌的人
	 */
	private void putCard1(int x) {
		List<Integer> temp = listB;
		Map<JLabel,Integer> mapT = mapB;
		if(x == 1) {
			temp = listR;
			mapT = mapR;
		}
		if(x == 2) {
			temp = listL;
			mapT = mapL;
		}
		Map<Integer,Integer> map = Util.getCardType(temp);		
		int num = 0;
		if(map.containsValue(1)) {
			for(Map.Entry<Integer,Integer> str2 : map.entrySet()){
			   if(1 == str2.getValue()){
				   num = str2.getKey();
				   for(Map.Entry<JLabel,Integer> str3 : mapT.entrySet()){
					   if(str3.getValue() == num){
						   list.add(str3.getKey());
					       break;
					   }
					}
				   break;
			    }
			}
			Util.setPutCardMeg(x,":单-" + num + ":");
			ps = 0;
		} else if (map.containsValue(2)){
			for(Map.Entry<Integer,Integer> str2 : map.entrySet()){
			   if(2 == str2.getValue()){
				   num = str2.getKey();
				   for(Map.Entry<JLabel,Integer> str3 : mapT.entrySet()){
					   if(str3.getValue() == num){
						   list.add(str3.getKey());
					   }
					}
				   break;
			    }
			}
			Util.setPutCardMeg(x,":对-" + num + ":");
			ps = 0;
			System.out.println("当前出牌人是：" + Util.getGetter()[0] + ",没有单牌，有对子，继续出牌" + Util.getGetter()[1]);
		} else if (map.containsValue(3)){
			for(Map.Entry<Integer,Integer> str2 : map.entrySet()){
			   if(3 == str2.getValue()){
				   num = str2.getKey();
				   for(Map.Entry<JLabel,Integer> str3 : mapT.entrySet()){
					   if(str3.getValue() == num){
						   list.add(str3.getKey());
					   }
					}
				   break;
			    }
			}
			Util.setPutCardMeg(x,":三个-" + num + ":");
			ps = 0;
			System.out.println("当前出牌人是：" + Util.getGetter()[0] + ",没有单牌，没有对子，继续出牌" + Util.getGetter()[1]);
		}				
	}	

	/**
	 * 	移除传递消息的牌的详细信息
	 * 	为下一轮信息传递作准备
	 */
	public void setList() {
		list.clear();
	}

	/**
	 * 	在本类的三个方法变量map和list里面
	 * 	移除界面打出的牌
	 * 	以便进行后续其它出牌的选择，防止影响后续出牌，
	 * 	因为后续出牌的，牌的选择全部依赖于3个map和三个list
	 * @param jl
	 */
	public void removeCardInfo(JLabel jl) {
		if(mapB.containsKey(jl)) {
			remove(mapB,listB,jl);
		} else if(mapR.containsKey(jl)) {
			remove(mapR,listR,jl);
		} else {
			remove(mapL,listL,jl);
		}
	}
	
	/**
	 * @param map 根据控件信息移除本集合里面已经出过的牌的属性和显示信息
	 * @param list 移除已经出过牌的信息，该list主要用于本集合牌和收到的牌的大小的比较
	 * @param jl 界面传过来的控件信息
	 */
	private void remove(Map<JLabel,Integer> map,List<Integer> list,JLabel jl) {
		int temp = 0;
		boolean flag = false;
		for(int i = 0; i < list.size(); i++) {
			if(map.get(jl) == list.get(i)) {
				temp = i;
				flag = true;
			}
		}
		if(flag) {
			list.remove(temp);
			map.remove(jl);
		}
	}
	
	/**
	 * 新游戏，清除所有数据
	 */
	public void newGame() {
		listL.clear();
		listR.clear();
		listB.clear();
		mapL.clear();
		mapR.clear();
		mapB.clear();
		list.clear();
		putCardPeople = 3;
	}
	
	/**
	 * 保存三个人分到的牌
	 */
	public void saveInfo() {
		mapL = CardInfoInit.getMapL();
		mapL.forEach((key,value) -> listL.add(value));
		mapB = CardInfoInit.getMapB();
		mapB.forEach((key,value) -> listB.add(value));
		mapR = CardInfoInit.getMapR();
		mapR.forEach((key,value) -> listR.add(value));
		listL.sort((o1,o2) -> o1 - o2);
		listB.sort((o1,o2) -> o1 - o2);
		listR.sort((o1,o2) -> o1 - o2);		
	}
}
