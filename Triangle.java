package pl.jano;

public class Triangle {
    Point a;
    Point b;
    Point c;


    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double Heron() {
        return Math.abs((this.b.x - this.a.x) * (this.c.y - this.a.y) - (this.c.x - this.a.x) * (this.b.y - this.a.y)) / 2.0D;
    }


    public boolean findPoint(Point a){
        if(a.equal(this.a) || a.equal(this.b) || a.equal(this.c))
            return true;
        else
            return false;
    }

    public boolean shareEdge(Point a, Point b){
        if(a.equal(this.a) || a.equal(this.b) || a.equal(this.c)) {
            if (b.equal(this.a) || b.equal(this.b) || b.equal(this.c))
                return true;
        }
            return false;
    }

    public boolean compare(Triangle co){
        if(co.a.equal(this.a) || co.a.equal(this.b) || co.a.equal(this.c)) {
            if (co.b.equal(this.a) || co.b.equal(this.b) || co.b.equal(this.c))
                if (co.c.equal(this.a) || co.c.equal(this.b) || co.c.equal(this.c))
                return true;
        }
        return false;
    }

    public Point CircleCenter(){
        double A1 = ( Math.pow(this.a.x,2) - Math.pow(this.b.x,2) + Math.pow(this.a.y,2) - Math.pow(this.b.y,2) ) * (this.a.y-this.c.y) -  ( Math.pow(this.a.x,2) - Math.pow(this.c.x,2) + Math.pow(this.a.y,2) - Math.pow(this.c.y,2) ) *(this.a.y-this.b.y);
        double divide1 = 2*(this.a.y-this.c.y)*(this.a.x-this.b.x) - 2*(this.a.y-this.b.y)*(this.a.x-this.c.x);

        double A2 = ( Math.pow(this.a.x,2) - Math.pow(this.b.x,2) + Math.pow(this.a.y,2) - Math.pow(this.b.y,2) ) * (this.a.x-this.c.x) -  ( Math.pow(this.a.x,2) - Math.pow(this.c.x,2) + Math.pow(this.a.y,2) - Math.pow(this.c.y,2) ) *(this.a.x-this.b.x);
        double divide2 = 2*(this.a.y-this.b.y)*(this.a.x-this.c.x) - 2*(this.a.y-this.c.y)*(this.a.x-this.b.x);


        Point result = new Point(A1/divide1,A2/divide2);

        return result;

    }

}
