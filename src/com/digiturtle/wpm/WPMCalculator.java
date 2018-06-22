package com.digiturtle.wpm;

import org.jnativehook.keyboard.NativeKeyEvent;

public class WPMCalculator {
	
	private long lastTime = 0;
	
	private int wpm;
	
	private StringBuffer buffer = new StringBuffer();
	
	public void start() {
		lastTime = System.currentTimeMillis();
	}
	
	public void update() {
		if (System.currentTimeMillis() - lastTime > 1_000 * 60) {
			Log.info("Minute");
			wpm = Utils.countWords(buffer.toString());
			buffer.setLength(0);
			Log.info("WPM: " + getWPM());
			lastTime = System.currentTimeMillis();
		}
	}
	
	public int getWPM() {
		return wpm;
	}

	public void keyPressed(NativeKeyEvent e) {
		buffer.append(e.getKeyChar());
	}
	
}
