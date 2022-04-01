package application;

import javafx.scene.paint.Color;
	
enum MyColor{
	BLACK(0,0,0,255),
	BLUE(0,0,255,255),
	BROWN(165,42,42,255),
	BURGUNDY(128,0,32,255),	
	CYAN(0,255,255,255),
	GOLD(255,215,0,255),
	INDIANRED(205,92,92,255),
	LIGHTGREEN(178, 255, 89,255),
	LIGHTORANGE(255,213,128,255),
	LIGHTYELLOW(255,255,167,255),
	LIGHTPURPLE(233,211,255,255),
	LIME(0,255,0,255),
	MAROON(128,0,0,255),
	NAVY(0,0,128,255),
	ORANGE(255,215,0,255),
	PINK(255,192,203,255),
	PURPLE(128,0,128,255),
	SANDYBROWN(244,164,96,255),
	SILVER(192,192,192,255),
	SKYBLUE(135,206,235,255),	
	STEELBLUE(70,130,180,255),
	TOAD(164, 186, 74,255),
	TEAROSE(244,194,194,255),
	WHITE(255,255,255,255),
	YELLOW(255,255,0,255),
	YELLOWGREEN(154,205,50,255);
			
	//Instance variables
	private int r; //Red 
	private int g;
	private int b;
	private int a;
	private int argb;
			
			
	//Constructor
	MyColor(int r, int g, int b, int a){
		setR(r);
		setG(g);
		setB(b);
		setA(a);
		setARGB(r,g,b,a);
	}
			
	//set methods
	public void setR(int r){ if(r>=0 && r<=255) this.r =r;}
	public void setG(int g) {if(g>=0 && g<=255) this.g =g;}
	public void setB(int b) {if(b>=0 && b<=255) this.b =b;}
	public void setA(int a) {if(a>=0 && a<=255) this.a =a;}
			
	public void setARGB(int r, int g, int b, int a) {
		this.argb= (a<< 24) & 0xFF000000 |
		           (r<< 16) & 0x00FF0000 |
				   (g<< 8) & 0x0000FF00 |
				   b;
	}
			
	//get methods
	public int getR() { return r; }
	public int getG() { return g; }
	public int getB() { return b; }
	public int getA() { return a; }
	public int getARGB() { return argb; }
			
	//hexadecimal representation
	public String getHexColor() {
		return "#"+ Integer.toHexString(argb).toUpperCase();
	}
	
	public Color getJavaFXColor() {
		return Color.rgb(r,g,b,(double)a/255.0);
	}
	
	public Color getJavaFXOpaqueColor() {
		return Color.rgb(r,g,b);
	}
	
	public static MyColor [] getMyColors() {
		return MyColor.values();
	}

			
	@Override
	public String toString() {
		return this+ "(" + this+", "+this.g+", "+this.b+ ", "+this.a+ ")" 
				+ "Hexadecimal Code: "+this.getHexColor();
	}
}


