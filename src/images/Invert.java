package images;

public class Invert extends ImageDecorator {

    private Image base;

    public Invert(Image base) {
        super(base.getWidth(), base.getHeight());
        this.base = base;
    }

    public RGB get(int x, int y) {
        return base.get(x, y).invert();
    }
}
