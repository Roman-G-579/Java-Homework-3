package images;

public class Transpose implements Image {

    private Image base;

    public Transpose(Image base) {
        this.base = base;
    }

    //returns the height of the image as its new width
    @Override
    public int getWidth() {
        return base.getHeight();
    }

    //returns the width of the image as its new height
    @Override
    public int getHeight() {
        return base.getWidth();
    }

    //returns the color in the transposed coordinate
    @Override
    public RGB get(int x, int y) {
        return base.get(y, x);
    }
}