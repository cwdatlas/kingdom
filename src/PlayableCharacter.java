
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;

//Programmed by Adrian and Aidan of Carroll college

public class PlayableCharacter extends CollisionSprite implements PlayableCharacterI {
	// set your varables here, make sure as many as possible are private
	private Random random = new Random();
	private boolean delete = false;
	private boolean downPress = false;
	private int goldUseTimer= 0;
	private int droppedGoldTimer = 0;

	// constructor...
	PlayableCharacter(int x, int y, int Gold, String fileName, Dimension panelDementions) {
		super(x, y, fileName, panelDementions);
	}
	@Override
	public boolean moveLeft() {
		currentPosition.setLocation(new Point((int) currentPosition.getX() - 2, 500));
		hitbox.setLocation(new Point((int) currentPosition.getX() - 2, 500));
		return true; 
	}
	@Override
	public boolean moveRight() {
		currentPosition.setLocation(new Point((int) currentPosition.getX() + 2, 500));
		hitbox.setLocation(new Point((int) currentPosition.getX() + 2, 500));
		return true;
	}
	@Override
	public void downPress(boolean press) {
		downPress = press;
	}
	// picking up coins
	public void checkCollision(CollisionController colControl) {
		List<BaseSprite> collidingSprites = colControl.checkCollition(this.getHitBox());
		for (int i = 0; i < collidingSprites.size(); i++) {
			if (collidingSprites.get(i) instanceof DroppedCoin 
				&& droppedGoldTimer == 0) {
				DroppedCoin coin = (DroppedCoin) collidingSprites.get(i);
				colControl.deleteObject(coin);
				this.incrementGold();
			}
		}
		//place to use colControl
		if(downPress
			&& gold > 0
			&& goldUseTimer == 0){
			this.gold--;
			colControl.addObject(new DroppedCoin(currentPosition.x, 500, "coin.png", dimensions));
			goldUseTimer = 500;
			droppedGoldTimer = 2000;
		}
		//incrementing timers down
		if(goldUseTimer > 0)
			goldUseTimer--;
		if(droppedGoldTimer > 0)
			droppedGoldTimer--;
		System.out.println(droppedGoldTimer);
	}
	@Override
	public boolean paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
		return true;

	}
}
