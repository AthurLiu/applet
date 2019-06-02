package ClientView;

import javax.swing.*;

import ClientModel.ConnectInfo;
import ClientModel.SendCard;
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
	
	JLabel jl_r,jl_l,jl_info;
	JPanel jp;
	JButton jb_chupai,jb_quxiao;
	JMenuBar jmb;
	JMenu jm;
	JMenuItem jmi;
	CardInfoInit cd;
	SendCard sc;
	ConnectInfo ci;
	
	public MainView() {	
		init();		
	}
		
	/**
	 * 新游戏（easy），撤消(easy)，出牌(1、判断牌是否合理，)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jmi)) {
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
						if (jl[i].getY() == CX_B) {
							jl[i].setVisible(false);
						} 
						if (jl[i].getY() == BY - 41) {
							jl[i].setLocation(cX -= 30, CX_B);							
							sc.clearSendInfo();
//							jl_info.setText(sc.getSendInfoShow());
							//思路，将出牌信息写入到文件里面，然后关闭文件，再讲文件里面的信息读出来，判断是哪一个要出牌，
							ci.saveInfo(0 + ":" + sc.getSendInfoShow() + ":" + 1);
							ci.removCardInfo(jl[i]);
							ci.show();
						} 			
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
	
	public void putCardThread() {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					while(ci.getListL().size() != 0 && ci.getListB().size() != 0 && ci.getListR().size() != 0) {
						Thread.sleep(3000);	
						//右边出牌
						if(ci.getPutJLable() != null && ci.getPutJLable().getX() == RX) {
							int num = Y;
							for (int i = 0; i < CARDNUM; i++) {
								if(i % 3 == 2 && jl[i].getX() == CX_R) {
									jl[i].setVisible(false);
								} 
							}
							for (int i = 0; i < CARDNUM; i++) {
								if(i % 3 == 2 && jl[i].getX() == RX) {
									jl[i].setLocation(RX, num -= 30);
								}
							}
							JLabel temp = ci.getPutJLable();
							temp.setLocation(CX_R ,CY_R);
							ci.removCardInfo(temp);
							ci.show();
							
						} else if(ci.getPutJLable() != null && ci.getPutJLable().getX() == LX) {
							int num = Y;
							for (int i = 0; i < CARDNUM; i++) {
								if(i % 3 == 0 && jl[i].getX() == CX_L) {
									jl[i].setVisible(false);
								} 
							}
							for (int i = 0; i < CARDNUM; i++) {
								if(i % 3 == 0 && jl[i].getX() == LX) {
									jl[i].setLocation(LX, num -= 30);
								}
							}
							JLabel temp = ci.getPutJLable();
							temp.setLocation(CX_L ,CY_L);
							ci.removCardInfo(temp);
							ci.show();
						} else if(ci.getPutJLable() != null && ci.getPutJLable().getY() == BY) {
							int num = BX;
							for (int i = 0; i < CARDNUM; i++) {
								if(i % 3 == 1 && jl[i].getY() == CX_B) {
									jl[i].setVisible(false);
								} 
							}
							for (int i = 0; i < CARDNUM; i++) {
								if(i % 3 == 1 && jl[i].getY() == BY) {
									jl[i].setLocation(num -= 30, BY);
								}
							}
							JLabel temp = ci.getPutJLable();
							temp.setLocation(CX_B ,CX_B);
							ci.removCardInfo(temp);
							ci.show();
						} 						
					}										
					//显示gameover,某个人获胜
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}				
			}			
		}).start(); 
	}
	
	/**
	 * 界面初始化
	 */
	public void init() {
		jmb = new JMenuBar();
		jm = new JMenu("选项");
		jmi = new JMenuItem("新游戏");
		cd = new CardInfoInit();
		jp = new JPanel();		
		jb_quxiao = new JButton("取消");
		jb_chupai = new JButton("出牌");
		jl_r = new JLabel(new ImageIcon("touxiang/girl2.jpg"));
		jl_l = new JLabel(new ImageIcon("touxiang/girl.jpg"));
		jl_info = new JLabel();
		jb_quxiao.addActionListener(this);
		jb_chupai.addActionListener(this);
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
		jb_quxiao.setBounds(QUXIAO_X, QUXIAO_Y, 100, 35);
		jb_chupai.setBounds(CHUPAI_X, CHUPAI_Y, 100, 35);
		jl_info.setBounds(QUXIAO_X + 155, QUXIAO_Y, 100, 35);
		jl_info.setForeground(Color.yellow);
		jmb.setBounds(0, 0,MAIN_X,20);
		jmb.setBackground(Color.GRAY);
		
		jp.add(jl_info);
		jp.add(jl_l);
		jp.add(jl_r);
		jm.add(jmi);
		jmb.add(jm);				
		jp.add(jmb);
		jp.add(jb_chupai);
		jp.add(jb_quxiao);
		jp.setBackground(Color.DARK_GRAY);
		jp.setLayout(null); 
				
		this.add(jp);
		this.setTitle("斗地主liu's");
		this.setSize(MAIN_X, MAIN_Y);
		this.setVisible(true);
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
					jp.add(jl[i]);	
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
	 * 发牌时牌的移动效果
	 * @param x 目标位置X坐标
	 * @param y 目标位置Y坐标
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
	 * 鼠标点击两次，牌的位置固定在上面，再点击两次，牌下移
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
	 * 鼠标移到指定的牌上面，该牌上移
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
}
