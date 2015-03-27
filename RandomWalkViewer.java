//Name: Antonis Papantoniou
//USCLogin ID: papanton
//PA1 CS455x Fall 2014

// This java file contains the main program.
//It call the Scanner class for user input, input checks, and creates an array of Point2D with drunkard steps to be drawn in `RandomWalkComponent.java
//It then creates a JFrame and displays the walk. 

import java.awt.geom.Point2D;
import java.util.Scanner;
import javax.swing.JFrame;


public class RandomWalkViewer{
	
	public static void main(String[] args)
	{
		int step_Size=5;//5 pixels per step so assume stepsize 5
		int x=200;//arbitrary starting location x,y
		int y=200;
		
		System.out.println("Enter Number of steps: ");
		
		Scanner in=new Scanner(System.in);
		int step_Number=-1;//negative initialization for input checking.
		boolean InputCheck=true;
		while(InputCheck)
		{
			if(in.hasNextInt()){//checking for non integer values
				int n=in.nextInt();
				if (n<=0){
					System.out.println("Number of steps not valid. Enter value greater than 0: ");
				}
				else {
					step_Number=n;
					InputCheck=false;//exiting the check loop
				}
			}
			else{
				System.out.println("Non valid input, please use integer values");
				in.next();
			}	
		}	
		in.close();
		
		ImPoint loc=new ImPoint(x,y);
		Drunkard Drunk=new Drunkard(loc,step_Size);//initializing drunkard with start location and step_size. 
		Point2D[] drunk_Positions=new Point2D[step_Number+1];//+1 to account for starting position
		drunk_Positions[0]=Drunk.getCurrentLoc().getPoint2D();//starting Position
		
		for (int i=1;i<=step_Number;i++)
		{
			Drunk.takeStep();
			drunk_Positions[i]=Drunk.getCurrentLoc().getPoint2D();//Filling up the array with all the 2d positions that the drunkard has taken.
		}
		
		//Creating the frame.
		JFrame frame=new JFrame();
		frame.setSize(400,400);
		frame.setTitle("Random Walk");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RandomWalkComponent component=new RandomWalkComponent(drunk_Positions);
		
		frame.add(component);
		frame.setVisible(true);
		
	}
}
