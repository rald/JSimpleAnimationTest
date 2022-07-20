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

    public static int cx=0,cy=0;

    int x=64,y=64;
    int frame=0;

    UFO[] ufo = new UFO[3];

    Panel() {

        setBackground(Color.BLACK);


        ufo[0]=new UFO(Color.RED,70,110);
        ufo[1]=new UFO(Color.GREEN,110,70);
        ufo[2]=new UFO(Color.BLUE,130,170);

    }

    public void draw(Graphics g) {
        cx=this.getWidth()/2;
        cy=this.getHeight()/2;

        ufo[0].draw(g);
        ufo[1].draw(g);
        ufo[2].draw(g);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

}



class UFO {

    double x,y;
    double a,b;
    int frame=0;
    Color color;

    UFO(Color color,double a,double b) {
        this.color=color;
        this.a=a;
        this.b=b;
    }

    public void draw(Graphics g) {
        x=Panel.cx+Math.cos(frame/this.a)*200;
        y=Panel.cy+Math.sin(frame/this.b)*200;

        g.setColor(this.color);
        g.fillOval((int)x,(int)y,32,32);

        frame++;
    }

}


