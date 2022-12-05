package com.keshav.gaming.sprite;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.keshav.gaming.Constants;

public class Player extends Sprite implements Constants{
	int force;
	boolean isJump;
	private ArrayList<Weapon> weapons = new ArrayList<>();
	public Player() throws Exception
	{
		x=20;
		w=80;
		h=100;
		y=BOARD_HEIGHT-h-FLOOR;
		speed =10;
		isJump=false;
		bi = ImageIO.read(Player.class.getResource("player.gif"));
	}
	
	public ArrayList<Weapon> getWeapons(){
		return weapons;
	}
	
	public void addWeapon(int x, int y) throws IOException {
		weapons.add(new Weapon(x,y));
	}
	
	public void jump() {
		if(!isJump) {
		force=-15;
		y=y+force;
		isJump=true;
		}
	}
	
	public void fall() {
		if(y>=BOARD_HEIGHT-h-FLOOR) {
			isJump=false;
			return;
		}
		force=force+GRAVITY;
		y=y+force;
	}
	@Override
	public void move()
	{
		x=x+speed;
	}
	
	public boolean testLimit()
	{
		if(x>=BOARD_WIDTH-220)
		{
			x=BOARD_WIDTH-220;
			return true;
		}
		return false;
	}
}
