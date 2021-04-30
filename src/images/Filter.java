package images;

public class Filter extends ImageDecorator {

    private Image base;
    private RGB filter;

    public Filter(Image base, RGB filter) {
        super(base.getWidth(), base.getHeight());
        this.base = base;
        this.filter = filter;
    }

    public RGB get(int x, int y) {
        return base.get(x, y).filter(filter);
    }
}