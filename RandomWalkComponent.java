//Name:Antonis Papantoniou
//USC LoginID:papanton
//Fall 2014 
//PA1 CS455x.

//This java file extends the JComponent and draws the walk.
//The constuctor takes as input an array of 2D Point objects and converts it to a 2D  line array  to be drawn.

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;


public class RandomWalkComponent extends JComponent{
	private int total_Steps;
	private Line2D.Double[] line;
	
	public RandomWalkComponent(Point2D[] drunk_Positions)
	{
		total_Steps=drunk_Positions.length;
		line= new Line2D.Double[total_Steps];
		for (int i=0; i<total_Steps-1;i++ )
		{		
			 Line2D.Double j=new Line2D.Double(drunk_Positions[i],drunk_Positions[i+1]);
			 line[i]=j;
			 
		} 
	}
	
	public void paintComponent(Graphics g)
	{ 
		Graphics2D g2=(Graphics2D) g;
		for (int i=0; i<line.length-1;i++ )
		{
			
			g2.draw(line[i]);
		}
	}
}
