import javax.swing.*;
import java.awt.*;



public class Program extends JFrame implements Runnable {

	Panel panel = new Panel();
	Thread thread = new Thread(this);
	boolean running=false;
	
	Program() {
	
		setSize(640,480);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		add(panel);

		thread.run();
	}

	public void run() {
		running=true;
		while(running) {
			repaint();
		}
	}

	public static void main(String[] args) {
		Program program = new Program();
	}

	
}



class Panel extends JPanel {

	int x=64,y=64;
	int frame=0;

	UFO[] ufo = new UFO[3];

	Panel() {
		setBackground(Color.BLACK);
		ufo[0]=new UFO();
		ufo[1]=new UFO();
		ufo[2]=new UFO();
	}

	public void draw(Graphics g) {		
		ufo[0].draw(g,70,110,Color.RED);
		ufo[1].draw(g,110,70,Color.GREEN);
		ufo[2].draw(g,110,130,Color.BLUE);				
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

}



class UFO {

	double cx=640/2,cy=480/2;
	double x,y;
	int frame=0;

	public void draw(Graphics g,double a,double b,Color color) {
		x=cx+Math.cos(frame/a)*200;
		y=cy+Math.sin(frame/b)*200;

		g.setColor(color);
		g.fillOval((int)x,(int)y,32,32);		

		frame++;
	}
		
}


