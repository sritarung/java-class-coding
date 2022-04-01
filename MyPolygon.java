package application;

import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape {
	
	int n;//the number of the polygon’s equal side lengths and equal interior angles
	MyPoint pCent;
	double radius;
	MyColor color;
	
	MyPolygon(MyPoint p,double r,int num,MyColor color){
		super(new MyPoint(), null);//Invokes superclass constructor. sets the reference point 
		//of MyShape object to the origin of display canvas
		this.pCent= p;
		this.radius= r;
		this.color= color; 
		this.n=num;
	}
	
	public int getN() {return n;}
	public MyPoint getCenter(){return pCent;}
	public double getRadius() {return radius;}
	public MyColor getColor() {return color;}
	
	public double getSide() {
		return 2*apothem()*Math.atan2(180,n);
	}

	public double getAngle() {
		return ((n-2)*180)/n;
	}
	
	public double apothem() {
		return radius*Math.cos(180/n);
	}
	
	@Override
	public double area() {
		return (apothem()*perimeter())/2;
	}
	
	@Override
	public double perimeter() {
		return getSide()*n;
	}

	@Override
	public void draw(GraphicsContext GC) {
		double [] x= new double[n];
		double [] y= new double[n];
		double ang= Math.PI/2;
		for(int i=0; i<x.length; i++) {
			ang+=(2*Math.PI/n);
			x[i]= (-radius*Math.cos(ang)+pCent.getX());
			y[i]= (-radius*Math.sin(ang)+pCent.getY());
		}
		GC.setStroke(color.getJavaFXColor());
		GC.setFill(color.getJavaFXColor());
		GC.strokePolygon(x, y, n);
		GC.fillPolygon(x, y, n);
	}

	@Override
	public String toString() {
		return "Polygon center("+pCent.getX()+", "+pCent.getY()+"), Side length: "+getSide()+
				", Interior angle: "+getAngle()+", Perimeter: "+perimeter()+", Area:"+area();
	}
	
	@Override
	public MyRectangle getMyBoundingRectangle() {
		double[] x= new double[n];
		double[] y= new double [n];
		double ang= Math.PI/2;
		for(int i=0; i<x.length; i++) {
			ang+=(2*Math.PI/n);
			x[i]=(-radius*Math.cos(ang)+pCent.getX());
			y[i]=(-radius*Math.sin(ang)+pCent.getY());
		}
		int xmax= (int) x[0];
		int ymax= (int) y[0];
		int xmin= (int) x[0];
		int ymin= (int) y[0];
		for(int i = 0;i<x.length;i++){
			if(x[i]>xmax) xmax=(int) x[i];
            if(y[i]>ymax) ymax=(int) y[i];
            if(x[i]<xmin) xmin=(int) x[i];
            if(y[i]<ymin) ymin=(int) y[i];
        }
        MyPoint p = new MyPoint(xmin,ymin,color);
        MyRectangle r = new MyRectangle(p, xmin, ymin, MyColor.WHITE);
        return r;
	}
	
	@Override
	public boolean pointInMyShape(MyPoint point) {
        if (point.distance(pCent) < radius)
            return true;
        else {
            return false;}
    }
}
