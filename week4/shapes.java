import java.util.Scanner;

abstract class Shape
{
    int dimension1;
    int dimension2;

    abstract void printArea();
}


class Rectangle extends Shape 
{
    Rectangle(int length, int breadth)
    {
        this.dimension1 = length;
        this.dimension2 = breadth;
    }
    void printArea() 
    {
        double area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}


class Triangle extends Shape
 {
    Triangle(int base, int height)
    {
        this.dimension1 = base;
        this.dimension2 = height;
    }

    void printArea()
    {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}

class Circle extends Shape
{
    Circle(int radius)
    {
        this.dimension1 = radius;
        this.dimension2 = 0; 
    }

    void printArea() 
    {
        double area = Math.PI * dimension1 * dimension1;
        System.out.println("Area of Circle: " + area);
    }
}


public class shapes 
{
    public static void main(String[] args)
 {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length and breadth of the rectangle: ");
        int length = sc.nextInt();
        int breadth = sc.nextInt();
        Shape rectangle = new Rectangle(length, breadth);
        rectangle.printArea();

        System.out.print("Enter the base and height of the triangle: ");
        int base = sc.nextInt();
        int height = sc.nextInt();
        Shape triangle = new Triangle(base, height);
        triangle.printArea();

        System.out.print("Enter the radius of the circle: ");
        int radius = sc.nextInt();
        Shape circle = new Circle(radius);
        circle.printArea();
  }
}
