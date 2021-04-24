package images;

public class Superpose extends BinaryImageDecorator {

    private Image base1;
    private Image base2;
    private int width;
    private int height;

    public Superpose(Image base1, Image base2) {
        this.base1 = base1;
        this.base2 = base2;

        width = base1.getWidth() > base2.getWidth() ?
                width = base1.getWidth() : base2.getWidth();

        height = base1.getHeight() > base2.getHeight() ?
                width = base1.getHeight() : base2.getHeight();
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
