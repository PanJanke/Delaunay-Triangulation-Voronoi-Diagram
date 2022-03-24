package pl.jano;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class Cartesian {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                CartesianFrame frame = new CartesianFrame();
                frame.showUI("");
            }
        });
    }

}

class CartesianFrame extends JFrame {
    CartesianPanel panel;



    public CartesianFrame() {
        panel = new CartesianPanel();
        add(panel);
    }

    public void showUI(String name) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(name);
        setSize(800, 800);
        setVisible(true);
    }
}

class CartesianPanel extends JPanel {


    public  ArrayList<Point> pointList;
    public  ArrayList<Triangle> triangleList;

    private Color lineColor = new Color(255,0,0);
    private Color pointColor = new Color(0,0,255 );
    private Color pointColor2 = new Color(0,0,0 );

    public static final int point_diameter = 4;

    public static final int X_center = 300; //mniej wiecej srodek
    public static final int Y_center = 300;




    public void getPoints(ArrayList <Point> tab){
        this.pointList =tab;
    }

    public void getPoints2(ArrayList <Triangle> tab){
        this.triangleList =tab;
    }



    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


        //rysuje wszystkie punkty

        g2.setColor(pointColor2);
        for (int i = 0; i < pointList.size(); i++) {
            g2.drawOval((int) (X_center + pointList.get(i).x), (int) (Y_center + pointList.get(i).y), point_diameter, point_diameter);
        }

        g2.setColor(pointColor);
        g2.drawOval((int) (X_center - 100), (int) (Y_center - 100), point_diameter, point_diameter);
        g2.drawOval((int) (X_center + 300), (int) (Y_center), point_diameter, point_diameter);
        g2.drawOval((int) (X_center), (int) (Y_center + 300), point_diameter, point_diameter);


        //rysuje trojkaty

        for (int i = 0; i < triangleList.size(); i++) {
            g2.drawLine((int) (X_center + triangleList.get(i).a.x), (int) (Y_center + triangleList.get(i).a.y), (int) (X_center + triangleList.get(i).b.x), (int) (Y_center + triangleList.get(i).b.y));
            g2.drawLine((int) (X_center + triangleList.get(i).a.x), (int) (Y_center + triangleList.get(i).a.y), (int) (X_center + triangleList.get(i).c.x), (int) (Y_center + triangleList.get(i).c.y));
            g2.drawLine((int) (X_center + triangleList.get(i).b.x), (int) (Y_center + triangleList.get(i).b.y), (int) (X_center + triangleList.get(i).c.x), (int) (Y_center + triangleList.get(i).c.y));

        }
    }
}