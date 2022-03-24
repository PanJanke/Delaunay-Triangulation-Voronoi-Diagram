package pl.jano;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

   public double distance(Point a){
        return Math.sqrt(    (a.y-this.y)*(a.y-this.y)  + (a.x-this.x)*(a.x-this.x)  );
   }

   public boolean equal(Point a){
        if(this.x == a.x && this.y == a.y )
            return true;
        else
            return false;
   }
}
