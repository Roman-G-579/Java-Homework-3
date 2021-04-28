package images;

public class Gradient extends BaseImage {

    private RGB start;
    private RGB end;

    public Gradient(int width, int height, RGB start, RGB end) {
        super(width, height, start);
        this.start = start;
        this.end = end;
    }

    public RGB get(int x, int y) {
        return RGB.mix(start, end, 1 - (double) (x) / getWidth());
    }
}