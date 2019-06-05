package View;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * 添加背景图片
 * @author 13600
 *
 */
public class BackJpanel extends JPanel{
	Image img;
	public BackJpanel(Image im) {
		this.img = im;
		this.setOpaque(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),this);
	}
}
