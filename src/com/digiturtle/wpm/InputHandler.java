package com.digiturtle.wpm;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class InputHandler implements NativeKeyListener {
	
	private WPMCalculator calculator;
	
	public InputHandler(WPMCalculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {

	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		calculator.keyPressed(e);
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {

	}

}
