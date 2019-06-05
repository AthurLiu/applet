package View;

import javax.swing.*;

import Model.ConnectInfo;
import Model.SendCard;
import Model.Util;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class MainView extends JFrame implements CardInitPos,MouseListener,ActionListener{	
	//将54张牌的路径
	File[] files = FIlENAME.listFiles();		
	//54个label按键，用来包装牌
	JLabel[] jl = new JLabel[files.length];	
	//左边第一张牌位置，右边第一张牌位置，底部第一张牌位置,发牌位置
	private int lX = LX,lY = Y,bX = BX,bY= BY,rX = RX, rY= Y,fX = FX, fY = FY;
	private int cX = CX_B;
	
	JLabel jl_r,jl_l,jl_b,jl_r_name,jl_l_name,jl_b_name,jl_r_tip,jl_l_tip,jl_b_tip;
	JLabel jl_r_sucess,jl_l_sucess,jl_b_sucess,jl_r_fail,jl_l_fail,jl_b_fail;
	JPanel jp;
	JButton jb_chupai,jb_quxiao,jb_guaji;
	JMenuBar jmb;
	JMenu jm;
	JMenuItem jmi;
	CardInfoInit cd;
	SendCard sc;
	ConnectInfo ci;
	BackJpanel bj;
	
	public MainView() {	
		init();		
	}
		
	/**
	 * 新游戏（easy），撤消(easy)，出牌(1、判断牌是否合理，)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jmi)) {
			ci.newGame();
			this.dispose();
			new MainView();
		} else if (e.getSource().equals(jb_quxiao)) {
			//取消的操作，将提上去的牌全部撤回
			for (int i = 0; i < CARDNUM; i++) {
				if (i % 3 == 1 && jl[i].getY() == BY - 41) {				
					jl[i].setLocation(jl[i].getX(), jl[i].getY() + 41);	
				}
			}
			sc.clearSendInfo();
		} else {			
			//判断提上去的牌是否合理，合理则出牌，不合理则不出牌，判断规则
			if(sc.checkSendCard() == true) {
				for (int i = 0; i < CARDNUM; i++) {
					if (i % 3 == 1) {
						//消除已经出的牌
						if (jl[i].getY() == CY_B) {
							jl[i].setVisible(false);
						} 
						if (jl[i].getY() == BY - 41) {
							jl[i].setLocation(cX -= 30, CY_B);							
							sc.clearSendInfo();
							Util.saveInfo(0 + ":" + sc.getSendInfoShow() + ":" + 1);
							ci.removeCardInfo(jl[i]);
							ci.putCard();
							jb_guaji.setText("挂机中...");					} 			
					}
				}
				//对出剩下的牌的位置进行调整	
				int temp = BX - sc.getSendCardNum() * 17;
				for (int i = 0; i < CARDNUM; i++) {					
					if (jl[i].getY() == BY){							
						jl[i].setLocation(temp -= 30, BY );	
					}
				}
				cX = CX_B;
			}
		}		
	}
	
	/**
	 * 出牌线程，当有一人出完时结束线程
	 */
	public void putCardThread() {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					while(ci.getListL().size() != 0 && ci.getListB().size() != 0 && ci.getListR().size() != 0) {
						Thread.sleep(1000);						
						cardLocateAdjust();	
					}		
					if(ci.getListL().size() == 0) {
						jl_l_sucess.setVisible(true);
						jl_r_fail.setVisible(true);
						jl_b_fail.setVisible(true);
					} else if(ci.getListR().size() == 0) {
						jl_r_sucess.setVisible(true);
						jl_l_fail.setVisible(true);
						jl_b_fail.setVisible(true);
					} else if (ci.getListB().size() == 0){						
						jl_b_sucess.setVisible(true);
						jl_r_fail.setVisible(true);
						jl_l_fail.setVisible(true);
					} 
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}				
			}			
		}).start(); 
	}
	
	/**
	 * 对已经打出去的牌的位置和还没有打出去的牌的位置的调整
	 * @throws InterruptedException 
	 */
	public void cardLocateAdjust() throws InterruptedException {
		for(int j = 0; j < ci.getList().size(); j++) {
			if(ci.getList().get(j).getX() == RX) {
				int num = Y;
				for (int i = 0; i < CARDNUM; i++) {
					if(i % 3 == 2 && jl[i].getX() == CX_R) {
						jl[i].setVisible(false);
					} 
					if(i % 3 == 2 && jl[i].getX() == RX) {
						jl[i].setLocation(RX, num -= 30);
					}
				}
				jb_guaji.setText("挂机中.");
				setLoc(CX_R,CY_R);						
			} else if(ci.getList().get(j).getX() == LX) {
				int num = Y;
				for (int i = 0; i < CARDNUM; i++) {
					if(i % 3 == 0 && jl[i].getX() == CX_L) {
						jl[i].setVisible(false);
					} 
					if(i % 3 == 0 && jl[i].getX() == LX) {
						jl[i].setLocation(LX, num -= 30);
					}
				}
				jb_guaji.setText("挂机中..");
				setLoc(CX_L,CY_L);
			} else if(ci.getList().get(j).getY() == BY) {
				int num = BX;
				for (int i = 0; i < CARDNUM; i++) {
					if(i % 3 == 1 && jl[i].getY() == CY_B) {
						jl[i].setVisible(false);
					} 
					if(i % 3 == 1 && jl[i].getY() == BY) {
						jl[i].setLocation(num -= 30, BY);
					}
				}
				jb_guaji.setText("挂机中...");
				setLoc(CX_B,CY_B);
			} 								
		}	
	}
	
	/**
	 * 界面出牌
	 * 出一张牌，移除出牌模块里面该牌的信息
	 * @param x 出牌位置x坐标
	 * @param y 出牌位置y坐标
	 * @throws InterruptedException 
	 */
	public void setLoc(int x,int y) throws InterruptedException {
		for(int i = 0; i < ci.getList().size(); i++) {
			JLabel temp = ci.getList().get(i);
			if(x == CX_R || x == CX_L) {
				temp.setLocation(x ,y -= 30);
			} else {
				temp.setLocation(x-= 30 ,y);
			}			
			ci.removeCardInfo(temp);
		}
		ci.setList();
		ci.putCard();
		clearCard();
		Thread.sleep(2000);
	}
		
	/**
	 * 	界面初始化
	 */
	public void init() {
		ImageIcon image = new ImageIcon("touxiang/backimage.png");
		bj = new BackJpanel(image.getImage());
		bj.setBounds(0, 0, MAIN_X, MAIN_Y);		
		jmb = new JMenuBar();
		jm = new JMenu("选项");
		jmi = new JMenuItem("新游戏");
		cd = new CardInfoInit();
		jp = new JPanel();	
		jb_quxiao = new JButton("取消");
		jb_chupai = new JButton("出牌");
		jb_guaji = new JButton("挂机");
		jl_r = new JLabel(new ImageIcon("touxiang/girl2.jpg"));
		jl_l = new JLabel(new ImageIcon("touxiang/girl.jpg"));
		jl_b = new JLabel(new ImageIcon("touxiang/boy1.png"));
		jl_r_tip = new JLabel(new ImageIcon("touxiang/要不起.png"));
		jl_l_tip = new JLabel(new ImageIcon("touxiang/要不起.png"));
		jl_b_tip = new JLabel(new ImageIcon("touxiang/要不起.png"));
		jl_r_sucess = new JLabel(new ImageIcon("touxiang/胜利.jpg"));
		jl_l_sucess = new JLabel(new ImageIcon("touxiang/胜利.jpg"));
		jl_b_sucess = new JLabel(new ImageIcon("touxiang/胜利.jpg"));
		jl_r_fail = new JLabel(new ImageIcon("touxiang/失败.jpg"));
		jl_l_fail = new JLabel(new ImageIcon("touxiang/失败.jpg"));
		jl_b_fail = new JLabel(new ImageIcon("touxiang/失败.jpg"));
		jl_l_name = new JLabel("采菊东篱下");
		jl_r_name = new JLabel("悠然见南山");
		jl_b_name = new JLabel("仰望星空");
		jb_quxiao.addActionListener(this);
		jb_chupai.addActionListener(this);
		jb_guaji.addActionListener(this);
		jmi.addActionListener(this);
		
		//初始化,产生54张牌，把它们的名字和牌的信息分别存起来
		for (int i = 0; i < jl.length; i++) {
			jl[i] = new JLabel(new ImageIcon(files[i].getPath()));
			String cardName = files[i].getName().substring(0, files[i].getName().length() - 4);			
			cd.saveCardInfo(jl[i], Integer.parseInt(cardName));
			jl[i].addMouseListener(this);
		}
		sc = new SendCard();	
		ci = new ConnectInfo();
		jl_l.setBounds(TL_X, T_Y, 100, 100);
		jl_r.setBounds(TR_X, T_Y, 100, 100);
		jl_b.setBounds(TL_X + 50, Y + 130, 100, 100);
		jl_l_name.setBounds(TL_X + 10, T_Y - 5, 100, 20);
		jl_r_name.setBounds(TR_X + 10, T_Y - 5, 100, 20);
		jl_b_name.setBounds(TL_X + 70, Y + 130, 100, 15);
		jl_b_tip.setBounds(QUXIAO_X - 150, QUXIAO_Y - 20, 100, 100);
		jl_l_tip.setBounds(TL_X + 120, T_Y + 120, 100, 100);
		jl_r_tip.setBounds(TR_X - 120, T_Y + 120, 100, 100);
		jl_r_sucess.setBounds(TR_X - 120, T_Y + 120, 100, 100);
		jl_l_sucess.setBounds(TL_X + 120, T_Y + 120, 100, 100);
		jl_b_sucess.setBounds(QUXIAO_X - 150, QUXIAO_Y - 20, 100, 100);
		jl_r_fail.setBounds(TR_X - 120, T_Y + 120, 100, 100);
		jl_l_fail.setBounds(TL_X + 120, T_Y + 120, 100, 100);
		jl_b_fail.setBounds(QUXIAO_X - 150, QUXIAO_Y - 20, 100, 100);
		jb_quxiao.setBounds(QUXIAO_X, QUXIAO_Y, 100, 35);
		jb_chupai.setBounds(CHUPAI_X, CHUPAI_Y, 100, 35);
		jb_guaji.setBounds(QUXIAO_X + 125, QUXIAO_Y, 100, 35);
		jmb.setBounds(0, 0,MAIN_X,20);
		jmb.setBackground(Color.CYAN);
		jl_b_tip.setVisible(false);
		jl_l_tip.setVisible(false);
		jl_r_tip.setVisible(false);
		jl_r_sucess.setVisible(false);
		jl_l_sucess.setVisible(false);
		jl_b_sucess.setVisible(false);
		jl_r_fail.setVisible(false);
		jl_l_fail.setVisible(false);
		jl_b_fail.setVisible(false);
		
		bj.add(jl_r_sucess);
		bj.add(jl_l_sucess);
		bj.add(jl_b_sucess);
		bj.add(jl_r_fail);
		bj.add(jl_l_fail);
		bj.add(jl_b_fail);
		bj.add(jl_l);
		bj.add(jl_r);
		bj.add(jl_b);
		bj.add(jl_l_name);
		bj.add(jl_r_name);
		bj.add(jl_b_name);
		bj.add(jl_b_tip);
		bj.add(jl_r_tip);
		bj.add(jl_l_tip);
		jm.add(jmi);
		jmb.add(jm);				
		bj.add(jmb);
		bj.add(jb_chupai);
		bj.add(jb_quxiao);
		bj.add(jb_guaji);
		bj.setLayout(null); 
		jp.add(bj);		
		jp.setLayout(null); 
				
		this.add(jp);
		this.setTitle("斗地主liu's");
		this.setSize(MAIN_X, MAIN_Y);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		sendCardThread();	
		putCardThread();
	}
		
	/**
	 * 	发牌线程，只执行一次，然后dead
	 */
	private void sendCardThread() {
		new Thread(new Runnable() {				
			@Override
			public void run() {
				jl = cd.getChangeCardOrder();
				ci.saveInfo();
				//初始化每一张牌的位置
				for(int i = 0; i < jl.length; i++) {
					jl[i].setBounds(FX, FY, 132, 165);
					bj.add(jl[i]);	
				}
				//发牌，顺序分别为左边，下面，右面
				for (int i = 0; i < jl.length; i++) {
					if(i % 3 == 0) {
						Move(lX, lY -= 30,jl[i]);
					} else if (i % 3 == 1) {
						Move(bX -= 30, bY,jl[i]);
					} else {
						Move(rX, rY -= 30,jl[i]);
					}		
				}
			}		
		}).start();
	}
		
	/**
	 *	 发牌时牌的移动效果
	 * @param x 目标位置X坐标
	 * @param y 目标位置Y坐标
	 * @param jl 要发过去的牌
	 */
	private void Move(int x,int y, JLabel jl) {
		int beginX = fX, beginY = fY;	
		for (int i = 0 ; i < 10; i++) {						
			try {
				Thread.sleep(SPEED);					
				jl.setLocation(beginX -= (fX - x)/10 , beginY -= (fY - y)/10);					
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}					
	}
	
	public static void main(String[] args) {
		new MainView();
	}
	
	/**
	 * 	鼠标点击两次，牌的位置固定在上面，再点击两次，牌下移
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			for (int i = 0; i < CARDNUM; i++) {
				if (i % 3 == 1 && e.getSource().equals(jl[i]) && jl[i].getY() == BY - 40) {				
					jl[i].setLocation(jl[i].getX(), jl[i].getY() - 1);	
					sc.saveSendInfo(jl[i]);
					break;
				}
				if (i % 3 == 1 && e.getSource().equals(jl[i]) && jl[i].getY() == BY - 41) {				
					jl[i].setLocation(jl[i].getX(), jl[i].getY() + 41);	
					sc.reMoveSendInfo(jl[i]);
					break;
				}
			}
		}		
	}
		
	/**
	 *	 鼠标移到指定的牌上面，该牌上移
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = 0 ; i < CARDNUM; i++) {
			if(e.getSource().equals(jl[i]) && i % 3 == 1 && jl[i].getY() == BY) {
				jl[i].setLocation(jl[i].getX(), jl[i].getY() - 40);
			}
		}			
	}
	
	/**
	 * 鼠标移出指定的牌上面，该牌归位
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		for(int i = 0 ; i < CARDNUM; i++) {
			if(e.getSource().equals(jl[i]) && i % 3 == 1 && jl[i].getY() == (BY - 40)) {
				jl[i].setLocation(jl[i].getX(), jl[i].getY() + 40);
			}
		}				
	}
		
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	/**
	 * 当某一个人一轮牌出完获胜时，清除掉两个失败者出的牌
	 * @throws InterruptedException 
	 */
	public void clearCard() throws InterruptedException {
		if(ci.putCardPeople == 0) {			
			Thread.sleep(1000);		
			jl_r_tip.setVisible(true);
			for (int i = 0; i < CARDNUM; i++) {
				if(i % 3 == 2 && jl[i].getX() == CX_R) {
					jl[i].setVisible(false);					
				} 
				if(i % 3 == 0 && jl[i].getX() == CX_L) {
					jl[i].setVisible(false);					
				} 
			}
			jl_l_tip.setVisible(true);
			Thread.sleep(1000);
		} else if(ci.putCardPeople == 1) {	
			Thread.sleep(1000);
			jl_l_tip.setVisible(true);
			for (int i = 0; i < CARDNUM; i++) {
				if(i % 3 == 0 && jl[i].getX() == CX_L) {
					jl[i].setVisible(false);					
				}				
				if(i % 3 == 1 && jl[i].getY() == CY_B) {
					jl[i].setVisible(false);					
				} 
			}	
			jl_b_tip.setVisible(true);
			Thread.sleep(1000);
		} else if(ci.putCardPeople == 2) {
			Thread.sleep(1000);
			jl_b_tip.setVisible(true);
			for (int i = 0; i < CARDNUM; i++) {
				if(i % 3 == 1 && jl[i].getY() == CY_B) {
					jl[i].setVisible(false);					
				} 
				if(i % 3 == 2 && jl[i].getX() == CX_R) {
					jl[i].setVisible(false);					
				} 
			}	
			jl_r_tip.setVisible(true);
			Thread.sleep(1000);
		} 
		ci.putCardPeople = 3;
		jl_r_tip.setVisible(false);
		jl_l_tip.setVisible(false);
		jl_b_tip.setVisible(false);
	}
}
