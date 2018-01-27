package Solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import GameUtil.GameUtil;

public class Planet extends Star{
	
	//除了图片坐标还有别的。行星是沿着某个椭圆运行：长轴，短轴，速度，角度。还有绕飞点。
	double longAxis;  //椭圆长轴
	double shortAxis; //椭圆短轴
	double speed;     //speed
	double degree;
	Star center;
	
	boolean satellite;
	
	
	public void draw(Graphics g) {
		//g.drawImage(img,(int)x,(int)y,null);
		super.draw(g);
		//沿着椭圆轨迹飞行
		if(!satellite) {
			drawTrace(g);
		}
		move();
	}
	
	public void drawTrace(Graphics g) {
		double ovalx,ovaly,ovalWidth,ovalHeight;
		
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalx = (center.x+center.width/2) - longAxis;
		ovaly = (center.y+center.height/2) - shortAxis;
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalx, (int)ovaly, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
		
	}
	
	public void move() {
		x = (center.x+center.width/2) + longAxis*Math.cos(degree);
		y = (center.y+center.height/2) + shortAxis*Math.sin(degree);
		
		degree += speed;
		
	}

	public Planet(String imgpath, double longAxis, double shortAxis, double speed, Star center) {
		
		super(GameUtil.getImage(imgpath)); //图片宽度高度都有了
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
		this.x = center.x+longAxis;
		this.y = center.y;
		
	}
	
	public Planet(Image img, double x, double y) {
		super(img, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
		// TODO Auto-generated constructor stub
	}
	
public Planet(String imgpath, double longAxis, double shortAxis, double speed, Star center,boolean satellite) {
		
		this(imgpath,longAxis,shortAxis,speed,center);
		this.satellite = satellite;
		
	}

}
