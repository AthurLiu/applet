package MyCalculate.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CalculateViewHelper extends JFrame implements MouseListener{
	String[] str = {"显示帮助","隐藏帮助","    实现过程中，建议先从最基础开始写，如普通的加减乘除取余等，"
			,"实现普通的加减乘除功能，再实现小数的加入，以及一系列头疼的计算"
			,"逻辑，例如a+a+a;或者a+a=c，然后继续输入运算或数字进行计算，接"
			,"着实现清零（简单）和按位删，以及平方、立方、n次方和开方，ln，log"
			,"等运算，在三角函数部分转换时，注意弧度与读之间的问题，例如："
			,"              度  = 弧度   * π /180"
			,"进行进制转换时，个人觉得十进制转其他进制方便，但是其他，例如8"
			,"进制转16进制，可以以十进制作为中间点曲线转，个人觉得复杂的算法"
			,"基本上没有，都是基础知识，只是各种逻辑很费人，过程是比较痛苦的"
			,"    其中不合理的地方请见谅，最后，加油！！！"};
	JLabel[] jl = new JLabel[str.length];
	//创建一个容器
	JPanel jp;
	//创建背景面板
	BackgroundPanel1 bgp;
	
	public CalculateViewHelper() {
		jp = (JPanel)this.getContentPane();		
		ImageIcon image = new ImageIcon("picture/picture1.jpg");
		bgp = new BackgroundPanel1(image.getImage());
		bgp.setLayout(new GridLayout(15, 1));
		bgp.setBounds(0, 0, 600, 600);

		for (int i = 0 ; i < str.length; i++) {
			jl[i] = new JLabel(str[i]);
			jl[i].setFont(new Font("隶书",Font.BOLD,18));
			jl[i].addMouseListener(this);
			bgp.add(jl[i]);
		}
		
		for (int i = 1; i < str.length; i++) {
			jl[i].setVisible(false);
		}
		
		jp.add(bgp);
		this.setLayout(null);
		this.setBounds(200, 200, 600, 630);
		this.setTitle("关于计算器");
		this.setResizable(false);
		this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(jl[1])) {
			for(int i = 1; i < str.length; i++) {
				jl[i].setVisible(false);
			}
		} 
		if (e.getSource().equals(jl[0])) {
			for(int i = 1; i < str.length; i++) {
				jl[i].setVisible(true);
			}
		} 
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		int i = 0;
		while(i < str.length) {			
			if(e.getSource().equals(jl[i])) {
				jl[i].setForeground(Color.BLUE);
			}	
			i++;
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		int i = 0;
		while(i < str.length) {			
			if(e.getSource().equals(jl[i])) {
				jl[i].setForeground(Color.BLACK);
			}	
			i++;
		}
	}
}

class BackgroundPanel1 extends JPanel{
	Image im;
	public BackgroundPanel1(Image im){
		this.im = im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);	
	}
}
