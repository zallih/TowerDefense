package com.ltztec.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


import com.ltztec.main.Game;



public class UI {

	public static BufferedImage COIN = Game.spritesheet.getSprite(96, 0, 24, 24);
	
	public void render(Graphics g) {

		g.setColor(Color.black);
		g.fillRect(8, 8, 94, 24);
		
		g.setColor(Color.red);
		g.fillRect(10, 10, 90, 20);
		g.setColor(Color.green);
		g.fillRect(10, 10, (int)((Game.life/Game.maxLife)*90), 20);
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD,17));
		g.drawString((int)Game.life+"/"+(int)Game.maxLife, 18, 27);
		
		

		g.setFont(new Font("Arial", Font.BOLD,16));
		g.drawImage(COIN, (Game.WIDTH * Game.SCALE) - 65, 5, 52, 52, null);
		g.drawString("$" + Game.money, (Game.WIDTH * Game.SCALE) - 61, 36);
		
		
		
	}
	
}
