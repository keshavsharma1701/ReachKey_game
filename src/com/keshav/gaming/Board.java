package com.keshav.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.keshav.gaming.sprite.Enemy;
import com.keshav.gaming.sprite.Key;
import com.keshav.gaming.sprite.Player;
import com.keshav.gaming.sprite.Sprite;
import com.keshav.gaming.sprite.Weapon;
import com.keshav.gaming.sprite.Web;

public class Board extends JPanel implements Constants{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Constructor (Initialize)
	BufferedImage bi ;
	Player player;
	Key key;
	Web web;
	String gameMessage="Game Start";
	int count;
	//Enemy enemy;
	Enemy enemies[];
	//throw early catch later
	
	public Board() throws Exception{
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		bi = ImageIO.read(Board.class.getResource("game-bg.jpg"));
		player = new Player();
		key= new Key();
		count=0;
		enemies = new Enemy[MAX_ENEMY];//all member are null initially
		web = new Web();
		 loadEnemies();
		 setFocusable(true);
		 bindEvents();
		 gameLoop();
	}
	
	void enemyFall() {
		for(Enemy e : enemies) {
			if(!e.getisAlive()) {
			e.fall();
			}
		}
	}
	
	boolean isCollide(Sprite one, Sprite two) {
		int xDistance = Math.abs(one.getX()- two.getX());
		int yDistance = Math.abs(one.getY()- two.getY());
		int w=Math.max(one.getW(),two.getW());
		int h=Math.max(one.getH(),two.getH());
		return (xDistance<=w-30 && yDistance<=h-15);
	}
	
	void checkCollision() {
		//check player is collide with enemy or not
		for(Enemy e : enemies) {
			if(isCollide(player , e)) {
				gameMessage = "Game Over";
				timer.stop();
			}
		}
		for(Weapon weapon : player.getWeapons()) {
			for(Enemy e : enemies) {
				if(isCollide(e, weapon)) {
					e.setisAlive(false);
				}
			}
		}
	}
	
	void isGameWin() {
		if(player.testLimit()) {
			gameMessage = "Game Win";
			timer.stop();
		}
	}
	void bindEvents() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				///TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				player.move();
				player.testLimit();
				}
				else if(e.getKeyCode()==KeyEvent.VK_UP) {
					player.jump();
				}
				else if(e.getKeyCode()== KeyEvent.VK_F) {
					try {
						player.addWeapon(player.getX() + player.getW(), player.getY() + player.getH()/2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
	Timer timer;
	void gameLoop()
	{
		//delay
		timer=new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("Timer call..."):
				repaint();
				checkCollision();
				isGameWin();
				player.fall();
				enemyFall();
				count++;
				if(count==10) {
					gameMessage="";
				}
			}
		});
		timer.start();
	}
	
	
	void printWeapons(Graphics pen) {
		ArrayList<Weapon> weapons = player.getWeapons();
		for(int i = 0; i<weapons.size(); i++) {
			Weapon currentWeapon = weapons.get(i);
			currentWeapon.draw(pen);
			currentWeapon.move();
			if(currentWeapon.outOfScreen()) {
				weapons.remove(i);
				//System.out.println(weapons.size());
			}
		}
//		Concurrent modification exception
//		for(Weapon weapon : weapons) {
//			weapon.draw(pen);
//			weapon.move();
//			if(weapon.outOfScreen()) {
//				weapons.remove(bullet);
//			}
//		}
	}
		
		
	
	void loadEnemies() throws Exception
	{
		int x=200;
		int speed=4;
		final int GAP =200;	
		for(int i=0;i<enemies.length;i++)
		{
			enemies[i]=new Enemy(x,speed);
			x=x+GAP;
			speed=speed+2;
		}
	}
	
	void printEnemies(Graphics pen)
	{
		for(Enemy e: enemies)
		{
			e.draw(pen);
			e.move();
		}
	}
	void printMessage(Graphics pen) {
		// TODO Auto-generated method stub
		pen.setColor(Color.RED);
		pen.setFont(new Font("times", Font.BOLD, BOARD_WIDTH/30));
		pen.drawString(gameMessage, BOARD_WIDTH/3, BOARD_HEIGHT/2);
	}
	
	// Painting on Board
	
	@Override
	public void  paintComponent(Graphics pen){
//		pen.setColor(Color.RED);
//		pen.fillRect(10, 50, 70, 50);
//		pen.drawRect(20, 100, 100, 100);
//		pen.drawOval(300, 50, 100, 100);
//		pen.setFont(new Font("times", Font.BOLD, 50));
//		pen.drawString("Game 2022", 300, 300);
		pen.drawImage(bi,0,0,BOARD_WIDTH, BOARD_HEIGHT, null);
		player.draw(pen);
		key.draw(pen);
		web.draw(pen);
		printWeapons(pen);
		//enemy.draw(pen);
		printEnemies(pen);
		if(gameMessage.length()>0){
		printMessage(pen);
		}	
	}
}