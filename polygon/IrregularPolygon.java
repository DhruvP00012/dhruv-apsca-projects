package polygon;

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
        // TODO: Calculate the area.
        Double area = 0.0;
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
