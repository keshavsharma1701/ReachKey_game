package com.keshav.gaming.sprite;

import javax.imageio.ImageIO;

import com.keshav.gaming.Constants;

public class Key extends Sprite implements Constants{
	public Key() throws Exception{
		y=BOARD_HEIGHT-FLOOR-50;
		w=40;
		h=60;
		x=BOARD_WIDTH-w-90;
		bi = ImageIO.read(Key.class.getResource("key.gif"));
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub	
	}
}
