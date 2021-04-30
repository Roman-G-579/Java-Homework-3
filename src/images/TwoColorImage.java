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

    @Override
    public RGB get(int x, int y) {
        double alpha = func.f((double) x / super.getWidth(), (double) y / super.getHeight());

        if (alpha <= 0) {
            return zero;
        }
        if (alpha >= 1) {
            return one;
        }
        return RGB.mix(zero, one, alpha);
        //return alpha <= 0 ? zero : alpha >= 1 ? one : RGB.mix(zero, one, alpha);
    }
}
