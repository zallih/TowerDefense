package com.ltztec.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ltztec.main.Game;
import com.ltztec.world.AStar;
import com.ltztec.world.Camera;
import com.ltztec.world.Vector2i;
import com.ltztec.world.World;

public class Enemy extends Entity {

	private int frames = 0, maxFrames = 8, index = 0, maxIndex = 1;
	private boolean moved = false;
	private BufferedImage[] rightEnemy;
	private BufferedImage[] leftEnemy;
	public int right_dir = 0, left_dir = 1;
	public int dir = right_dir;
	public boolean right, left;

	public double life = 50;
	public double maxLife = 50;

	public String mv = "";

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);

		path = AStar.findPath(Game.world, new Vector2i(World.xINITIAL, World.yINITIAL),
				new Vector2i(World.xFINAL, World.yFINAL));

		rightEnemy = new BufferedImage[2];
		leftEnemy = new BufferedImage[2];

		for (int i = 0; i < 2; i++) {
			rightEnemy[i] = Game.spritesheet.getSprite(32 + (i * 16), 0, 16, 16);
		}
//		for (int i = 0; i < 2; i++) {
//			leftEnemy[i] = Game.spritesheet.getSprite(64 + (i * 16), 16, 16, 16);
//		}
	}

	public void tick() {
		depth = 0;
		
//
//		if (this.getX() > this.x) {
//			mv = "r";
//		} else {
//			mv = "l";
//		}
//		
//		if(mv == "r") {
//			this.right = true;
//		}else if(mv == "l") {
//			this.left = true;
//		} 
//
//		moved = false;
//		if (right && World.isFree((int) (x + speed), this.getY())) {
//			moved = true;
//			dir = right_dir;
//			x += speed;
//		} else if (left && World.isFree((int) (x - speed), this.getY())) {
//			moved = true;
//			dir = left_dir;
//			x -= speed;
//		}

//		if (moved) {
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				index++;
				if (index > maxIndex) {
					index = 0;
				}
			}
//		}

		followPath(path);
		if (x >= Game.WIDTH) {
			// System.out.println("perdendo vida");
			Game.life-=0.7;
			this.destroySelf();
		}
		
		if(life <= 0) {
			this.destroySelf();
			Game.money+=5;
		}

	}

	public void destroySelf() {
		Game.enemies.remove(this);
		Game.entities.remove(this);
		return;
	}

	public void render(Graphics g) {
	//	if (dir == right_dir) {
			g.drawImage(rightEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		//} else if (dir == left_dir) {
	//		g.drawImage(leftEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		//}

			g.setColor(Color.red);
			g.fillRect(this.getX(), this.getY()-5, 15, 3);
			
			g.setColor(Color.green);
			g.fillRect(this.getX(), this.getY() - 5, (int)((life/maxLife) * 15), 3);

	}

}
