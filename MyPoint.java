package application;

import java.lang.Math;
import java.util.Optional;

import javafx.scene.canvas.GraphicsContext;

public class MyPoint {
	double x, y; // x and y coordinates
	MyColor color; //Color of pixel
	
	// Constructors
	MyPoint(){ 
		setPoint(0.0,0.0);
		this.color= MyColor.YELLOW;
	}
	
	MyPoint(double x, double y, MyColor color){
		setPoint(x,y);
		this.color= Optional.ofNullable(color).orElse(MyColor.YELLOW);
	}
	
	MyPoint(MyPoint P, MyColor color){
		setPoint(P);
		this.color= Optional.ofNullable(color).orElse(MyColor.YELLOW);
	}
	
	//Set methods
	public void setPoint(double x, double y) {
		this.x=x; this.y=y;
	}
	
	public void setPoint(MyPoint P) {
		this.x = P.getX(); this.y= P.getY();
	}
	
	//Get methods
	public double getX() {return x; }
	public double getY() {return y; }
	public MyColor getColor() {return color;}
	
	//shift the x and y coordinates by the given amounts
	public void translate(int dx, int dy) {
		setPoint(x+dx, y+dy);
	}
	
	//compute distance from origin
	public double distanceFromOrigin() {return Math.sqrt(x*x+y*y);}
	
	public double distance(MyPoint P) {
		double dx= x- P.getX();
		double dy= y- P.getY();
		return (Math.sqrt(dx*dx + dy*dy));
	}
	
	//compute angle with x axis of line extending from this point to point P
	// atan2 allows calculating arc tangent of all four quadrants
	public double angleX(MyPoint P) {
		double dx= (double)(P.getX()-x);
		double dy= (double)(P.getY()-y);
		return Math.toDegrees(Math.atan2(dy, dx));	
	}
	
	//Draw a point on canvas
	public void draw(GraphicsContext GC) {
		
		GC.setFill(color.getJavaFXColor());
		GC.fillRect(x,y,1,1);
	}
	
	@Override
	public String toString() {return "Point P("+x+", "+y+")";}
}
