//Name: Antonis Papantoniou
//USCLogin:papanton
//PA1
//CS455 Fall 2014

//This file tests the Drunkard.class in terms of stepsize and startlocation. 
public class DrunkardTester {

	public static void main(String[] args) {

		int x = 100;
		int y = 100;
		int Step_Size = 5;
		ImPoint loc = new ImPoint(x, y);
		Drunkard Drunk = new Drunkard(loc, Step_Size);

		System.out.println("Drunkard starts at 100,100, stepsize is 5");
		System.out.println("Get starting location (expect:100,100):"
				+ Drunk.getCurrentLoc().getX() + ","
				+ Drunk.getCurrentLoc().getY());

		for (int j = 0; j < 5; j++) {
			
			System.out.println("NOW TESTING STEPSIZE= " + Step_Size);
			Drunk = new Drunkard(loc, Step_Size);
			Step_Size++;
			for (int i = 0; i < 5; i++) {
				x = Drunk.getCurrentLoc().getX();
				y = Drunk.getCurrentLoc().getY();
				Drunk.takeStep();
				System.out.println("Took step to:"
						+ Drunk.getCurrentLoc().getX() + ","
						+ Drunk.getCurrentLoc().getY());
				if (Drunk.getCurrentLoc().getX() < x - Step_Size
						|| Drunk.getCurrentLoc().getX() > x + Step_Size
						|| Drunk.getCurrentLoc().getY() > y + Step_Size
						|| Drunk.getCurrentLoc().getY() < y - Step_Size) {
					System.out.println("FAILED");
				} else if (Drunk.getCurrentLoc().getX() == x
						&& Drunk.getCurrentLoc().getY() == y) {
					System.out.println("FAILED");
				} else {
					System.out.println("SUCCESS");
				}
			}
		}
	}
}
