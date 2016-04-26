import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Controller {

	private View theView;
	private Model theModel;
	private int mouseX;
	private int mouseY;
	
	
	public Controller(View theView, Model theModel){
		this.theModel = theModel;
		this.theView = theView;
	
		
		this.theModel.music();
		
		this.theView.addStartListener(new StartListener());
		this.theView.addOptionsListener(new OptionsListener());
		this.theView.addExitListener(new ExitListener());
		this.theView.addBackToMenuListener(new BackToMenuListener());
		this.theView.addFirstSecondComputerDifficultyListener(new FirstSliderListener());
		this.theView.addSliderSecondComputerDifficultyListener(new SecondSliderListener());
		this.theView.addPlayerVsComputerListener(new PlayerVsComputerListener());
		this.theView.addRetryListener(new RetryListener());
		for(int i = 0; i < 7; i++)
		  this.theView.addArrowsMousePlayerVsComputerListener(new ArrowsMousePlayerVsComputerListener());
		this.theView.addComputerVsComputerListener(new ComputerVsComputerListener());
		this.theView.addNextButtonComputerVsComputerListener(new NextListener());
		this.theView.addAutoButtonComputerVsComputerListener(new AutoListener());
	}
	
	class StartListener implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			theView.setMessage("Start");
			theView.setPanel(theView.choosingTypePanel);
		}
		
	}
	
	
	class OptionsListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			theView.setMessage("Options");
			theView.setPanel(theView.optionsPanel);
		}
		
	}
	
	class ExitListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			theView.setMessage("Exit");
			System.exit(0);
		}
		
	}
	
	class BackToMenuListener implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			theView.setPanel(theView.menuPanel);
			theView.setMessage("Back to menu");
			
		}
		
	}
	
	
	
	class FirstSliderListener implements ChangeListener{

		
		public void stateChanged(ChangeEvent arg0) {
			theView.setDifficultOfFirstComputer(theModel.changeDifficultyToString(theView.getFirstSliderValue()));
			theModel.setDifficultOfFirstComputer(theView.getFirstSliderValue());
		
		}
	}
		
	class SecondSliderListener implements ChangeListener{

		
		public void stateChanged(ChangeEvent arg0) {
			theView.setDifficultOfSecondComputer(theModel.changeDifficultyToString(theView.getSecondSliderValue()));
			theModel.setDifficultOfSecondComputer(theView.getSecondSliderValue());
		
		}
	}
	
	class PlayerVsComputerListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			theView.setPanel(theView.PlayerVsComputerPanel);
		
		}
	
	}
	
	
	class ComputerVsComputerListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			theView.setPanel(theView.ComputerVsComputerPanel);
		
		}
	
	}
	
	class RetryListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			theView.newGamePlayerVsComputer();
			theModel.newGame();
		}
	}
	
	public void mouseListener(MouseEvent e)
	{
     // wspolrzedne myszy podczas zdarzenia
     mouseX =e.getX(); mouseY=e.getY(); 
	 
	}
	
	class ArrowsMousePlayerVsComputerListener implements MouseListener{
		
		private int arrowNumber = theView.arrowsNumber;
			
		ArrowsMousePlayerVsComputerListener(){
				System.out.print(arrowNumber);
			}
			
		public void mouseMoved(MouseEvent e) {
			
			
			//theView.PlayerVsComputerPanel.repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(arrowNumber%2 == 0)
			theView.setCircleColorPlayerVsComputer("purple", arrowNumber,theModel.addNewTurn(arrowNumber));
			else
			theView.setCircleColorPlayerVsComputer("white", arrowNumber,theModel.addNewTurn(arrowNumber));	
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(arrowNumber%2 == 0)
			theView.setPurpleArrowPlayerVsComputer(arrowNumber);
			else
			theView.setWhiteArrowPlayerVsComputer(arrowNumber);
			theView.setTextPlayerVsComputer("Nice!");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			theView.setDefaultArrowPlayerVsComputer(arrowNumber);
			theView.setTextPlayerVsComputer("=((((((((");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
	class NextListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	class AutoListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}

	
	
}
