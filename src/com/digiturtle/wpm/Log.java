package com.digiturtle.wpm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Log {
	
	public static void setup() {
		try {
			System.setOut(new PrintStream(new FileOutputStream("log.txt")));
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static void info(String msg) {
		System.out.println(msg);
	}

}
