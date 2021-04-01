package com.github.belivipro9x99.studentsmanager.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.github.belivipro9x99.studentsmanager.Components.Icon;
import com.github.belivipro9x99.studentsmanager.Components.OSCButton;
import com.github.belivipro9x99.studentsmanager.Components.OSCColor;
import com.github.belivipro9x99.studentsmanager.Components.TriangleBackground;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopupController implements Initializable {
	public TriangleBackground background;

	public HBox titleBox;
	public Label windowTitle;
	public HBox windowClose;
	public Boolean userSubmitted = false;
	
	public Label title;
	public Icon headerIcon;
	
	public OSCButton firstButton;
	public OSCButton secondButton;
	
	public Label inputLabel;

	public VBox inputBox;
	public TextField inputText;

	public VBox labelBox;
	public Label labelText;

	public VBox textAreaBox;
	public TextArea inputArea;

	private Double initialX;
	private Double initialY;

	private Stage stage;
	private String type;

	@Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading " + this.getClass().getName());

		titleBox.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				if (me.getButton() != MouseButton.MIDDLE) {
					initialX = me.getSceneX();
					initialY = me.getSceneY();
				}
			}
		});
	
		titleBox.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				if (me.getButton() != MouseButton.MIDDLE) {
					titleBox.getScene().getWindow().setX(me.getScreenX() - initialX);
					titleBox.getScene().getWindow().setY(me.getScreenY() - initialY);
				}
			}
		});

		windowClose.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				closeWindow();
			}
		});
    }

	private void hide(Pane pane) {
		pane.setVisible(false);
        pane.setManaged(false);
	}

	private void show(Pane pane) {
		pane.setVisible(true);
        pane.setManaged(true);
	}

	public void setStage(Stage stage) {
		this.stage = stage;
		this.setWindowTitle(this.stage.getTitle());
	}

	public void setType(String type) {
		this.type = type;
		hide(inputBox);
		hide(labelBox);
		hide(textAreaBox);

		switch (type) {
			case "input":
				show(inputBox);
				firstButton.setColor(OSCColor.GREEN);
				firstButton.setText("Xác Nhận");
				firstButton.setIcon("check");
				secondButton.setColor(OSCColor.YELLOW);
				secondButton.setText("Hủy");
				secondButton.setIcon("times");
				break;

			case "delete":
				show(labelBox);
				setIcon("trash");
				background.setColor(OSCColor.RED);
				firstButton.setColor(OSCColor.YELLOW);
				firstButton.setText("Xác Nhận");
				firstButton.setIcon("check");
				secondButton.setColor(OSCColor.BLUE);
				secondButton.setText("Hủy");
				secondButton.setIcon("times");
				break;

			case "error":
				show(textAreaBox);
				setIcon("exclamation");
				background.setColor(OSCColor.RED);
				firstButton.setColor(OSCColor.BLUE);
				firstButton.setText("OK");
				hide(secondButton);

				inputArea.setEditable(false);
				break;
		
			default:
				break;
		}
	}

	public String getValue() {
		if (this.userSubmitted)
			switch (this.type) {
				case "input":
					return inputText.getText();
			
				case "delete":
					return "delete";

				default:
					return null;
			}

		return null;
	}

	public void setLabel(String value) {
		inputLabel.setText(value.toUpperCase());
	}

	public void setText(String value) {
		labelText.setText(value);
	}

	public void setTextArea(String value) {
		inputArea.setText(value);
	}

	public void setTitle(String value) {
		title.setText(value);
	}

	public String getTitle() {
		return title.getText();
	}

	public void setWindowTitle(String value) {
		windowTitle.setText(value);
	}

	public String getWindowTitle() {
		return windowTitle.getText();
	}

	public void setIcon(String icon) {
		headerIcon.setIcon(icon);
	}

	public void userSubmit() {
		this.userSubmitted = true;
		this.closeWindow();
	}

	public void closeWindow() {
		stage.close();
	}
}
