package application;

import java.util.Optional;

import javafx.scene.canvas.GraphicsContext;

import java.lang.Math;

public class MyCircle extends MyShape{

	MyPoint pCenter;
	double radius;
	MyColor color;
	
	MyCircle(MyPoint p, double r, MyColor color){
		super(new MyPoint(), null);
		this.pCenter= p;
		this.radius= r;
		this.color= Optional.ofNullable(color).orElse(MyColor.YELLOW);
	}
	//Get methods
	public MyPoint getCenter(){return pCenter;}
	public double getRadius() {return radius;}
	public MyColor getColor() {return color;}
	
	@Override
	public double area() {
		return (Math.PI*Math.pow(radius, 2));
	}
	
	@Override
	public double perimeter() {
		return 2*(Math.PI*radius);
	}

	@Override
	public MyRectangle getMyBoundingRectangle() {
	    double x = pCenter.getX() - radius;
	    double y = pCenter.getY() - radius;
	    MyPoint pT = new MyPoint(x, y,null);
	    
	    return new MyRectangle(pT, 2*radius, 2*radius, null);
	}
	
	@Override
	public boolean pointInMyShape(MyPoint point) {
        if (point.distance(pCenter) < radius)
            return true;
        else {
            return false;}
    }
	@Override
	public void draw(GraphicsContext GC) {
		GC.setFill(color.getJavaFXColor());
		GC.setStroke(color.getJavaFXColor());
		GC.strokeOval(pCenter.getX()- radius, pCenter.getY()-radius,2*radius, 2*radius);
		GC.fillOval(pCenter.getX()- radius, pCenter.getY()-radius,2*radius, 2*radius);
	}
	
	@Override
	public String toString() {
		return "Circle center ("+pCenter.getX()+", "+pCenter.getY()+") Radius "+radius+
				"Perimeter "+perimeter()+"Area "+area();
	}
}
