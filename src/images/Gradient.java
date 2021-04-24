package images;

public class Gradient implements Image {

    private int width;
    private int height;
    private RGB start;
    private RGB end;

    public Gradient(int width, int height, RGB start, RGB end) {
        this.width = width;
        this.height = height;
        this.start = start;
        this.end = end;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    public RGB get(int x, int y) {
        return RGB.mix(start, end, x);
    }
}