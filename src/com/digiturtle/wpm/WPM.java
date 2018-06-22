package com.digiturtle.wpm;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import javafx.application.Application;

public class WPM {
	
	public static void main(String[] args) throws NativeHookException {
		Log.setup();
		Log.info("Starting up...");
		WPMCalculator calculator = new WPMCalculator();
		calculator.start();
		WPMWindow.calculator = calculator;
		Application.launch(WPMWindow.class, args);
		GlobalScreen.addNativeKeyListener(new InputHandler(calculator));
		GlobalScreen.registerNativeHook();
		while (true) {
			calculator.update();
		}
	}

}