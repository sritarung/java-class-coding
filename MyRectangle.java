package application;

import java.util.Optional;

import javafx.scene.canvas.GraphicsContext;


public class MyRectangle extends MyShape {

	MyPoint pt;
	double width, height;
	MyColor color;
	
	MyRectangle(MyPoint p, double w, double h, MyColor color){
		super(new MyPoint(), null);//Invokes the superclass constructor. Sets the reference point
		//of MyShape object to the origin of the display canvas
		this.pt= p; this.width= w; this.height=h;
		this.color= Optional.ofNullable(color).orElse(MyColor.YELLOW);
	}
	
	//Get methods
	public MyPoint getP() {return pt;}
	public double getWidth() {return width;}
	public double getHeight() {return height;}
	public MyColor getColor() {
		return color;
	}

	@Override
	public MyRectangle getMyBoundingRectangle() {
	    return new MyRectangle(pt, width, height, null);
	}
	
	@Override
	public boolean pointInMyShape(MyPoint point) {
        if (point.getX() < pt.getX()+width && point.getY()< pt.getY()+height)
            return true;
        else {
            return false;}
    }
	
	@Override
	public double area() {
		return width*height;
	}
	@Override
	public double perimeter() {
		return 2*(width+height);
	}
	@Override
	public void draw(GraphicsContext GC) {
		GC.setFill(color.getJavaFXColor());
		GC.setStroke(MyColor.BLACK.getJavaFXColor());
		GC.strokeRect(pt.getX(),pt.getY(),width,height);
		GC.fillRect(pt.getX(),pt.getY(),width,height);
	}
	@Override
	public String toString() {
		return "Rectangle top left corner "+pt+" Width: "+width+" Height: "+height+" Perimeter: "+perimeter() +" Area"+ area();
	}
	
}
