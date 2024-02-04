package CSCI2110.Lab1;
//Citation:
//The main portion of this class is obtained from the lab document

//Rectangle class that defines a Rectangle object with xpos, ypos, width and height
public class Rectangle1
{
    //instance variables
    private double xpos, ypos, width, height;

    //Constructor
    public Rectangle1(double xpos, double ypos, double width, double height)
    {
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    //setters and getters
    public void setX(double xpos)
    {
        this.xpos=xpos;
    }
    public void setY(double ypos)
    {
        this.ypos = ypos;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getX()
    {
        return xpos;
    }

    public double getY() { return ypos; }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    //other methods: moveTo changes xpos and ypos and resize changes
    //width and height
    public void moveTo(double xpos, double ypos)
    {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public void resize(double width, double height)
    {
        this.width = width;
        this.height = height;
    }




    //contains method: returns true only if a point (px, py) is contained within this rectangle and not touching
    public boolean contains(double px, double py)
    {
        return (px > xpos) && (px < xpos + width)
                && (py > ypos) && (py < ypos + height);
    }

    //touches method: returns true if the point(px,py) touches this rectangle
    public boolean touches (double px, double py)
    {
        return ( ( (px == xpos ) || (px == xpos + width) ) && (py >= ypos) && (py <= ypos + height) )

                || ( ( (py == ypos) || (py == ypos + height) ) && (px >= xpos) && (px <= xpos + width) );

    }

    //contains method: returns true only if another rectangle r is contained within this rectangle and not touching
    //it uses the point contains method
    public boolean contains(Rectangle1 r)
    {
        return (this.contains(r.getX(), r.getY()) &&
                this.contains(r.getX() + r.getWidth(), r.getY() + r.getHeight()));
    }

    //touches method: returns true is the r rectangle touches this rectangle
    //it uses the touches method
    public boolean touches(Rectangle1 r)
    {
       return this.touches(r.getX(),r.getY())
               || this.touches(r.getX() + r.getWidth(),r.getY()+r.getHeight())
               || this.touches(r.getX() ,r.getY()+r.getHeight())
               || this.touches(r.getX() + r.getWidth(),r.getY());
    }
    //toString method
    public String toString()
    {
        return "Rectangle's top corner is: " + xpos + ", " + ypos + "\nIt's width is: " +
                width + "\nIt's height is: " + height;
    }

}
