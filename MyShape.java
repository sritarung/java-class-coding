package application;

import java.util.List;
import java.util.Optional;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MyShape {
	MyPoint p;
	MyColor color;
	
	//constructor
	MyShape(MyPoint p, MyColor color){ setPoint(p); this.color= Optional.ofNullable(color).orElse(MyColor.YELLOW);}
	MyShape(double x, double y, MyColor color){setPoint(x,y); this.color= Optional.ofNullable(color).orElse(MyColor.YELLOW);}
	
	//Set methods
	public void setPoint(MyPoint p) {
		this.p= p;
	}
	public void setPoint(double x, double y) {
		p.setPoint(x,y);
	}
	
	//Get methods
	public MyPoint getPoint() {
		return p;
	}
	public double getX() {
		return p.getX();
	}
	public double getY() {
		return p.getY();
	}
	public MyColor getColor() {
		return color;
	}
	
	//methods
	public double area() {
		return 0.0;
	}
	public double perimeter() {
		return 0.0;
	}
	
	public boolean pointInMyShape(MyPoint point) {
		return false;
	}
	
	public MyRectangle getMyBoundingRectangle() {
		return null;
	}
	
	public void draw(GraphicsContext GC) {
		GC.setFill(color.getJavaFXColor());
		GC.fillRect(0,0,GC.getCanvas().getWidth(),GC.getCanvas().getHeight());
	}
	
	interface MyShapeInterface {
	    MyRectangle getMyBoundingRectangle();
	    public default Canvas drawIntersectMyShape(MyShape S1, MyShape S2) {
	    	List<MyPoint> intersect = intersectMyShapes(S1, S2);

		    if (intersect != null) {
		        Canvas CV = new Canvas();
		        GraphicsContext GC = CV.getGraphicsContext2D();

		        for (MyPoint p : intersect) {
		            p.draw(GC);
		        }

		    return CV;
		    }
		    else {
		        return null;
		    }
	    }
	}

	
	public static List<MyPoint> intersectMyShapes(MyShape S1, MyShape S2) {
		return null;
	}
	
	@Override
	public String toString(){
		return "This is MyShape Object";
	}
	
}
