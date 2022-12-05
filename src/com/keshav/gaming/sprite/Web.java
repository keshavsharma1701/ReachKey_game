package com.keshav.gaming.sprite;

import javax.imageio.ImageIO;

import com.keshav.gaming.Constants;

public class Web extends Sprite implements Constants{
	public Web() throws Exception
	{
		y=0;
		w=200;
		h=300;
		x=BOARD_WIDTH-w;
		bi = ImageIO.read(Web.class.getResource("web.gif"));
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}