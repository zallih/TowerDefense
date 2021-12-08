package com.ltztec.entities;

import java.awt.image.BufferedImage;

import com.ltztec.main.Game;
import com.ltztec.world.World;

public class PlantControl extends Entity {

	public boolean isPressed = false, released = false;
	public int xTarget, yTarget;

	public PlantControl(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		if (isPressed == true) {
			released = true;
			isPressed = false;
			int xx = (xTarget / 16) * 16;
			int yy = (yTarget / 16) * 16;
			Player player = new Player(xx, yy, 16, 16, 0, Game.spritesheet.getSprite(0, 16, 16, 16));

			for (int i = 0; i < Game.entities.size(); i++) {
				Entity e = Game.entities.get(i);
				if (e instanceof Player) {
					if (Entity.isColidding(e, player)) {
						released = false;
						System.out.println("Não pode colocar no mesmo lugar!");
					}
				}
			}
			
			if(World.isFree(xx, yy)) {
				released = false;
				System.out.println("Não pode colocar neste lugar do mapa!");
			}
			
			if(Game.money < 10) {
				released = false;
				//System.out.println("Você não tem dinheiro suficiente");
			}

			if (released == true) {
				Game.entities.add(player);
				Game.money-=10;
				
			}
		}
		
		if(Game.life <= 0) {
			Game.life = 0;
			System.exit(1);
		}
		
		
		
	}

}
