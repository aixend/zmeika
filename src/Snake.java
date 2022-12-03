
import java.awt.*;
import java.util.ArrayList;

public class Snake {
    public static final int DIR_POUSE = 0;
    public static final int DIR_UP = 1;
    public static final int DIR_DOWN = 2;
    public static final int DIR_RIGHT = 3;
    public static final int DIR_LEFT = 4;
    private ArrayList<Point> body = new ArrayList<Point>();
    private int bodySize;
    private int direction = DIR_POUSE;

    public int getDirection() {
        return direction;
    }

    public void start(){
        paint();
        move();
        expand();


    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public ArrayList<Point> getBody() {
        return body;
    }

    Snake(int x0, int y0, int sz) {
        bodySize = sz;
        int x = x0 * sz + 2;
        int y = y0 * sz + 2;
        for (int i = 0; i < 1; i++) {
            body.add(new Point(x, y));
        }
    }

    public void paint(Graphics2D graphics2D) {
        for (Point p : body) {
            graphics2D.setColor(Color.blue);
            graphics2D.fillArc(p.x, p.y, bodySize, bodySize, 0, 360);
            graphics2D.setColor(Color.magenta);
            graphics2D.drawArc(p.x, p.y, bodySize, bodySize, 0, 360);
        }
        Point p = body.get(body.size() - 1);
        graphics2D.setColor(Color.black);
        graphics2D.fillArc(p.x + bodySize / 2 - 2, p.y + bodySize / 2 - 2, 4, 4, 0, 360);
        graphics2D.setColor(Color.white);
        graphics2D.fillArc(p.x + bodySize / 2 - 1, p.y + bodySize / 2 - 1, 2, 2, 0, 360);
    }

    public Point move() {
        Point last = body.get(body.size() - 1);
        Point pp = last;
        switch (direction) {
            case DIR_POUSE:
                break;
            case DIR_UP:
                body.remove(0);
                pp = new Point(last.x, last.y - bodySize);
                body.add(pp);
                delete();
                break;
            case DIR_DOWN:
                body.remove(0);
                pp = new Point(last.x,last.y + bodySize);
                body.add(pp);
                delete();
                break;
            case DIR_RIGHT:
                body.remove(0);
                pp = new Point(last.x + bodySize, last.y);
                body.add(pp);
                delete();
                break;
            case DIR_LEFT:
                body.remove(0);
                pp = new Point(last.x - bodySize,last.y);
                body.add(pp);
                delete();
                break;
        }
        return pp;

    }

    public int getSpeed(){
        return 410;
    }

    public void expand() {
        body.add(0,new Point(body.get(0).x,body.get(0).y));
    }

    public void delete(){
        for (int i = 0; i < body.size(); i++) {
            if (body.get(i).equals(body.get(0))){
                body.removeAll(body.subList(i,body.size()));
            }

        }
    }


}
