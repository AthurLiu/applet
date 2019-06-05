package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JLabel;
import View.CardInfoInit;
/**
 * 手动出牌的类(目前没怎么用到)
 * @author 13600
 *
 */
public class SendCard {
	//建一个map集合，参数一，存放图片的jlabel的名字,参数二，存放的图片的的显示信息
	private Map<JLabel,Integer> map = CardInfoInit.getMap();
	//存放牌的名字和它对应的信息
	private Map<Integer,Integer> cardShow = CardInfoInit.getCardShow();
	//存放双击JLabel按键点击上去的出的牌的信息         
	private List<Integer> sendInfo = new ArrayList<>();
	
	//出的是什么牌，比如，单个，串子，对子，三个...
	private String sendInfoShow;	
	//主要用于底部卡片的重新布局
	private int sendCardNum = 0;
	
	public int getSendCardNum() {
		return sendCardNum;
	}
	public String getSendInfoShow() {
		return sendInfoShow;
	}
	
	/**
	 * 出牌信息的检查，即哪些牌可以出，哪些不可以
	 * --单个over，对子over，三个over，炸弹over,三带一over，串子（长度4）over--
	 * --三带2，四带一，串子5--
	 * --飞机不带任何东西，连对（3），串子6--
	 * --串子7over--
	 * --飞机带两个单的、连对（4）、串子8
	 * --串子9over--
	 * --飞机带两个对子、连对（5）、串子10、--
	 * --串子11over--
	 * --串子12over--
	 * --串子13over--
	 * --串子14over--
	 * @return
	 */
	public boolean checkSendCard() {
		Set<Integer> set = new HashSet<Integer>();
		boolean flag = false;
		if(sendInfo.size() == 1) {
			flag = true;
			sendInfoShow = "单-" + sendInfo.get(0);
			sendCardNum++;
		} else if (sendInfo.size() == 2 && sendInfo.get(0) == sendInfo.get(1)) {
			flag = true;
			sendInfoShow = "对-" + sendInfo.get(0);
			sendCardNum += sendInfo.size();
		} else if (sendInfo.size() == 3) {
			for (int i = 0; i < sendInfo.size(); i++) {
				set.add(sendInfo.get(i));
			}
			if (set.size() == 1) {
				flag = true;
				sendInfoShow = "三个-" + sendInfo.get(0);
				sendCardNum += sendInfo.size();
			} 
		} else if (sendInfo.size() == 4) {
			sendInfo.sort((o1,o2) -> (o1 - o2));
			for (int i = 0; i < sendInfo.size(); i++) {
				set.add(sendInfo.get(i));
			}
			//begin判断 炸弹，三代一，串子
			if (set.size() == 1) {
				flag = true;
				sendInfoShow = "炸弹-" + sendInfo.get(0);
				sendCardNum += sendInfo.size();
			} else if(set.size() == 2 && (sendInfo.get(0) == sendInfo.get(1) || sendInfo.get(2) == sendInfo.get(3))) {
				flag = true;
				sendInfoShow = "三带一";
				sendCardNum += sendInfo.size();
			} else if(set.size() == 4 && isChuanzi(sendInfo)) {
				flag = true;
				sendInfoShow = "顺子" + sendInfo.size();
				sendCardNum += sendInfo.size();
			} else {
				flag = false;
			}
		} else if (sendInfo.size() == 7 || sendInfo.size() == 9 || sendInfo.size() == 11 || sendInfo.size() == 12 || sendInfo.size() == 13 || sendInfo.size() == 14) {
			sendInfo.sort((o1,o2) -> (o1 - o2));
			for (int i = 0; i < sendInfo.size(); i++) {
				set.add(sendInfo.get(i));
			} 
			if(set.size() == sendInfo.size() && isChuanzi(sendInfo)) {
				flag = true;
				sendInfoShow = "顺子" + sendInfo.size();
				sendCardNum += sendInfo.size();
			}
		}
		return flag;
	}
	
	/**
	 * 判断要出的牌是否是串子
	 * @param list
	 * @return
	 */
	public boolean isChuanzi(List<Integer> list) {
		boolean flag = false;
		for (int i = 0; i < list.size() - 1; i++) {
			if(sendInfo.get(i + 1) - sendInfo.get(i) == 1) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * 存放出牌信息
	 */
	public void saveSendInfo(JLabel send) {
		sendInfo.add(cardShow.get(map.get(send)));
	}
	
	/**
	 * 移除某个牌的出牌信息
	 */
	public void reMoveSendInfo(JLabel send) {
		if(sendInfo.size() != 0 ) {
			int num = 0;
			for (int i = 0; i < sendInfo.size(); i++) {
				if(sendInfo.get(i) == cardShow.get(map.get(send))){
					num = i;
					break;
				}
			}
			sendInfo.remove(num);
		}	
	}
	
	/**
	 * 取消按键引发的操作，清空集合
	 */
	public void clearSendInfo() {
		sendInfo.clear();
	}
}
