package images;

public class Invert extends ImageDecorator {

    private Image base;

    public Invert(Image base) {
        super(base.getWidth(), base.getHeight());
        this.base = base;
    }

    //returns the inverted color at the given coordinate
    public RGB get(int x, int y) {
        return base.get(x, y).invert();
    }
}
