package com.github.belivipro9x99.studentsmanager.Components;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.github.belivipro9x99.studentsmanager.Exception.ExceptionHandler;

import javafx.animation.AnimationTimer;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TriangleBackground extends Canvas implements Initializable {
	public AnimationTimer timer;
	public ArrayList<Triangle> triangles = new ArrayList<Triangle>();

	private GraphicsContext gc;
	private Pane parent;

	public Double width;
	public Double height;

	private Color globalColor = OSCColor.BLUE;
	public Double globalScale = 2d;
	public Double globalSpeed = 18d;
	public Integer triangleCount = 16;

	public class Triangle {
		public Color color;

		public Double leftPos;
		public Double scale;
		public Double duration;

		private Double sTime = null;
		private GraphicsContext gc;
		
		public Triangle(GraphicsContext gc, Color color) {
			this.setColor(color);
			this.gc = gc;
			initialize();
		}

		private Double randBetween(Double min, Double max) {
			return (Math.random() * (max - min) + min);
		}

		private Color changeBrightness(Color color, Double brightness) {
			Double bval = color.getBrightness() * 0.98d;
			Double sval = color.getSaturation() * 0.94d;

			Double bvd = Math.min(1 - bval, bval);
			Double svd = Math.min(1 - sval, sval);
			
			Double v = 0d;

			if (brightness <= 1)
				v = brightness - 1;
			else
				v = Math.abs((1d / brightness) - 1d);

			return Color.hsb(color.getHue(), sval - (svd * v), bval + (bvd * v));
		}

		public void initialize() {
			this.scale = randBetween(0.5d, 2d) * globalScale;
			this.leftPos = Math.random();
			this.duration = globalSpeed / this.scale;
		}

		public void setColor(Color color) {
			Double r;
			if (color == OSCColor.YELLOW || color == OSCColor.ORANGE)
				r = randBetween(0.3d, 1.8d);
			else if (color == OSCColor.WHITESMOKE)
				r = randBetween(0.6d, 0.9d);
			else
				r = randBetween(0.9d, 1.6d);

			this.color = changeBrightness(color, r);
		}

		public void update(Double t) {
			if (sTime == null)
				sTime = t - (duration * randBetween(0d, 1d));

			if (t - sTime > duration)
				sTime = t;

			Double p = (t - sTime) / duration;
			Double h = scale * 30d;
			Double l = h / (Math.sqrt(3) / 2d);

			Double fromX = -l;
			Double toX = width + l;
			Double xPos = fromX + (toX - fromX) * leftPos;

			Double fromY = height + h + 30d;
			Double toY = -15d;
			Double yPos = fromY + (toY - fromY) * p;

			gc.setFill(color);
			drawTriangle(new Point2D(xPos, yPos), h);
		}

		public void drawTriangle(Point2D i, Double h) {
			Double n = (h / (Math.sqrt(3) / 2d)) / 2d;

			Point2D a = new Point2D(i.getX(), i.getY() - h);
			Point2D b = new Point2D(i.getX() + n, i.getY());
			Point2D c = new Point2D(i.getX() - n, i.getY());

			gc.fillPolygon(
				new double[] {
					a.getX(), b.getX(), c.getX()
				}, new double[] {
					a.getY(), b.getY(), c.getY()
				},
				3
			);
		}
	}

	public TriangleBackground() {
		super();
		this.gc = this.getGraphicsContext2D();
		this.setManaged(false);

		generateTriangles();
		setColor(globalColor);

		// Init Timer
        timer = new AnimationTimer() {
			@Override
			public void handle(long st) {
				double t = st / 1000000000d;
				update(t);
			}
		};

		timer.start();
    }

	public void generateTriangles() {
		triangles = new ArrayList<Triangle>();

		for (int i = 0; i < triangleCount; i++) {
			Triangle triangle = new Triangle(gc, globalColor);
			triangles.add(triangle);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.setWidth(((Pane) this.getParent()).getWidth());
		this.setHeight(((Pane) this.getParent()).getHeight());
	}

	public void update(Double t) {
		if (parent == null)
			parent = (Pane) this.getParent();

		if (parent != null) {
			this.width = parent.getWidth();
			this.height = parent.getHeight();
			this.setWidth(width);
			this.setHeight(height);
		}

		gc.setFill(globalColor);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());

		for (Triangle triangle : triangles)
			triangle.update(t);
	}

	@Override
	public boolean isResizable() {
		return true;
	}

	@Override
	public void finalize() {
		timer.stop();
	}

	public void initAllTriangles() {
		for (Triangle triangle : triangles)
			triangle.initialize();
	}

	public void setScale(Double scale) {
		this.globalScale = scale;
		initAllTriangles();
	}

	public Double getScale() {
		return this.globalScale;
	}

	public void setSpeed(Double speed) {
		this.globalSpeed = speed;
		initAllTriangles();
	}

	public Double getSpeed() {
		return this.globalSpeed;
	}

	public void setCount(Integer count) {
		this.triangleCount = count;
		generateTriangles();
	}

	public Integer getCount() {
		return this.triangleCount;
	}

	public void setColor(String colorCode) {
		try {
			Object object = OSCColor.class.getField(colorCode.toUpperCase()).get(null);
	
			if (object instanceof Color)
				setColor((Color) object);
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
	}

	public void setColor(Color color) {
		this.globalColor = color;

		for (Triangle triangle : triangles)
			triangle.setColor(color);
	}

	public String getColor() {
		return "";
	}
}
