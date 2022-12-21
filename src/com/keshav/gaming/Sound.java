package com.keshav.gaming;

import java.io.File;

import jaco.mp3.player.MP3Player;

public class Sound {
	MP3Player mp1, mp2;
	String checksound;
	public void setChecksound(String checksound) {
		this.checksound = checksound;
	}
	public Sound() {
		mp1 = new MP3Player(new File("src\\com\\keshav\\gaming\\horror-sound.mp3"));
		mp1.play();
	}
	public void soundplay() {
		if(checksound=="win") {
			mp2 = new MP3Player(new File("src\\com\\keshav\\gaming\\sprite\\win-sound.mp3"));
		}
		else if(checksound=="collide") {
			mp2 = new MP3Player(new File("src\\com\\keshav\\gaming\\sprite\\collide-sound.mp3"));
		}
		else if(checksound=="jump") {
			mp2 = new MP3Player(new File("src\\com\\keshav\\gaming\\sprite\\jump.mp3"));
		}
		else if(checksound=="enemydie") {
			mp2 = new MP3Player(new File("src\\com\\keshav\\gaming\\sprite\\enemydie.mp3"));
		}
		else if(checksound=="weapon") {
			mp2 = new MP3Player(new File("src\\com\\keshav\\gaming\\sprite\\weapon.mp3"));
		}
		mp2.play();
	}
}
