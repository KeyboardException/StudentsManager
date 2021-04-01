package com.github.belivipro9x99.studentsmanager.Components;

import com.github.belivipro9x99.studentsmanager.App;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icon extends ImageView {
	public Icon() {
		super();
		this.setPickOnBounds(true);
		this.setPreserveRatio(true);
	}

    public void setIcon(String icon) {
		Image image = new Image(App.class.getResource("layouts/img/" + icon + ".png").toString());
		this.setImage(image);
    }

    public String getIcon() {
        return "";
    }
}
