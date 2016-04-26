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



public class ViewComputerVsComputer extends JPanel {
	
	private Image ComputerVsComputerImage = null;
	private Image arrow = null;
	private String text;
	private Font MyFontTitle = new Font("TimesRoman", Font.BOLD, 72);
	private JButton backToMenu = new JButton();
	private JButton autoButton = new JButton();
	private JButton nextButton = new JButton();
	private View theView;
	private ViewCircle[][] Circles; 
	
	public ViewComputerVsComputer(View theView){
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		this.theView = theView;
	
		text = "Computer";
		
		backToMenu.setBounds(400, 654, 297, 33);
		theView.setInvisibleButton(backToMenu);
		this.add(backToMenu);
		
		nextButton.setBounds(258, 654, 104, 33);
		theView.setInvisibleButton(nextButton);
		this.add(nextButton);
		
		autoButton.setBounds(116, 654, 105, 33);
		theView.setInvisibleButton(autoButton);
		this.add(autoButton);

		Circles = new ViewCircle[7][6];
		makeCircles(Circles);
		
		try {
			
			ComputerVsComputerImage = ImageIO.read(new File("ComputerVsComputer.jpg"));
			
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
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(ComputerVsComputerImage, 0, 0, null); 
		
		for (int i = 0; i < 7; i++){
			g.drawImage(arrow, 147 + i*72, 74, null);
		}
		 
		
		g.setFont(MyFontTitle);
		g.setColor(Color.BLACK);
		g.drawString(text, 190, 80);
		
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
	
	
	public JButton getBackToMenuButton(){
		return backToMenu;
	}
	
	public JButton getAutoButton()
	{
		return autoButton;
	}

	public JButton getNextButton()
	{
		return nextButton;
	}
}
