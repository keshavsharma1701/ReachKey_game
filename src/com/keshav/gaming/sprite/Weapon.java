package com.keshav.gaming.sprite;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.keshav.gaming.Constants;

public class Weapon extends Sprite implements Constants{
	public Weapon(int x, int y) throws IOException {
		this.x=x;
		this.y=y;
		w=30;
		h=30;
		speed=50;
		try {
			bi=ImageIO.read(Weapon.class.getResource("weapon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean outOfScreen(){
		if(x>BOARD_WIDTH) {
			return true;
		}
		return false;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		x=x+speed;
	}
}
