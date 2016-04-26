import java.awt.Color;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;




public class View extends JFrame {
	
	private JButton startButton = new JButton("start");
	private JButton optionsButton = new JButton("options");
	private JButton exitButton = new JButton("exit");
	private JButton backToMenuFromOptions = new JButton();
	private JButton backToMenuFromChoosingTypes = new JButton("back to menu");
	private JButton playerVsComputerButton = new JButton();
	private JButton computerVsComputerButton = new JButton();
	private JSlider sliderFirstComputerDifficulty = new JSlider(SwingConstants.HORIZONTAL);
	private String firstComputerDifficulty = "medium";
	private String secondComputerDifficulty = "medium";
	private JSlider sliderSecondComputerDifficulty = new JSlider(SwingConstants.HORIZONTAL);
	private JTextField messageField = new JTextField(20);
	private Image backgroundImage = null;
	private BufferedImage imageOptions = null;
	private Image choosingTypeImage = null;
	private JPanel currentPanel;
	private Font MyFontTitle = new Font("TimesRoman", Font.BOLD, 32);
	
	public ViewComputerVsComputer ComputerVsComputerPanel = new ViewComputerVsComputer(this);
	public ViewPlayerVsComputer PlayerVsComputerPanel = new ViewPlayerVsComputer(this);
	public MenuView menuPanel = new MenuView();
	public OptionsView optionsPanel = new OptionsView();
	public ChoosingTypeView choosingTypePanel = new ChoosingTypeView();
	
