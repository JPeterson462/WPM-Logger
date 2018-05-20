package com.digiturtle.wpm;

import org.jnativehook.keyboard.NativeKeyEvent;

public class WPMCalculator {
	
	private long lastTime = 0;
	
	private StringBuffer buffer = new StringBuffer();
	
	public void start() {
		lastTime = System.currentTimeMillis();
	}
	
	public void update() {
		if (System.currentTimeMillis() - lastTime > 1_000 * 60) {
			System.out.println("Minute");
			int words = Utils.countWords(buffer.toString());
			buffer.setLength(0);
			System.out.println("WPM: " + words);
			lastTime = System.currentTimeMillis();
		}
	}

	public void keyPressed(NativeKeyEvent e) {
		buffer.append(e.getKeyChar());
	}
	
}
