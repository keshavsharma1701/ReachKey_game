package com.keshav.gaming.sprite;

import javax.imageio.ImageIO;

import com.keshav.gaming.Constants;

public class Enemy extends Sprite implements Constants{
	boolean isAlive ;
    public Enemy(int x,int speed) throws Exception
	{
		this.x=x;
		y=100;
		w=100;
		h=100;
		isAlive = true;
		this.speed =speed;
		bi = ImageIO.read(Enemy.class.getResource("enemy.gif"));
	}
    public boolean getisAlive() {
    	return isAlive;
    }
    public void setisAlive(boolean isAlive) {
    	this.isAlive=isAlive;
    }
    @Override
	public void move() {
		y=y+speed;
		this.outOfScreen();
	}
	
	void outOfScreen() {
		if(y>BOARD_HEIGHT && isAlive)
		{
			y=50;
		}
	}
	
    public void fall() {
		y = y + 10;
	}
}