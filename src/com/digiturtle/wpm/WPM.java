package com.digiturtle.wpm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class WPM {
	
	public static void main(String[] args) throws NativeHookException, FileNotFoundException {
		System.setOut(new PrintStream(new FileOutputStream("log.txt")));
		System.out.print("Starting up...");
		WPMCalculator calculator = new WPMCalculator();
		calculator.start();
		GlobalScreen.addNativeKeyListener(new InputHandler(calculator));
		GlobalScreen.registerNativeHook();
		while (true) {
			calculator.update();
		}
	}

}