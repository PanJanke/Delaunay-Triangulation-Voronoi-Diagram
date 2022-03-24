package pl.jano;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        Random rand = new Random();
        int n= 20;
        int bound = 150;

        ArrayList<Point> pointList = new ArrayList<>();
        for(int i=0;i<n;i++)
            pointList.add(new Point(rand.nextInt(bound),rand.nextInt(bound)));


        Delanuay delanuay = new Delanuay();
        ArrayList<Triangle> triangles = delanuay.start(pointList);

        Voronoi voronoi = new Voronoi();
        ArrayList<Edge> edges = voronoi.start(triangles);



        CartesianFrame frame = new CartesianFrame();
        frame.panel.getPoints(pointList); //wysylam wszystkie punkty
        frame.panel.getPoints2(triangles);
        frame.showUI("Delanuay");

        KartesianFrame frame2 = new KartesianFrame();
        frame2.panel.getPoints(pointList);
        frame2.panel.getEdges(edges);
        frame2.showUI("Voronoi");




    }
}
