package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {// takes stage as a parameter for the start method 
		//so can be called through launch(args) in the main method
		
		//pt created to be used by circle and polygon as center point 
		MyPoint pt= new MyPoint(300,300,MyColor.BLACK);
		//pt created to be used by rectangle and intersect
		MyPoint pt2= new MyPoint(165,195,MyColor.BLACK);
		MyPoint pt3= new MyPoint(435,405,MyColor.BLACK);
		MyPoint pt4= new MyPoint(165,405,MyColor.BLACK);
		MyPoint pt5= new MyPoint(435,195,MyColor.BLACK);
		
		//smallest circle
		MyCircle circle= new MyCircle(pt,52.9508497188,MyColor.WHITE);
		//the second smallest circle
		MyCircle circle1= new MyCircle(pt,65.4508497188,MyColor.SKYBLUE);
		//the second biggest circle
		MyCircle circle2= new MyCircle(pt,80.9016994375,MyColor.LIGHTGREEN);
		//the big circle
		MyCircle circle3= new MyCircle(pt,100,MyColor.PINK);
		
		//the biggest polygon
		MyPolygon p= new MyPolygon(pt,100,5,MyColor.LIGHTYELLOW);
		//the second biggest polygon
		MyPolygon p2= new MyPolygon(pt,80.9016994375,5,MyColor.LIGHTPURPLE);
		//the third biggest polygon
		MyPolygon p3= new MyPolygon(pt,65.4508497188,5,MyColor.BURGUNDY);
		
		//the bounding rectangle and intersects
		MyRectangle r= p.getMyBoundingRectangle();
		MyRectangle rect= new MyRectangle(pt2,270,210,MyColor.WHITE);
		
		MyLine l= new MyLine(pt2,pt3,MyColor.BLACK);
		MyLine l2= new MyLine(pt4,pt5,MyColor.BLACK);
		
		
		
		//sets the title for the stage	
		primaryStage.setTitle("Assignment 2");
		//create a group root for the stage
        Group root = new Group();
        //create a canvas with width and height
        Canvas canvas = new Canvas(600, 600);
        // initialize graphics context of 2d
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //call the draw methods of all the objects created with graphics context object of 2d as parameter
        //drawn in order to draw smaller objects over bigger

        r.draw(gc);
        rect.draw(gc);
        circle3.draw(gc);
        p.draw(gc);
        circle2.draw(gc);
        p2.draw(gc);
        circle1.draw(gc);
        p3.draw(gc);
        circle.draw(gc);
        if(p.pointInMyShape(pt)) {
        	pt.draw(gc);
		 }
        l.draw(gc);
        l2.draw(gc);
    
        //add canvas to the group root so can be printed on the screen
        root.getChildren().add(canvas);
        //add new scene of the group root to stage
        primaryStage.setScene(new Scene(root));
        //show the stage
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		//launch the start method
		launch(args);
	}
}
