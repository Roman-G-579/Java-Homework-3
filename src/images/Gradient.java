package images;

public class Gradient extends BaseImage {

    private RGB start;
    private RGB end;

    public Gradient(int width, int height, RGB start, RGB end) {
        super(width, height);
        this.start = start;
        this.end = end;
    }

    //returns a gradient using the x coordinate as the starting color,
    //and the y coordinate as the ending color
    public RGB get(int x, int y) {
        return RGB.mix(start, end, 1 - (double) (x) / getWidth());
    }
}