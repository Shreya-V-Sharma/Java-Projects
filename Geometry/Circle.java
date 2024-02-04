package CSCI2110.Lab1;

//circle class that defines a circle object with xpos, ypos and radius

public class Circle {

    private double xpos, ypos, radius;

    //constructor
    public Circle(double x, double y, double r)
    {
        xpos = x;
        ypos = y;
        radius = r;
    }

    //getters and setters
    public double getXpos() {return xpos;}
    public double getYpos()
    {
        return ypos;
    }
    public double getRadius()
    {
        return radius;
    }
    public void setPos(double x, double y)
    {
        xpos = x;
        ypos = y;
    }
    public void setRadius(double r)
    {
        radius = r;
    }

    //get area
    public double getArea()
    {
        return Math.PI * radius *radius;
    }

    //get circumference
    public double getCircumference()
    {
        return 2 * Math.PI * radius;
    }

    //contains and touches methods
    public boolean contains(double x, double y)
    {
        //distance between the center of the circle and the point
        double distance = Math.sqrt(((x-xpos)*(x-xpos)) + ((y-ypos)*(y-ypos)));

        //if the distance is less than radius than it is true that the point is contained in the circle
        return distance<radius;
    }
    public boolean touches(double x, double y)
    {
        double distance = Math.sqrt(((x-xpos)*(x-xpos)) + ((y-ypos)*(y-ypos)));
        //if the distance is equal to the radius than it is true that the point touches the circle
        return distance == radius;
    }
    public boolean contains(Circle c)
    {
        double distance = Math.sqrt(((c.getXpos()-xpos)*(c.getXpos()-xpos)) + ((c.getYpos()-ypos)*(c.getYpos()-ypos)));
        //if the centre of the other circle is inside this circle and the sum of the distance and other circle's radius is less than this circle's radius, then the other circle must be inside this circle
        return this.contains(c.getXpos(), c.getYpos()) && ((distance + c.getRadius())<this.radius);
    }

    public boolean touches(Circle c)
    {
        double distance = Math.sqrt(((c.getXpos()-xpos)*(c.getXpos()-xpos)) + ((c.getYpos()-ypos)*(c.getYpos()-ypos)));
        //if the sum of the distance and the other circle's radius is equal(touching from inside), or the sum of both circle's radius is equal to the distance(touching from out side) then the other circle is touching this circle
        return ((distance + c.getRadius())==this.radius)|| (distance == c.getRadius()+this.radius );
    }

    //toString method for printing
    public String toString()
    {
        return "Circle's centre is: " + xpos + ", " + ypos + "\nIt's radius is: " + radius;
    }

}
