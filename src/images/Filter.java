package images;

public class Filter implements Image {

    private Image base;
    private RGB filter;

    public Filter(Image base, RGB filter) {
        this.base = base;
        this.filter = filter;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public RGB get(int x, int y) {
        return null;
    }
}