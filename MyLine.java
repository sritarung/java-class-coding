package application;

import java.util.Optional;

import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape{
	MyPoint p1,p2;
	MyPoint [] pLine= new MyPoint[2];
	MyColor color;
	
	//constructor
	MyLine(MyPoint p1, MyPoint p2, MyColor color) {
		super(new MyPoint(), null);
		this.p1=p1;
		this.p2=p2;
		pLine[0]= p1; pLine[1]=p2;
		this.color= Optional.ofNullable(color).orElse(MyColor.YELLOW);
	}
	
	//Get methods
	public MyPoint[] getLine(){
		return pLine;
	}	
	public MyColor getColor() {
		return color;
	}
	
	//length
	public double length() {
		return p1.distance(p2);
	}
	
	// Angle in degrees with X axis
	public double angleX() {
		return p1.angleX(p2);
	}
	
	@Override
	public double area() {
		return 0;
	}
	
	@Override
	public double perimeter() {
		return (int)length();
	}
	
	@Override
	public MyRectangle getMyBoundingRectangle() {
	    double x1 = p1.getX(); double y1 = p1.getY();
	    double x2 = p2.getX(); double y2 = p2.getY();
	    MyPoint pT = new MyPoint(Math.min(x1, x2), Math.min(y1, y2),null);
	    
	    return new MyRectangle (pT, Math.abs(x1-x2), Math.abs(y1-y2), null);
	}
	
	@Override
	public boolean pointInMyShape(MyPoint point) {
        if (point.getX() < p2.getX()&&point.getY()<
        	p2.getY()&&point.getX()>p1.getX()&&point.getY()>p1.getY())
            return true;
        else {
            return false;}
    }
	@Override
	public void draw(GraphicsContext GC) {
		GC.setStroke(color.getJavaFXColor());
		GC.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
	
	@Override
	public String toString() {
		return "Line ["+p1+", "+p2+"] Length "+length();
	}
	
}
