
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;

import javax.imageio.ImageIO;

//Programmed by Adrian and Aidan of Carroll college

public class PlayableCharacter extends CollisionSprite implements PlayableCharacterI {
	// set your varables here, make sure as many as possible are private
	private int gold;

	// constructor...
	PlayableCharacter(int X, int Y, int Gold, String fileName, Dimension panelDementions) {
		super(X, Y, fileName, panelDementions);
		gold = Gold;

	}

	@Override
	public boolean moveLeft() {
//		currentPosition[0]= currentPosition[0]-2;
		currentPosition.setLocation(new Point((int)currentPosition.getX() - 2, 500));
		return true; //should be moving at a rate of 100 pixels per second as it is timed to the frame rate 
	}

	@Override
	public boolean moveRight() {
		currentPosition.setLocation(new Point((int)currentPosition.getX() + 2, 500));
//		currentPosition[0]=currentPosition[0]+2;
		return true;
	}

	@Override
	public boolean stopMoving() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean useMoney(boolean use) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void checkCollition(CollisionController colControl) {
		
	}

	@Override
	void checkCollision(CollisionController colControl) {
		// TODO Auto-generated method stub
		
	}

}
