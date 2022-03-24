package pl.jano;

import java.util.ArrayList;

public class Delanuay {

    public ArrayList<Triangle> start(ArrayList<Point> pointList){

        //budowa supertrojkata (narazie na sztywno)
        Point superA = new Point(-100,-100);
        Point superB = new Point(500,0);
        Point superC = new Point(0,500);
        Triangle superTriangle = new Triangle(superA,superB,superC);

        pointList.add(superA);
        pointList.add(superB);
        pointList.add(superC);

        ArrayList<Triangle> triangles = new ArrayList<>();
        ArrayList<Triangle> badTriangles = new ArrayList<>();
        ArrayList<Edge> edgeList = new ArrayList<>();
        triangles.add(superTriangle);




        int n = pointList.size();


        for(int i=0;i<n;i++){

            Point point = pointList.get(i);
            badTriangles.clear();

            for(int j=0;j< triangles.size();j++) {
                Triangle triangle = triangles.get(j);
                Point center = triangle.CircleCenter();
                double r = triangle.a.distance(center);

                if (point.distance(center) < r) {
                    badTriangles.add(triangle);
                }

            }

            edgeList.clear();

            for(int j=0;j<badTriangles.size();j++){
                Triangle badTriangle = badTriangles.get(j);

                int counter = 0;

                //edge 1
                for(int k=0;k< badTriangles.size();k++){
                    Triangle compare = badTriangles.get(k);
                    if(k==j)
                        continue;

                    if(compare.shareEdge(badTriangle.a, badTriangle.b)) {
                        counter++;
                        break;
                    }
                }
                if(counter==0){
                    edgeList.add(new Edge(badTriangle.a, badTriangle.b));
                }


                //edge 2
                counter=0;
                for(int k=0;k< badTriangles.size();k++){
                    Triangle compare = badTriangles.get(k);
                    if(k==j)
                        continue;

                    if(compare.shareEdge(badTriangle.a, badTriangle.c)) {
                        counter++;
                        break;
                    }
                }
                if(counter==0){
                    edgeList.add(new Edge(badTriangle.a, badTriangle.c));
                }

                counter=0;
                //edge 3
                for(int k=0;k< badTriangles.size();k++){
                    Triangle compare = badTriangles.get(k);
                    if(k==j)
                        continue;

                    if(compare.shareEdge(badTriangle.b, badTriangle.c)) {
                        counter++;
                        break;
                    }
                }
                if(counter==0){
                    edgeList.add(new Edge(badTriangle.b, badTriangle.c));
                }



            }


            for(int j=0;j<badTriangles.size();j++){
                Triangle badTriangle = badTriangles.get(j);
                for(int x=0;x<triangles.size();x++){
                    if(badTriangle.compare(triangles.get(x))){
                    triangles.remove(x);
                    break;
                    }
                }

                }

            for(int j=0;j<edgeList.size();j++){
                Edge tempEdge =edgeList.get(j);
                Triangle addTriangle = new Triangle(tempEdge.a,tempEdge.b,point);
                triangles.add(addTriangle);
            }


            }




        //usuniecie wierczholkow


        badTriangles.clear();


         for (int i = 0; i < triangles.size(); i++) {
             Triangle triangle = triangles.get(i);
             if (triangle.findPoint(superA) || triangle.findPoint(superB) || triangle.findPoint(superC)){
                 badTriangles.add(triangle);
             }
         }


        for(int j=0;j<badTriangles.size();j++){
            Triangle tempTriangle = badTriangles.get(j);
            for(int x=0;x<triangles.size();x++){
                if(tempTriangle.compare(triangles.get(x))){
                    triangles.remove(x);
                    break;
                }
            }

        }

            return triangles;
    }

}
