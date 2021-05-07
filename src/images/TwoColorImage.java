package images;

public class TwoColorImage extends BaseImage {

    private TwoDFunc func;
    private RGB zero, one;

    public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
        super(width, height);
        this.zero = zero;
        this.one = one;
        this.func = func;
    }

    //returns the color of the 2 color image at the current coordinate
    @Override
    public RGB get(int x, int y) {
        double alpha = func.f((double) x / super.getWidth(), (double) y / super.getHeight());

        return alpha <= 0 ? zero : alpha >= 1 ? one : RGB.mix(one, zero, alpha);
    }
}
