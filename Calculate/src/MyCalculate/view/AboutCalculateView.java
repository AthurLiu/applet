package MyCalculate.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class AboutCalculateView extends JFrame implements MouseListener{
	String[] str = {"显示介绍信息","隐藏介绍信息","本计算器主要实现了以下功能：","1、实现了整数和小数的基本运算，包括连加、连减等等"
			,"2、实现了二进制、十进制、十六进制之间的相互转化","3、实现了sin、asin、cos等之间的转换"
			,"4、实现了平方、立方、n次方和开平方等功能","5、实现了按位删和整体清零以及按键Ans记录上一次运算结果的功能"
			,"6、完成标准计算器和科学计算器之间的相互切换","制作人：幽竹","完成时间：2019/5/14"};
	JLabel[] jl = new JLabel[str.length];
	//创建一个容器
	JPanel jp;
	//创建背景面板
	BackgroundPanel bgp;
	
	public AboutCalculateView() {
		jp = (JPanel)this.getContentPane();		
		ImageIcon image = new ImageIcon("picture/picture.jpg");
		bgp = new BackgroundPanel(image.getImage());
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

class BackgroundPanel extends JPanel{
	Image im;
	public BackgroundPanel(Image im){
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);	
	}
}
