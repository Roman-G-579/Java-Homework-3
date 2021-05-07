package images;

public abstract class BinaryImageDecorator implements Image {

    private Image base1, base2;

    public BinaryImageDecorator(Image base1, Image base2) {
        this.base1 = base1;
        this.base2 = base2;
    }

    //returns the width of the combined image
    public int getWidth() {
        return Math.max(base1.getWidth(), base2.getWidth());
    }

    //returns the height of the combined image
    public int getHeight() {
        return Math.max(base1.getHeight(), base2.getHeight());
    }
}
