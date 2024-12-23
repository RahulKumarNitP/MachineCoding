package QuadTreeDemo;

public class Point {
    private float x;
    private float y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // getters & toString()

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}