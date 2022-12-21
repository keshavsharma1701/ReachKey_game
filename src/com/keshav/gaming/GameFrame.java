 package com.keshav.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements Constants{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Constructor
	GameFrame() throws Exception{
		Board board = new Board();
		
		this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Horror Game");
		setLocationRelativeTo(null);
		setResizable(false);
		add(board);
		setVisible(true);
	}

	//Timer (internally thread)

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//System.out.println(Thread.currentThread());	
		GameFrame obj=new GameFrame();
	}
}