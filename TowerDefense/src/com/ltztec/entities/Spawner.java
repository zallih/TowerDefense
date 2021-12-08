package com.ltztec.entities;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ltztec.main.Game;

public class Spawner extends Entity{

	private int timer = 60;
	private int curTime = 0;
	
	public Spawner(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}

	
	public void tick() {
		curTime++;
		if(curTime == timer) {
			curTime = 0;
			timer = Entity.rand.nextInt(90 - 30) + 60;
			Enemy enemy = new Enemy(x, y, 16, 16, Entity.rand.nextDouble()+Entity.rand.nextInt(2), Entity.ENEMY);
			Game.entities.add(enemy);
			Game.enemies.add(enemy);
		}
	}
	
	
	public void render(Graphics g) {
//		g.setColor(Color.black);
//		g.fillRect(this.getX(), this.getY(), width, height);
	}
}
