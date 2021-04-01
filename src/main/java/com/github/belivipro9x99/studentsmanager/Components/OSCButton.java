package com.github.belivipro9x99.studentsmanager.Components;

import java.io.IOException;

import com.github.belivipro9x99.studentsmanager.Exception.ExceptionHandler;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class OSCButton extends HBox {
    public TriangleBackground background;
    public ColorAdjust backgroundAdjust;
    public Button button;
    public Icon buttonIcon;
    public StackPane iconContainer;

    public OSCButton() {
        initialize();
    }

    private void initialize() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OSCButton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }

        iconContainer.setVisible(false);
        iconContainer.setManaged(false);

        backgroundAdjust = new ColorAdjust();
        background.setEffect(backgroundAdjust);

        this.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                backgroundAdjust.setBrightness(0.16);
            }
        });

        this.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                backgroundAdjust.setBrightness(0);
            }
        });
    }

    public void setIcon(String icon) {
        iconContainer.setVisible(true);
        iconContainer.setManaged(true);

        try {
            buttonIcon.setIcon(icon);
        } catch (Exception e) {
            iconContainer.setVisible(false);
            iconContainer.setManaged(false);
        }
    }

    public String getIcon() {
        return buttonIcon.getIcon();
    }

    public void setText(String text) {
        button.setText(text.toUpperCase());
    }

    public String getText() {
        return button.getText();
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setColor(String color) {
        background.setColor(color);
    }

    public void setColor(Color color) {
        background.setColor(color);
    }

    public String getColor() {
        return background.getColor();
    }

    public void setScale(Double scale) {
		background.setScale(scale);
	}

	public Double getScale() {
		return background.getScale();
	}

	public void setSpeed(Double speed) {
		background.setSpeed(speed);
	}

	public Double getSpeed() {
		return background.getSpeed();
	}

	public void setCount(Integer count) {
		background.setCount(count);
	}

	public Integer getCount() {
		return background.getCount();
	}

    public void setDisable(Boolean disabled) {
        if (disabled) {
            background.setCursor(Cursor.DEFAULT);
            backgroundAdjust.setBrightness(-0.2);
        } else {
            background.setCursor(Cursor.HAND);
            backgroundAdjust.setBrightness(0);
        }

        button.setDisable(disabled);
    }

    public Boolean getDisable() {
        return button.isDisable();
    }

    /**
     * The button's action, which is invoked whenever the button is fired. This
     * may be due to the user clicking on the button with the mouse, or by
     * a touch event, or by a key press, or if the developer programmatically
     * invokes the {@link #fire()} method.
     * @return the property to represent the button's action, which is invoked
     * whenever the button is fired
     */
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() { return onAction; }
    public final void setOnAction(EventHandler<ActionEvent> value) { onActionProperty().set(value); }
    public final EventHandler<ActionEvent> getOnAction() { return onActionProperty().get(); }
    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return null;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
