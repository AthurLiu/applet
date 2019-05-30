package MyCalculate.view;

import java.awt.*;
import javax.swing.*;
import Calculate.mode.CalDataInputType;
import java.awt.event.*;

public class CalculateViewSimple extends JFrame implements ActionListener{
	//参与界面的控件  
	JMenuBar jmb;
	JMenu jm1,jm2,jm3;
	JMenuItem jm1_1,jm1_2,jm2_1,jm2_2,jm3_1,jm3_2;
    String [] str = {"1/x","del","CE","+","7","8","9","-","4","5"
    		,"6","*","1","2","3","/","0",".","%","="};
    JButton[] jb = new JButton[str.length];
	JTextField jtf;
	JPanel jp,jp1;
	
	//该flag是区别<运算符+数字+=>与<数字+=>
	boolean flag = false;
	CalDataInputType calType = new CalDataInputType();

	public static void main(String[] args) {
		new CalculateViewSimple();
	}
	
	public CalculateViewSimple() {		
		init();
	}
	
	/**
	 * 窗口初始化
	 */
	public void init() {
		jmb = new JMenuBar();
		jm1 = new JMenu("查看");
		jm2 = new JMenu("编辑");
		jm3 = new JMenu("帮助");
		jm1_1 = new JMenuItem("标准型");
		jm1_2 = new JMenuItem("科学型");
		jm1_2.addActionListener(this);
		jm3_1 = new JMenuItem("查看帮助");
		jm3_1.addActionListener(this);
		jm3_2 = new JMenuItem("关于计算器");
		jm3_2.addActionListener(this);
		jtf = new JTextField();
		jp1 = new JPanel(new GridLayout(2,1));
		jp = new JPanel(new GridLayout(5, 4, 10, 10));
		
		jm1.add(jm1_1);
		jm1.add(jm1_2);
		jm3.add(jm3_1);
		jm3.add(jm3_2);
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jp1.add(jmb);
		jp1.add(jtf);
				
		for(int i = 0; i < jb.length; i++) {
			jb[i] = new JButton(str[i]);
			jp.add(jb[i]);
			jb[i].addActionListener(this);
		}
		
		//控件的属性设置
		jtf.setPreferredSize(new Dimension(240,50));
		jtf.setFont(new Font("宋体",Font.BOLD,22));	
		
		//整个窗口的属性设置
		this.add(jp1,BorderLayout.NORTH);	
		this.add(jp);
		this.setTitle("liu's 3.0版");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 400);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean findkey = true;
		String[] str = {"1","2","3","4","5","6","7","8","9","0"};
		if (findkey) {
			for(String x : str) {
				if(e.getActionCommand().equals(x)) {
					inputNum(e.getActionCommand());	
					findkey = false;
					break;
				}
			}
		}
		String[] str1 = {"+","-","*","/","%"};
		if (findkey) {
			for(String x : str1) {
				if(e.getActionCommand().equals(x)) {
					inputOper(e.getActionCommand());
					findkey = false;
					break;
				}
			}
		}	
		if (findkey) {
			if (e.getActionCommand().equals("1/x")){
				inputNum1(e.getActionCommand());
			} else if (e.getActionCommand().equals(".")) {
				inputPoint(".");
			} else if (e.getActionCommand().equals("CE")) {
				jtf.setText(calType.clear()); 
			} else if (e.getActionCommand().equals("del")) {
				inputDel();
			} else if (e.getActionCommand().equals("=")) {
				equals("=");
			} else if(e.getSource() == jm1_2) {
				new CalculateViewScience();
				this.dispose();
			} else if(e.getSource() == jm3_1) {
				new CalculateViewHelper(); 
			} else if(e.getSource() == jm3_2) {
				new AboutCalculateView();
			}
		}	
	}
	
	/**
	 * 按位删除
	 */
	private void inputDel() {
		if((calType.getCalType().equals("2"))) {
			jtf.setText(calType.del());
		} else if (calType.getCalType().equals("3")) {
			jtf.setText(calType.del());
		} else if (calType.getCalType().equals("4")) {
			jtf.setText(calType.del());
		}
	}
		
	/**
	 *  运算类型-----------<数字+运算符>
	 */
	public void inputNum1(String x) {
		if (calType.getCalType().equals("2") || calType.getCalType().equals("8")){
			calType.setCalType("8");
			jtf.setText(calType.equalsInput2(x));
		} else if ((calType.getCalType().equals("5"))) {
			jtf.setText(calType.equalsInput2(x));
		} 
	}
	
	/**
	 * 输入数字的处理
	 */
	public void inputNum(String x) {
		if (calType.getCalType().equals("1") || calType.getCalType().equals("2")){			
			jtf.setText(calType.jTextNumInput(x));
			calType.setCalType("2");
		} else if (calType.getCalType().equals("3") || calType.getCalType().equals("4")) {
			calType.setCalType("4");
			jtf.setText(calType.jTextNumInput(x));
		} else if (calType.getCalType().equals("6")) {
			calType.setCalType("4");
			jtf.setText(calType.jTextNumInput(x));
		} else if (calType.getCalType().equals("5") || calType.getCalType().equals("7")) {
			jtf.setText(calType.clear()); 
			jtf.setText(calType.jTextNumInput(x));
			calType.setCalType("2");
		} else if (calType.getCalType().equals("8")) {
			jtf.setText(calType.clear()); 
			jtf.setText(calType.jTextNumInput(x));
			calType.setCalType("2");
		}
	}
	
	/**
	 * 运算类型-----------<数字+运算符+数字>
	 */
	public void inputOper(String x) {
		if (calType.getCalType().equals("2") || calType.getCalType().equals("3")) {
			calType.setCalType("3");
			jtf.setText(calType.jTextOperInput(x));				
		} else if (calType.getCalType().equals("5") || calType.getCalType().equals("6") || calType.getCalType().equals("7")) {
			calType.setCalType("6");
			jtf.setText(calType.jTextOperInput(x));	
		} else if (calType.getCalType().equals("4")) {
			jtf.setText(calType.jTextOperInput(x));	
		} else if (calType.getCalType().equals("8")) {
			calType.setCalType("3");
			jtf.setText(calType.jTextOperInput(x));	
		}
	}
	
	/**
	 * 运算结果
	 * @param x
	 */
	public void equals(String x) {
		if(calType.getCalType().equals("4")) {
			calType.setCalType("5");
			jtf.setText(calType.equalsInput(x));	
		} else if (calType.getCalType().equals("5") || calType.getCalType().equals("7")) {
			calType.setCalType("7");
			jtf.setText(calType.equalsInput(x));
		} else if (calType.getCalType().equals("2") && flag == true) {
			jtf.setText(calType.equalsInput(x));
			flag = false;
		}
	}
	
	/**
	 * 输入点
	 * @param x
	 */
	public void inputPoint(String x) {
		if (calType.getCalType().equals("2"))	{
			jtf.setText(calType.pointInput(x));
		} else if (calType.getCalType().equals("4")) {
			calType.setCalType("4");
			jtf.setText(calType.pointInput(x));
		} 
	}
}
