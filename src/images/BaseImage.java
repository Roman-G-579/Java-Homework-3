package images;

public abstract class BaseImage implements Image {

    private int width;
    private int height;

    public BaseImage(int width, int height) {
        this.width = width;
        this.height = height;
    }

    //returns the width
    @Override
    public int getWidth() {
        return width;
    }

    //returns the height
    @Override
    public int getHeight() {
        return height;
    }
}
