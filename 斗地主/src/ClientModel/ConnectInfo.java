package ClientModel;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import ClientView.CardInfoInit;

public class ConnectInfo {
	//建一个map集合，参数一，存放图片的jlabel的名字,参数二，存放的图片的的显示信息
	private Map<JLabel,Integer> map = CardInfoInit.getMap();
	//存放牌的名字和它对应的信息
	private Map<Integer,Integer> cardShow = CardInfoInit.getCardShow();
	//建三张表，用来存放卡片信息
	List<Integer> listL = new ArrayList<Integer>();
	List<Integer> listR = new ArrayList<Integer>();
	List<Integer> listB = new ArrayList<Integer>();
	//出牌人 下 右 左 默认是 0,1,2
	private int sendPeople;
		
	/**
	 * 得到别人发给我的消息
	 * @return
	 */
	private String getInfo() {
		String s = "";
		try {
			List<String> str = Files.readAllLines(Paths.get("text/info.txt"));
			s = str.get(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}	
	public void listener() {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//收消息的人分别是1,2,0
					if(getGetter()[2] == "1") {
						//右边的人手到消息
						putCard(getGetter()[1],listR);
					} else if(getGetter()[2] == "2") {
						
					} else {
						
					}
				}
			}
		}).start();
	}
	
	public void showInfo() {
		//对收牌人的牌进行分析  对子，串子，三带一，三带二，炸弹，
		List<Integer> temp = listR;
		Map<Integer,Integer> map1 = new HashMap<>();
		for(int i = 0; i < temp.size(); i++) {
			//拆分，先拆出炸弹,三个，对子，单个，运用map集合
			if(map1.containsKey(temp.get(i))) {
				int temp1 = map1.get(temp.get(i)) + 1;
				map1.put(temp.get(i), temp1);
			} else {
				map1.put(temp.get(i), 1);
			}
		}
		//System.out.println(map1);
		String str = getGetter()[1];
		if(str.contains("单")) {
			String[] str1 = str.split("-");
			for(int i = 0; i < temp.size(); i++) {
				if(map1.get(temp.get(i)) == 1 && temp.get(i) > Integer.parseInt(str1[1])) {
					System.out.println("0出的牌" + str1[1] + "，1出的牌" + temp.get(i));
					break;
				}
			}
			//找到要出的牌   1、在界面出该牌（出牌后位置调整、出牌位置），2、在本集合map里面、list里面移除，3、将发牌消息写到文件里面，发给第三个人
		} else if(str.contains("对")) {
			System.out.println(str);
		} else if(str.contains("三个")) {
			System.out.println(str);
		} else if(str.contains("炸弹")) {
			System.out.println(str);
		}
	}
	
	/**
	 * 经过一系列复杂的判断，确定收到牌的人出什么牌
	 * 下面实现知道了出牌的类型和大小
	 */
	public void putCard(String info,List<Integer> list) {
		//对收牌人的牌进行分析  对子，串子，三带一，三带二，炸弹，
		List<Integer> temp = list;
		Map<Integer,Integer> map1 = new HashMap<>();
		//下面for循环，拆分出炸弹,三个，对子，单个，运用map集合
		for(int i = 0; i < temp.size(); i++) {
			if(map1.containsKey(temp.get(i))) {
				int temp1 = map1.get(temp.get(i)) + 1;
				map1.put(temp.get(i), temp1);
			} else {
				map1.put(temp.get(i), 1);
			}
		}
		map1.forEach((key,value) -> System.out.println("牌为" + key + "的有" + value + "张"));
		
		if(info.contains("单")) {
			//得到出的牌的大小
			String[] str = info.split("-");
			for(int i = 0 ; i < map1.size(); i++) { 
				if (map1.containsValue(2) && map1.get(i) > Integer.parseInt(str[1])) {
					System.out.println(map1.get(i));
					break;
				}
			}		
		} else if(info.contains("对")) {
			System.out.println(info);
		} else if(info.contains("三个")) {
			System.out.println(info);
		} else if(info.contains("炸弹")) {
			System.out.println(info);
		}
	}
	
	/**
	 * 移除界面打出的牌
	 * @param jl
	 */
	public void removCardInfo(JLabel jl) {
		int temp = 0;
		boolean flag = false;
		for(int i = 0; i < listB.size(); i++) {
			if(cardShow.get(map.get(jl)) == listB.get(i)) {
				temp = i;
				flag = true;
				break;
			}
		}
		if(flag) {
			listB.remove(temp);
		}
	}
	
	/**
	 * 保存出牌信息
	 * @param msg
	 */
	public void saveInfo(String msg) {
		try (FileWriter file = new FileWriter("text/info.txt")){
			file.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 拆分字符串，得到收消息的人和消息内容
	 */
	private String[] getGetter() {
		String[] str = {};
		if(getInfo() != "") {
			str = getInfo().split(":");
		}
		return str;
	}
	
	/**
	 * 添加三组人的卡片信息
	 */
	public void addCardInfo(JLabel[] jl) {
		for(int i = 0; i < jl.length; i++) {
			if(i % 3 == 0) {
				listL.add(cardShow.get(map.get(jl[i])));
			} else if (i % 3 == 1) {
				listB.add(cardShow.get(map.get(jl[i])));
			} else {
				listR.add(cardShow.get(map.get(jl[i])));
			}
		}
		listL.sort((o1,o2) -> o1 - o2);
		listB.sort((o1,o2) -> o1 - o2);
		listR.sort((o1,o2) -> o1 - o2);		
	}
}
