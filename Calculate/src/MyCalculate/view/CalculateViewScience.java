package MyCalculate.view;

import java.awt.*;
import javax.swing.*;
import Calculate.mode.CalDataInputType;
import java.awt.event.*;

public class CalculateViewScience extends JFrame implements ActionListener{
	//参与界面的控件  
	
	JRadioButton jrb1,jrb2,jrb3,jrb4;
	JMenuBar jmb;
	JMenu jm1,jm3;
	JMenuItem jm1_1,jm1_2,jm2_1,jm2_2,jm3_1,jm3_2;
    String [] str = {"sin","cos","tan","ln","!","asin","acos","atan","log","π"
    		,"x^2","x^3","x^n","+/-","e","√","3√","n√","%","a","1/x","del","CE"
    		,"+","b","7","8","9","-","c","4","5","6","*","d","1","2","3","/","e",
    		"0",".","Ans","=","f"};
    JButton[] jb = new JButton[str.length];
	JTextField jtf;
	JPanel jp,jp1,jp2;
	
	//该flag是区别<运算符+数字+=>与<数字+=>
	boolean flag = false;
	//Ans控件的限定
	boolean ans = true;
	CalDataInputType calType = new CalDataInputType();

	public CalculateViewScience() {			
		//控件的属性设置
		init();
		initDec();
		jrb3.setSelected(true);
		jtf.setPreferredSize(new Dimension(240,50));
		jtf.setFont(new Font("宋体",Font.BOLD,22));	
		
		//整个窗口的属性设置
		this.add(jp1,BorderLayout.NORTH);		
		this.add(jp);
		this.setTitle("liu's 3.0版");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 580);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//String reg = "^[0-9]*$";
		//是否找到点击的按键，找到执行之后就将findkey设为false，就可以避免一些不必要的操作
		boolean findkey = true;
		String[] str = {"1","2","3","4","5","6","7","8","9","0","a","b","c","d","e","f"};	
		if (findkey) {
			for(String x : str) {
				if(e.getActionCommand().equals(x)) {
					inputNum(e.getActionCommand());	
					findkey = false;
					break;
				}
			}
		}
		String[] str1 = {"+","-","*","/","%","x^n","n√"};
		if (findkey) {
			for(String x : str1) {
				if(e.getActionCommand().equals(x)) {
					inputOper(e.getActionCommand());
					findkey = false;
					break;
				}
			}
		}		
		String[] str2 = {"asin","acos","atan","ln","log","sin","cos","tan","√","3√"};
		if (findkey) {
			for(String x : str2) {
				if(e.getActionCommand().equals(x)) {
					inputNum1(e.getActionCommand());
					findkey = false;
					break;
				}
			}
		}		
		String[] str3 = {"!","1/x","x^2","x^3","+/-"};
		if (findkey) {
			for(String x : str3) {
				if(e.getActionCommand().equals(x)) {
					inputNum2(e.getActionCommand());
					findkey = false;
					break;
				}
			}
		}	
		if (findkey) {
			if (e.getActionCommand().equals(".")) {
				inputPoint(".");
			} else if (e.getActionCommand().equals("CE")) {
				jtf.setText(calType.clear()); 
			} else if (e.getActionCommand().equals("del")) {
				inputDel();
			} else if (e.getActionCommand().equals("=")) {
				equals("=");
			} else if(e.getSource().equals(jm1_1)) {
				new CalculateViewSimple();
				this.dispose();
			} else if(e.getSource().equals(jm3_1)) {
				new CalculateViewHelper();
			} else if(e.getSource().equals(jm3_2)) {
				new AboutCalculateView();
			} else if (e.getActionCommand() == "十进制") {
				initDec();
			} else if (e.getActionCommand() == "十六进制") {
				initHex();
			} else if (e.getActionCommand() == "八进制") {
				initOct();
			} else if (e.getActionCommand() == "二进制") {
				initBin();
			} else if (e.getActionCommand().equals("π") && ans == true) {			
				inputNum(String.valueOf(Math.PI));		
				ans = false;
			} else if (e.getActionCommand().equals("e") && ans == true) {
				inputNum(String.valueOf(Math.E));	
				ans = false;
			} else if (e.getActionCommand().equals("Ans") && ans == true) {													
				inputNum(calType.getResult());
				ans = false;
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
	public void inputNum2(String x) {
		if (calType.getCalType().equals("2") || calType.getCalType().equals("8")){
			calType.setCalType("8");
			jtf.setText(calType.equalsInput2(x));
		} else if ((calType.getCalType().equals("5"))) {
			jtf.setText(calType.equalsInput2(x));
		} 
	}
	/**
	 *  运算类型-----------<运算符+数字>
	 * @param x
	 */
	public void inputNum1(String x) {
		if (calType.getCalType().equals("1")) {
			jtf.setText(calType.equalsInput1(x));
			ans = true;
		} else if (calType.getCalType().equals("5")){
			jtf.setText(calType.clear());
			jtf.setText(calType.equalsInput1(x));
		} 
		flag = true;
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
	 * 运算符输入
	 */
	public void inputOper(String x) {
		if (calType.getCalType().equals("2") || calType.getCalType().equals("3")) {
			calType.setCalType("3");
			jtf.setText(calType.jTextOperInput(x));	
			ans = true;
		} else if (calType.getCalType().equals("5") || calType.getCalType().equals("6") || calType.getCalType().equals("7")) {
			calType.setCalType("6");
			jtf.setText(calType.jTextOperInput(x));	
			ans = true;
		} else if (calType.getCalType().equals("4")) {
			ans = true;
			jtf.setText(calType.jTextOperInput(x));	
		} else if (calType.getCalType().equals("8")) {
			ans = true;
			calType.setCalType("3");
			jtf.setText(calType.jTextOperInput(x));	
		}
	}
	
	/**
	 * 运算结果
	 * @param x
	 */
	public void equals(String x) {
		try {
			if(calType.getCalType().equals("4")) {
				calType.setCalType("5");
				jtf.setText(calType.equalsInput(x));
				jb[9].setEnabled(true);
				jb[14].setEnabled(true);
			} else if (calType.getCalType().equals("5") || calType.getCalType().equals("7")) {
				calType.setCalType("7");
				jtf.setText(calType.equalsInput(x));
			} else if (calType.getCalType().equals("2") && flag == true) {
				jtf.setText(calType.equalsInput(x));
				flag = false;
			}
		} catch (Exception e) {
			jtf.setText("数值输入错误,请重新输入");
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
	
	/**
	 *  二进制初始化
	 */
	public void initBin() {
		//控件属性初始化
		jrb4.setSelected(false);
		jrb3.setSelected(false);
		jrb2.setSelected(false);
		jrb1.setSelected(true);
		int[] arr = {25,26,27,30,31,32,36,37,19,24,29,34,39,44};
		for (int x : arr) {
			jb[x].setEnabled(false);
		}
		jb[41].setEnabled(true);
		//八进制、十进制、十六进制转二进制
		if (calType.getCalType().equals("1")) {
			calType.setChangeType("2");
		} else if(calType.getCalType().equals("2")){
			if (calType.getChangeType().equals("10") || calType.getChangeType().equals("8") || calType.getChangeType().equals("16")) {
				jtf.setText(calType.changeType("2"));
			}
		}	
	}
	
	/**
	 *  八进制初始化
	 */
	public void initOct() {
		//控件属性初始化
		jrb4.setSelected(false);
		jrb3.setSelected(false);
		jrb2.setSelected(true);
		jrb1.setSelected(false);
		int [] arr1 = {19,24,29,34,39,44,26,27};
		for (int x : arr1) {
			jb[x].setEnabled(false);
		}
		int[] arr2 = {25,30,31,32,36,37,41};
		for (int x : arr2) {
			jb[x].setEnabled(true);
		}
		//十进制、二进制、十六进制转八进制
		if (calType.getCalType().equals("1")) {
			calType.setChangeType("8");
		} else if (calType.getCalType().equals("2")) {
			if (calType.getChangeType().equals("2") || calType.getChangeType().equals("10") || calType.getChangeType().equals("16")) {
				jtf.setText(calType.changeType("8"));
			}
		}	
	}
	
	/**
	 * 十进制初始化
	 */
	public void initDec() {
		//控件属性初始化
		jrb4.setSelected(false);
		jrb3.setSelected(true);
		jrb2.setSelected(false);
		jrb1.setSelected(false);
		int [] arr1 = {19,24,29,34,39,44};
		for (int x : arr1) {
			jb[x].setEnabled(false);
		}
		int[] arr2 = {25,26,27,30,31,32,36,37,41};
		for (int x : arr2) {
			jb[x].setEnabled(true);
		} 
		//八进制、二进制、十六进制转十进制
		if(calType.getCalType().equals("1")) {
			calType.setChangeType("10");
		} else if(calType.getCalType().equals("2")){
			if (calType.getChangeType().equals("8") || calType.getChangeType().equals("2") || calType.getChangeType().equals("16")) {
				jtf.setText(calType.changeType("10"));
			}
		}	
	}
	/**
	 * 十六进制初始化
	 */
	public void initHex() {
		//控件属性初始化
		jrb4.setSelected(true);
		jrb3.setSelected(false);
		jrb2.setSelected(false);
		jrb1.setSelected(false);
		int[] arr = {25,26,27,30,31,32,36,37,19,24,29,34,39,44};
		for (int x : arr) {
			jb[x].setEnabled(true);
		}
		jb[41].setEnabled(false);
		//八进制、二进制、十进制转十六进制
		if(calType.getCalType().equals("1")) {
			calType.setChangeType("16");
		} else if (calType.getCalType().equals("2")){
			if (calType.getChangeType().equals("2") || calType.getChangeType().equals("10") || calType.getChangeType().equals("8")) {
				jtf.setText(calType.changeType("16"));
			}
		}	
	}
	
	/**
	 * 控件初始化
	 */
	public void init() {
		jmb = new JMenuBar();
		jm1 = new JMenu("查看");
		jm3 = new JMenu("帮助");
		jm1_1 = new JMenuItem("标准型");
		jm1_1.addActionListener(this);
		jm1_2 = new JMenuItem("科学型");
		jm3_1 = new JMenuItem("查看帮助");
		jm3_1.addActionListener(this);
		jm3_2 = new JMenuItem("关于计算器");
		jm3_2.addActionListener(this);
		jrb1 = new JRadioButton("二进制");
		jrb1.addActionListener(this);
		jrb2 = new JRadioButton("八进制");
		jrb2.addActionListener(this);
		jrb3 = new JRadioButton("十进制");
		jrb3.addActionListener(this);
		jrb4 = new JRadioButton("十六进制");
		jrb4.addActionListener(this);
		jtf = new JTextField();
		jp1 = new JPanel(new GridLayout(3,1));
		jp = new JPanel(new GridLayout(9, 4, 10, 10));
		jp2 = new JPanel();
		
		jm1.add(jm1_1);
		jm1.add(jm1_2);
		jm3.add(jm3_1);
		jm3.add(jm3_2);
		jmb.add(jm1);
		jmb.add(jm3);
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp2.add(jrb3);
		jp2.add(jrb4);
		jp1.add(jmb);
		jp1.add(jtf);
		jp1.add(jp2);
				
		for(int i = 0; i < jb.length; i++) {
			jb[i] = new JButton(str[i]);
			jp.add(jb[i]);
			jb[i].addActionListener(this);
		}
	}
}
