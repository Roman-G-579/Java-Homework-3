package images;

public abstract class BaseImage implements Image {

    private int width;
    private int height;
    private RGB color;

    public BaseImage(int width, int height, RGB color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

}
