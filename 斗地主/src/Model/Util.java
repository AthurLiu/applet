package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  一些通用的方法
 * @author 幽竹 2019-6-4
 *
 */
public class Util {
	/**
	 * 	设置出牌消息，调用saveinfo()函数存起来存起来
	 * @param x 出牌人
	 * @param str 出牌信息
	 */
 	public static void setPutCardMeg(int x,String str) {
		if(x == 0) {
			saveInfo(0 + str + 1);
		} else if(x == 1) {
			saveInfo(1 + str + 2);
		} else {
			saveInfo(2 + str + 0);
		}	
	}
	
	/**
	 * 保存出牌信息
	 * @param msg
	 */
 	public static void saveInfo(String msg) {
		try (FileWriter file = new FileWriter("text/info.txt")){
			file.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 	
	/**
	 * 	获取一个List<Integer> 类型的temp集合里面的元素有多少种，每一种有几个
	 * @param temp 要参与统计的List<Integer> 类型的temp集合
	 * @return 一个map，key值表示元素值，value表示该值的元素有几个
	 */
 	public static Map<Integer,Integer> getCardType(List<Integer> temp) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < temp.size(); i++) {
			if(map.containsKey(temp.get(i))) {
				map.put(temp.get(i), map.get(temp.get(i)) + 1);
			} else {
				map.put(temp.get(i), 1);
			}
		}
		return map;
	}
 	
	/**
	 * 得到别人发给我的消息
	 * @return
	 */
	private static String getInfo() {
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
	 * 拆分字符串，得到收消息的人和消息内容
	 */
	public static String[] getGetter() {
		String[] str = {};
		if(getInfo() != "") {
			str = getInfo().split(":");
		}
		return str;
	}
}


