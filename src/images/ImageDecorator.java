package images;

public abstract class ImageDecorator implements Image {

    private int width;
    private int height;

    public ImageDecorator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    //returns the image's width
    @Override
    public int getWidth() {
        return width;
    }

    //returns the image's height
    @Override
    public int getHeight() {
        return height;
    }
}
