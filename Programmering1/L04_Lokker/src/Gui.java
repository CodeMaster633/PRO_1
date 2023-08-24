import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {

//		int factor = 2;
//		int sizeX = 10*factor;
//		int sizeY = 4*factor;
//
//		int x = 100;
//		int y = 75;
//		gc.strokeLine(x, y, x + sizeX, y - sizeY);
//		gc.strokeLine(x, y, x + sizeX, y + sizeY);
//
//		x = 100;
//		y = 125;
//		gc.strokeLine(x, y, x + sizeX, y - sizeY);
//		gc.strokeLine(x, y, x + sizeX, y + sizeY);
//
//		x = 20;
//		y = 50;
//		gc.strokeLine(x, y, x + sizeX, y - sizeY);
//		gc.strokeLine(x, y, x + sizeX, y + sizeY);


// opg 2
		/*
		int x1 = 100; // start point: (x1,y1)
		int y1 = 100;
		int x2 = 20; // end point: (x2,y2)
		int y2 = 00;
		while (x2 <= 180) {
			gc.strokeLine(x1, y1, x2, y2);
			x2 = x2 + 20;*/

		// Opg 3
		/*
		int x1 = 20; // start point: (x1,y1)
		int y1 = 20;
		int x2 = 20; // end point: (x2,y2)
		int y2 = 180;
		while (x2 <= 800) {
			gc.strokeLine(x1, y1, x2, y2);
			x2 = x2 + 40;
			x1 += 40;
		 */

		//opg 3 d2
/*
		int x1 = 20; // start point: (x1,y1)
		int y1 = 20;
		int x2 = 180; // end point: (x2,y2)
		int y2 = 20;
		while (y2 <= 800) {
			gc.strokeLine(x1, y1, x2, y2);
			y2 = y2 + 40;
			y1 += 40;

 */

		//opg 3 d3
//
//		int x1 = 90; // start point: (x1,y1)
//		int y1 = 20;
//		int x2 = 110; // end point: (x2,y2)
//		int y2 = 20;
//		while (y2 <= 800) {
//			gc.strokeLine(x1, y1, x2, y2);
//			y2 = y2 + 40;
//			y1 += 40;
//			x1 -= 17;
//			x2 += 17;


		//Opg 4 del 1
/*
		int x = 100; // center: (x,y)
		int y = 100;
		int r = 40; // radius: r
		while (r <= 100) {
			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
			r = r + 15;
		}

		}

 */

		//Opg 4 del 2
/*
		int x = 30; // center: (x,y)
		int y = 100;
		int r = 20; // radius: r
		while (r <= 100) {
			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
			r = r + 15;
			x +=15;
		}
*/


		//Opg 4 del 3

//		int x = 100; // center: (x,y)
//		int y = 50;
//		int r = 20; // radius: r
//		int h = 100;
//		while (r <= 100) {
//			gc.strokeOval(x - r, y , 2 * r,  h);
//			r = r + 10;
//
//		}


		// Opg 5
		// Datamatiker

//		int x = 20; // center: (x,y)
//		int y = 150;
//
//		String s = "Datamatiker";
//		int i = 0;
//		while (i<=10) {
//			gc.fillText(s, x, y);
//			s = s.substring(0,s.length()-1);
//			y -= 10;
//			i++;
//
//		}


		//Opg 6

//		int y1 = 170; // start point: (x,y1)
//		int y2 = 180; // end point: (x,y2)
//		int y3 = (y1+y2)/2;
//		int x1 = 10;
//		int x2 = 180;
//
//		gc.strokeLine(x1,y3,x2,y3);
//
//		for (int i = 0; i < 11; i++) {
//			int x = 10 + i * 16;
//
//			if(i==0){
//
//				gc.strokeLine(x, y1-5, x, y2+5);
//			} else if(i==5){
//				gc.strokeLine(x, y1-5, x, y2+5);
//			} else if(i==10){
//				gc.strokeLine(x, y1-5, x, y2+5);
//			}
//
//			gc.strokeLine(x, y1, x, y2);
//
//		}
//
//		int factor = 1;
//		int sizeX = 5*factor;
//		int sizeY = 4*factor;
//
//		int x = 181;
//		int y = 175;
//		gc.strokeLine(x, y, x - sizeX, y + sizeY);
//		gc.strokeLine(x, y, x - sizeX, y - sizeY);


		// Opg 7

//		int x = 20;
//		int y = 150;
//
//		String s = "Datamatiker";
//
//		for(int i=0; i<=10; i++){
//			gc.fillText(s, x, y);
//			s = s.substring(0,s.length()-1);
//			y -= 10;
//		}

		//Opg 8
//		int x1 = 16; // start point: (x1,y1)
//		int y1 = 80;
//		int x2 = 16; // end point: (x2,y2)
//		int y2 = 160;
//		for (int i = 0; i < 10; i++) {
//			gc.strokeLine(x1, y1, x2, y2);
//			x2 += 16;
//			x1 += 16;
//			y2 -= 12;
//			y1 -= 4;

		// Opg 9
//		int x = 180; // start point: (x,y1)
//		int y3 = 180/5;
//		int y1 = y3-x/5+50;
//		int y2 = y3+x/2+50;
//
//		int i = 0;
//
//		while (x > 5) {
//			gc.strokeLine(x, y1, x, y2);
//
//			x *= 0.75;
//			y1 = y3-x/5+50;
//			y2 = y3+x/2+50;
//			i++;
//
//		}

		//opg 10

//	this.drawRing(gc, 40, 40);
//	this.drawRing(gc, 120, 80);
//		this.drawCircle(gc, 50, 100, 40);
//		this.drawCircle(gc, 75, 100, 40);
//		this.drawCircle(gc, 100, 100, 40);
//		this.drawCircle(gc, 125, 100, 40);
//		this.drawCircle(gc, 150, 100, 40);


//private void drawRing(GraphicsContext gc, int x, int y)
//	{
//		int r1 = 25;
//		int r2 = 20;
//		int r3 = 6;
//		gc.strokeOval(x - r1, y - r1, 2 * r1, 2 * r1);
//		gc.strokeOval(x - r2, y - r2, 2 * r2, 2 * r2);
//		gc.fillOval(x - r3, y - r1 - r3 / 2, 2 * r3, r3);
//	}
//	private void drawCircle(GraphicsContext gc, int x, int y, int r){
//		gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//	}

		//Opg 11

//		this.drawCircleWithCross(gc, 50, 100, 40, 20);

		//Opg 12
//
//		this.drawTriangle(gc, 20, 120, 81);
//
//		this.drawInnerTriangle(gc, 20, 120, 81);
//
//		this.drawInnerTriangle(gc, 20, 120, 81/3);
//		this.drawInnerTriangle(gc, 20+81*2/3, 120-81*2/3, 81/3);
//		this.drawInnerTriangle(gc, 20+81*4/3, 120, 81/3);

//	}
//	private void drawCircleWithCross (GraphicsContext gc,int x, int y, int r, int w){
//		gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//		gc.strokeLine(x-w/2, y, x+w/2, y);
//		gc.strokeLine(x, y-w/2, x, y+w/2);
//
//	}
//
//	private void drawTriangle(GraphicsContext gc, int x, int y, int h){
//		gc.strokeLine(x, y, x+h, y-h);
//		gc.strokeLine(x+h, y-h, x+h*2, y);
//		gc.strokeLine(x, y, x+h*2, y);
//	}
//
//	private void drawInnerTriangle(GraphicsContext gc, int x, int y, int h){
//
//		this.drawTriangle(gc, x,y,h/3);
//		this.drawTriangle(gc, x+h*2/3,y-h*2/3,h/3);
//		this.drawTriangle(gc, x+h*4/3,y,h/3);

	}}