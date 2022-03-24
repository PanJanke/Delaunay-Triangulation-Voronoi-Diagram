package pl.jano;

import java.util.ArrayList;

public class Voronoi {


    public ArrayList<Edge> start(ArrayList<Triangle> triangleList){
        ArrayList<Edge> result = new ArrayList<>();

        for(int i=0;i< triangleList.size();i++){
            Triangle triangle = triangleList.get(i);
            Point a = triangle.CircleCenter();


            for(int j=0;j< triangleList.size();j++){
                if(i==j)
                    continue;
                Triangle tempTriangle = triangleList.get(j);

                if(tempTriangle.shareEdge(triangle.a,triangle.b)){
                    Edge edge = new Edge(a,tempTriangle.CircleCenter());
                    result.add(edge);
                }
                else if(tempTriangle.shareEdge(triangle.a,triangle.c)){
                    Edge edge = new Edge(a,tempTriangle.CircleCenter());
                    result.add(edge);
                }
                else if(tempTriangle.shareEdge(triangle.b,triangle.c)){
                    Edge edge = new Edge(a,tempTriangle.CircleCenter());
                    result.add(edge);
                }


            }



        }
        return result;

    }
}
