package images;

public abstract class BinaryImageDecorator implements Image {

    Image base1, base2;

    public BinaryImageDecorator(Image base1, Image base2) {
        this.base1 = base1;
        this.base2 = base2;
    }

    @Override
    public int getWidth() {
        return Math.max(base1.getWidth(), base2.getWidth());
    }

    @Override
    public int getHeight() {
        return Math.max(base1.getHeight(), base2.getHeight());
    }
}
