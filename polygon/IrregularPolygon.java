package polygon;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon;

    public IrregularPolygon() {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    public void add(Point2D.Double aPoint) {
        myPolygon.add(aPoint);
    }
    public double perimeter() {
        if (myPolygon.size() < 2) {
            return 0.0;
        }
        double perimeter = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
            perimeter += current.distance(next);
        }
        return perimeter;
    }

    public double area() {
        if (myPolygon.size() < 3) {
            return 0.0;
        }
        double sum = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double one = myPolygon.get(i);
            Point2D.Double two = myPolygon.get((i + 1) % myPolygon.size());
            sum = sum + (one.getX() * two.getX() - one.getY() * two.getY());
        }
        return Math.abs(sum / 2.0);
    }

    public void draw()
    {
        if (myPolygon.size() < 2) {
            return;
        }
        try {
            DrawingTool pencil = new DrawingTool(new SketchPad(500, 500));
            Point2D.Double first = myPolygon.get(0);
            pencil.up();
            pencil.move(first.getX(), first.getY());
            pencil.down();
            for (int i = 1; i < myPolygon.size(); i++) {
                Point2D.Double poly = myPolygon.get(i);
                pencil.move(poly.getX(), poly.getY());
            }
            pencil.move(first.getX(), first.getY());
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
