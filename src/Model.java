import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



import sun.audio.*;

public class Model {

	private int[][] Circles;
	public int firstComputerDifficult = 2;
	public int secondComputerDifficult = 2;
	
	public Model () {
		Circles = new int[7][6];
		
		for( int x = 0; x!= Circles.length; x++)
		{
			
			for( int y = 0; y!= Circles[x].length; y++)
			{
				
				Circles[x][y] = 0;
			}	
		}
	}
	
	public String changeDifficultyToString(int d)
	{
		if (d <= 25 && d >= 0) 
			{return "easy";}
		
		if (d <= 50 && d > 25)
			{return "medium";}
		
		if (d <= 75 && d > 50)
			{return "hard";}
		
		if(d <= 100 && d > 75)
			{return "impossible";}
		
		return null;
	}
	
	public void setDifficultOfFirstComputer(int d)
	{
		firstComputerDifficult = changeDifficultyToInt(d);
	}
	
	public void setDifficultOfSecondComputer(int d)
	{
		secondComputerDifficult = changeDifficultyToInt(d);
	}
	
	
	
	public int changeDifficultyToInt(int d)
	{
		if (d <= 25 && d >= 1) 
			return 1;
	
		if (d <= 50 && d > 25)
			return 2;
		
		if (d <= 75 && d > 50)
			return 3;
		
		if(d <= 100 && d > 75)
			return 4;
		
		return 1;
	}
	
	public void music()
	{   
		try{
		InputStream in = new FileInputStream("music.wav");
		// Create an AudioStream object from the input stream.
		AudioStream as = new AudioStream(in);         
		// Use the static class member "player" from class AudioPlayer to play
		// clip.
		AudioPlayer.player.start(as);  
		}catch(IOException error) {};
		          
		// Similarly, to stop the audio.
		//AudioPlayer.player.stop(as); 
	}
	
	int addNewTurn(int x){
		int j;
		
		if(Circles[x][0] != 0)
		{
			return 5;
		}
		
		for( j = 5; j >= 0; j--)
			{
				if(Circles[x][j] == 0){
					Circles[x][j] = 1;
					break;
				}
				
			}
		
		return j;
		
	}
	
	void newGame()
	{
		for( int x = 0; x!= Circles.length; x++)
		{
			
			for( int y = 0; y!= Circles[x].length; y++)
			{
				
				Circles[x][y] = 0;
			}	
		}
	}
	
}

