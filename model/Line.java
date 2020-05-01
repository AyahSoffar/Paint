/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 
 */
public class Line extends shapes implements Shape {

    //protected Point point;

    protected Map<String, Double> prop;
    //protected Color color;
    protected Color fillcolor;
    //protected Point secondPoint;

    public Line(Point point, boolean fill, Color color) {
        super(point, fill, color);
    }

    public Line() {
        prop = new HashMap<>();
        // prop.put("First Point", 0.0);
        prop.put("Second Point X", 0.0);
        prop.put("Second Point Y", 0.0);
    }

//    //public Point getSecondPoint() {
//        return secondPoint;
//    }
//
//    public void setSecondPoint(Point secondPoint) {
//        this.secondPoint = secondPoint;
//    }
//    
    @Override
    public void setPosition(Point position) {
        point = position;
    }

    @Override
    public Point getPosition() {
        return point;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        prop = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return prop;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
        fillcolor = color;
    }

    @Override
    public Color getFillColor() {
        return fillcolor;
    }

    @Override
    public void draw(Graphics canvas) {
        ((Graphics2D) canvas).setColor(getFillColor());
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawLine((int) point.getX(), (int) point.getY(), (int) prop.get("Second Point X").intValue(), (int) prop.get("Second Point Y").intValue());
    }
//(int) prop.get("Radius").intValue(),(int) prop.get("Radius").intValue()

    @Override
    public void fillDraw(Graphics canvas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean inShape(double x, double y) {
        Line2D line = new Line2D.Double(point.getX(), point.getY(), (int) prop.get("Second Point X").intValue(), (int) prop.get("Second Point Y").intValue());
        if (line.getBounds().contains(x, y)) {
            return true;
        }

        return false;
    }

    public Object clone(shapes s) {
        shapes r = new Line();
        r.setColor(s.getColor());
        Point newPoint = new Point((int) s.getPoint().getX() + 50, (int) s.getPoint().getY() + 50);
        r.setFill(s.isFill());
        r.setFillColor(s.getFillColor());
        r.setPoint(newPoint);
        Map<String, Double> newprop = new HashMap<>();
        newprop.put("Second Point X", (double) s.getProperties().get("Second Point X").intValue() + 50);
        newprop.put("Second Point Y", (double) s.getProperties().get("Second Point Y").intValue() + 50);
        r.setProperties(newprop);
        return r;

    }

}