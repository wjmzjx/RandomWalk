import java.util.Random;

// Name:Antonis Papantoniou
// USC loginid:papanton
// CS 455 PA1
// Fall 2014

/**
   Drunkard class
       Represents a "drunkard" doing a random walk on a grid.
*/

public class Drunkard {

    /**
       Creates drunkard with given starting location and distance
       moved in a single step.
       @param currentLoc starting location of drunkard
       @param theStepSize size of one step in the random walk
    */
    public Drunkard(ImPoint startLoc, int theStepSize) {
    	this.theStepSize=theStepSize;
    	this.currentLoc=startLoc;
    }


    /**
       Takes a step of length step-size (see constructor) in one of
       the four compass directions.  Changes the current location of the
       drunkard.
    */
    public void takeStep() {
    
    	int random_direction=rand.nextInt(4);//random 1-4 directions for the step to be taken.
    	if (random_direction==0)
    	{
    		ImPoint move_location=currentLoc.translate(theStepSize, 0);
    		currentLoc=move_location;
    	}
    	else if(random_direction==1)
    	{
    		ImPoint move_location=currentLoc.translate(-theStepSize, 0);
    		currentLoc=move_location;
    	}
    	else if(random_direction==2)
    	{
    		ImPoint move_location=currentLoc.translate(0,theStepSize);
    		currentLoc=move_location;
    	}
    	else if(random_direction==3)
    	{
    		ImPoint move_location=currentLoc.translate(0,-theStepSize);
    		currentLoc=move_location;
    	}
    }


    /**
       gets the current location of the drunkard.
       @return an ImPoint object representing drunkard's current location
    */
    public ImPoint getCurrentLoc() {
	return currentLoc;
    }
    private int theStepSize;
    ImPoint currentLoc;
    Random rand=new Random();

}