	public int arrowsNumber = 0;
	
	
	public View(){
		
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.CYAN);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,730);
		this.setLocationRelativeTo(null);
		this.setTitle("Connect Four");
		this.setResizable(false);
		
		startButton.setBounds(318, 534, 174, 44);
		this.setInvisibleButton(startButton);
		menuPanel.add(startButton);
		this.setInvisibleButton(optionsButton);
		optionsButton.setBounds(293, 589, 224, 44);
		menuPanel.add(optionsButton);
		this.setInvisibleButton(exitButton);
		exitButton.setBounds(330, 642, 135, 44);
		menuPanel.add(exitButton);
		messageField.setHorizontalAlignment(JTextField.CENTER);
		messageField.setBackground(Color.CYAN);
		messageField.setBounds(250, 190, 300, 30);
		menuPanel.add(messageField);
		
		currentPanel = menuPanel;
		this.add(menuPanel);
		
		sliderSecondComputerDifficulty.setBackground(Color.CYAN);
		sliderSecondComputerDifficulty.setBounds(150, 470, 500, 20);
		optionsPanel.add(sliderSecondComputerDifficulty);
		sliderFirstComputerDifficulty.setBackground(Color.CYAN);
		sliderFirstComputerDifficulty.setBounds(150, 290, 500, 20);
		optionsPanel.add(sliderFirstComputerDifficulty);
		optionsPanel.setLayout(null);
		optionsPanel.setBackground(Color.CYAN);
		//optionsPanel.setSize(800,800);
		this.setInvisibleButton(backToMenuFromOptions);
		backToMenuFromOptions.setBounds(208, 613, 380, 54);
		optionsPanel.add(backToMenuFromOptions);
		
		
		choosingTypePanel.setLayout(null);
		choosingTypePanel.setBackground(Color.CYAN);
		this.setInvisibleButton(playerVsComputerButton);
		playerVsComputerButton.setBounds(266, 136, 265, 119);
		choosingTypePanel.add(playerVsComputerButton);
		this.setInvisibleButton(computerVsComputerButton);
		computerVsComputerButton.setBounds(266, 313, 264, 119);
		choosingTypePanel.add(computerVsComputerButton);
		this.setInvisibleButton(backToMenuFromChoosingTypes);
		backToMenuFromChoosingTypes.setBounds(208, 613, 380, 54);
		choosingTypePanel.add(backToMenuFromChoosingTypes);
		
		
		
		
	
		try {
			backgroundImage = ImageIO.read(new File("backgroundMenu.jpg"));
			imageOptions = ImageIO.read(new File("Options.jpg"));
			choosingTypeImage = ImageIO.read(new File("choosingType.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	class MenuView extends JPanel{
		public void paint(Graphics g)
		{
			super.paint(g);
			g.drawImage(backgroundImage, 0, 0, null); 
			this.requestFocusInWindow();
			
		}
	}
	
	class OptionsView extends JPanel{
		public void paintComponent(Graphics g)
		{
			//super.paint(g);
			g.drawImage(imageOptions, 0, 0, null); 
			
			g.setColor(Color.BLACK);	
			g.setFont(MyFontTitle);
			g.drawString(firstComputerDifficulty, 220, 242);
			g.drawString(secondComputerDifficulty, 220, 413);
			this.requestFocusInWindow();
			
		}
	}
	
	class ChoosingTypeView extends JPanel{
		public void paint(Graphics g)
		{
			super.paint(g);
			g.drawImage(choosingTypeImage, 0, 0, null); 
			this.requestFocusInWindow();
			
		}
	}
	
	void addStartListener(ActionListener startListener){
		
		startButton.addActionListener(startListener);
		
	}
	
	void addOptionsListener(ActionListener listenForOptions){
		
		optionsButton.addActionListener(listenForOptions);
		
	}
	void addExitListener(ActionListener listenForExit){
	
		exitButton.addActionListener(listenForExit);
	
	}
	
	void addBackToMenuListener(ActionListener listenForBackToMenu){
		
		backToMenuFromOptions.addActionListener(listenForBackToMenu);
		backToMenuFromChoosingTypes.addActionListener(listenForBackToMenu);
		PlayerVsComputerPanel.getBackToMenuButton().addActionListener(listenForBackToMenu);
		ComputerVsComputerPanel.getBackToMenuButton().addActionListener(listenForBackToMenu);
	}
	
	void addRetryListener(ActionListener listenForRetry){
		
		PlayerVsComputerPanel.getRetryButton().addActionListener(listenForRetry);
	
	}
	
	void addSliderSecondComputerDifficultyListener(ChangeListener ListendForSecondSlider){
		
		sliderSecondComputerDifficulty.addChangeListener(ListendForSecondSlider);
		
	}
	
	void addFirstSecondComputerDifficultyListener(ChangeListener ListendForFirstSlider){
		
		sliderFirstComputerDifficulty.addChangeListener(ListendForFirstSlider);

	}
	
	void addPlayerVsComputerListener(ActionListener playerVsComputerListener){
		
		playerVsComputerButton.addActionListener(playerVsComputerListener);
		
	}
	
	void addComputerVsComputerListener(ActionListener computerVsComputerListener){
		
		computerVsComputerButton.addActionListener(computerVsComputerListener);
		
	}
	
	void addArrowsMousePlayerVsComputerListener(MouseListener ArrowsMouseListener){
			PlayerVsComputerPanel.getArrowsButton()[arrowsNumber].addMouseListener(ArrowsMouseListener);
			arrowsNumber++;
			if(arrowsNumber == 7) arrowsNumber = 0; 
			//System.out.print(arrowsNumber);
	}
	
	void addNextButtonComputerVsComputerListener(ActionListener ListenForNext){
		
		ComputerVsComputerPanel.getNextButton().addActionListener(ListenForNext);
	}
	
	void addAutoButtonComputerVsComputerListener(ActionListener ListenForAuto){
		
		ComputerVsComputerPanel.getAutoButton().addActionListener(ListenForAuto);
	}
	
	public void setPurpleArrowPlayerVsComputer(int x){
		PlayerVsComputerPanel.getArrowsButton()[x].setIcon(PlayerVsComputerPanel.arrowPurple);
	}
	
	public void setWhiteArrowPlayerVsComputer(int x){
		PlayerVsComputerPanel.getArrowsButton()[x].setIcon(PlayerVsComputerPanel.arrowWhite);
	}
	
	public void setDefaultArrowPlayerVsComputer(int x){
		PlayerVsComputerPanel.getArrowsButton()[x].setIcon(null);
	}
	
	void setTextPlayerVsComputer(String s){
		PlayerVsComputerPanel.setText(s);
	}
	
	void setTextComputerVsComputer(String s){
		ComputerVsComputerPanel.setText(s);
	}
	
	void setMessage (String message){
		
		messageField.setText(message);
		
	}
	
	void setCircleColorPlayerVsComputer(String c, int x, int y)
	{
		PlayerVsComputerPanel.setCircleColor(c, x, y);
	}
	
	void setCircleColorComputerVsComputer(String c, int x, int y)
	{
		ComputerVsComputerPanel.setCircleColor(c, x, y);
	}
	
	void newGamePlayerVsComputer(){
		PlayerVsComputerPanel.newGame();
	}
	
	void newGameComputerVsComputer(){
		ComputerVsComputerPanel.newGame();
	}
	
	public void setPanel(JPanel panel) {
		this.remove(currentPanel);
        currentPanel = panel;
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
        this.getContentPane().repaint();
        //this.pack();
    }
	
	public void setInvisibleButton(JButton button)
	{
		button.setFocusPainted(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setOpaque(false);
	
	}
	
	public int getFirstSliderValue()
	{
		return sliderFirstComputerDifficulty.getValue();
	}
	
	public int getSecondSliderValue()
	{
		return sliderSecondComputerDifficulty.getValue();
	}
	
	public void setDifficultOfFirstComputer(String d)
	{
		firstComputerDifficulty = d;
		
		this.repaint();
	}
	
	public void setDifficultOfSecondComputer(String d)
	{
		secondComputerDifficulty = d;
		this.repaint();
	}

}

