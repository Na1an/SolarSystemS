package Solar;

import java.awt.Graphics;
import java.awt.Image;

import GameUtil.Constant;
import GameUtil.GameUtil;
import GameUtil.MyFrame;

/**
 * 太阳系主窗口
 * @author yuchen
 *
 */

public class SolarFrame extends MyFrame {
	
	Image bg = GameUtil.getImage("images/starsky.jpg");
	Star sun = new Star("images/sun_001.jpg",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
	Planet earth = new Planet("images/earth.jpg",150, 100, 0.2, sun);
	Planet Mars = new Planet("images/mars.jpg",200,130,0.3,sun);
	Planet Moon = new Planet("images/moon.jpg",25,15,0.4,earth,true);
	Planet Jupiter = new Planet("images/jupiter.jpg",300,180,0.3,sun);
	
	Image ImageBuffer = null;  
	Graphics GraImage = null;  
	  
	public void update(Graphics g){     //覆盖update方法，截取默认的调用过程  
	    ImageBuffer = createImage(this.getWidth(), this.getHeight());   //创建图形缓冲区  
	    GraImage = ImageBuffer.getGraphics();       //获取图形缓冲区的图形上下文  
	    paint(GraImage);        //用paint方法中编写的绘图过程对图形缓冲区绘图  
	    GraImage.dispose();     //释放图形上下文资源  
	    g.drawImage(ImageBuffer, 0, 0, this);   //将图形缓冲区绘制到屏幕上  
	}  
	
	public void paint(Graphics g) {
		g.drawImage(bg,0,0,null);
		sun.draw(g);
		earth.draw(g);
		Mars.draw(g);
		Moon.draw(g);
		Jupiter.draw(g);
	}
	
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
	
}
