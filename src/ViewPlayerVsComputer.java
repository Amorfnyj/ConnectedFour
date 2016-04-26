import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class ViewPlayerVsComputer extends JPanel {

	private JButton backToMenu = new JButton();
	private JButton RetryButton = new JButton();
	private View theView;
	private Image PlayerVsComputerImage = null;
	private Font MyFontTitle = new Font("TimesRoman", Font.BOLD, 72);
	private ViewCircle[][] Circles; 
	private Image arrow = null;
	private JButton[] arrowsButton;
	private String text;
	public Icon arrowPurple;
	public Icon arrowWhite;
	
	
	public ViewPlayerVsComputer(View theView){
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		this.theView = theView;
		
		arrowPurple=new ImageIcon("arrowPurple.jpg");
		arrowWhite=new ImageIcon("arrowWhite.jpg");
		
		text = "Welcome!";
		
		arrowsButton = new JButton[7];
		for(int i = 0, x = 0; i < 7; i++, x = i*72){
			
			arrowsButton[i] = new JButton();
			
			arrowsButton[i].setBounds(147 + x, 74, 64, 64);
			theView.setInvisibleButton(arrowsButton[i]);
			this.add(arrowsButton[i]);
	
		}
		
	
		
		backToMenu.setBounds(416, 646, 304, 44);
		theView.setInvisibleButton(backToMenu);
		this.add(backToMenu);
		
		RetryButton.setBounds(126, 645, 136, 49);
		theView.setInvisibleButton(RetryButton);
		this.add(RetryButton);
		
		
		Circles = new ViewCircle[7][6];
		makeCircles(Circles);
		
		
		try {
			
			PlayerVsComputerImage = ImageIO.read(new File("PlayerVsComputer.jpg"));
			arrow = ImageIO.read(new File("arrow.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	void makeCircles (ViewCircle[][] Circles){
		int height = 0;
		int width = 0;
		for( int x = 0; x!= Circles.length; x++)
		{
			height = 0;
			width += 72;
			for( int y = 0; y!= Circles[x].length; y++)
			{
				height += 86;
				
				Circles[x][y] = new ViewCircle(94 + width, 61 + height, 27, 28);
			}	
		}
	}
	
	
	public JButton getBackToMenuButton(){
		return backToMenu;
	}
	
	public JButton getRetryButton(){
		return RetryButton;
	}
	
	public JButton[] getArrowsButton(){
		return arrowsButton;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(PlayerVsComputerImage, 0, 0, null); 
		
		for (int i = 0; i < 7; i++){
			g.drawImage(arrow, 147 + i*72, 74, null);
		}
		 
		
		g.setFont(MyFontTitle);
		g.setColor(Color.BLACK);
		g.drawString(text, 190, 55);
		
		drawCircles(g);
		
		this.requestFocusInWindow();
		
	}
	
	void drawCircles(Graphics g){
		for( int x = 0; x!= Circles.length; x++)
		{
			for( int y = 0; y!= Circles[x].length; y++)
			{
				//Circles[x][y].setColor("purple");
				Circles[x][y].renderComponent(g);
			}	
		}
	}
	
	void setCircleColor(String c, int x, int y)
	{
		Circles[x][y].setColor(c);
		repaint();
	}
	
	void setText(String s){
	 
		text = s;
		repaint();
		
	}
	
	void newGame()
	{
		for( int x = 0; x!= Circles.length; x++)
		{
			for( int y = 0; y!= Circles[x].length; y++)
			{
				setCircleColor("noColor", x, y);
			}	
		}
	}
	
}
