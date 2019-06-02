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
	//三张表，用来放牌在界面里的的属性和对应的显示信息
	private Map<JLabel,Integer> mapL = new HashMap<>();
	private Map<JLabel,Integer> mapB = new HashMap<>();
	private Map<JLabel,Integer> mapR = new HashMap<>();
	//打牌的
	private List<Integer> listL = new ArrayList<>();
	private List<Integer> listB = new ArrayList<>();
	private List<Integer> listR = new ArrayList<>();
	//出牌人 下 右 左 默认是 0,1,2
	private String sendMsg;
	private JLabel putJLable = null;
	
	public String getSendMsg() {
		return sendMsg;
	}
	public JLabel getPutJLable() {
		return putJLable;
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
		//map1.forEach((key,value) -> System.out.println("牌为" + key + "的有" + value + "张"));
		
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
	
	public void show() {
		List<Integer> temp = null;
		Map<JLabel,Integer> mapT = null;
		if(getGetter()[2].equals("1")) {
			temp = listR;
			mapT = mapR;
		} else if(getGetter()[2].equals("2")) {
			temp = listL;
			mapT = mapL;
		} else {
			temp = listB;
			mapT = mapB;
		}
		int num = 0;
		//对收牌人的牌进行分析  对子，串子，三带一，三带二，炸弹，
		
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < temp.size(); i++) {
			//拆分，先拆出炸弹,三个，对子，单个，运用map集合
			if(map.containsKey(temp.get(i))) {
				int temp1 = map.get(temp.get(i)) + 1;
				map.put(temp.get(i), temp1);
			} else {
				map.put(temp.get(i), 1);
			}
		}
		//System.out.println(map1);
		String str = getGetter()[1];
		if(str.contains("单")) {
			String[] str1 = str.split("-");
			for(int i = 0; i < temp.size(); i++) {
				if(map.get(temp.get(i)) == 1 && temp.get(i) > Integer.parseInt(str1[1])) {
					System.out.println("0出的牌" + str1[1] + "，1出的牌" + temp.get(i));
					num = temp.get(i);
					if(getGetter()[2].equals("1")) {
						sendMsg = 1 + ":单-" + temp.get(i) + ":" + 2;
					} else if(getGetter()[2].equals("2")) {
						sendMsg = 2 + ":单-" + temp.get(i) + ":" + 0;
					} else {
						sendMsg = 0 + ":单-" + temp.get(i) + ":" + 1;
					}					
					saveInfo(sendMsg);
					break;
				}
			}

			for(Map.Entry<JLabel,Integer> str2 : mapT.entrySet()){
			   if(num == str2.getValue()){
			       putJLable = str2.getKey();
			   }
			}
			//找到要出的牌   1、在界面出该牌（出牌后位置调整、出牌位置），2、在本集合map里面、list里面移除，3、将发牌消息写到文件里面，发给第三个人
			//找到出的牌temp.get(i)对应的jl
			
		} else if(str.contains("对")) {
			System.out.println(str);
		} else if(str.contains("三个")) {
			System.out.println(str);
		} else if(str.contains("炸弹")) {
			System.out.println(str);
		}
	}
	
	/**
	 * 移除界面打出的牌
	 * mapB里面移除一组数据
	 * @param jl
	 */
	public void removCardInfo(JLabel jl) {
		int temp = 0;
		boolean flag = false;
		if(mapB.containsKey(jl)) {
			for(int i = 0; i < listB.size(); i++) {
				if(mapB.get(jl) == listB.get(i)) {
					temp = i;
					flag = true;
				}
			}
			if(flag) {
				listB.remove(temp);
				mapB.remove(jl);
			}
		} else if(mapR.containsKey(jl)) {
			for(int i = 0; i < listR.size(); i++) {
				if(mapR.get(jl) == listR.get(i)) {
					temp = i;
					flag = true;
				}
			}
			if(flag) {
				listR.remove(temp);
				mapR.remove(jl);
			}
		} else {
			for(int i = 0; i < listL.size(); i++) {
				if(mapL.get(jl) == listL.get(i)) {
					temp = i;
					flag = true;
				}
			}
			if(flag) {
				listL.remove(temp);
				mapL.remove(jl);
			}
		}
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
}
