import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ViewCircle {
	private Rectangle Circle;
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	static private Color white = new Color(255,255,255);
	static private Color purple = new Color(132,112,255);
	private int show;
	
	public ViewCircle(int x, int y, int width, int height){
		Circle = new Rectangle(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		show = 0;
		
	}
	
	public void renderComponent(Graphics g){
		
		if(show != 0)
		{
			g.setColor(color);
			//g.setColor(Color.RED);
			g.drawRect(x, y, width, height);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void setColor(String c){
		if(c == "purple"){
			show = 1;
			color = purple;
		}
		if(c == "white"){
			show = 1;
			color = white;
		}
		if(c == "noColor")
			show = 0;
	}
	
}
