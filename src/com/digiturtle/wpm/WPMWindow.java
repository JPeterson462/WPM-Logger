package com.digiturtle.wpm;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WPMWindow extends Application {
	
	public static WPMCalculator calculator;

	private void setLabelSize(Label label, float width, float height) {
		label.setMinWidth(width);
		label.setPrefWidth(width);
		label.setMaxWidth(width);
		label.setMinHeight(height);
		label.setPrefHeight(height);
		label.setMaxHeight(height);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setAlwaysOnTop(true);
		Group root = new Group();
		final float width = 100, height = 100;
		Label label = new Label("0");
		label.setLayoutX(0);
		label.setLayoutY(0);
		setLabelSize(label, width, height);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setAlignment(Pos.CENTER);
		label.setTextFill(Color.LIME);
		label.setStyle("-fx-font: 36 arial;");
		root.getChildren().add(label);
		Scene scene = new Scene(root, width, height, Color.BLACK);
		stage.setTitle("WPM");
		stage.setScene(scene);
		stage.setX(20);
		stage.setY(20);
		
		stage.setResizable(false);
		stage.show();
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						label.setText(calculator.getWPM() + "");
					}
				});
			}
		}, 0, 100, TimeUnit.MILLISECONDS);
	}
	
}
