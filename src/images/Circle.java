package images;

public class Circle extends BaseImage {

    private int width, height;
    private int centerX, centerY;
    private int radius;
    private RGB center, outside;

    public Circle(int width, int height, int centerX,
                  int centerY, int radius, RGB center, RGB outside) {
        super(width, height, RGB.WHITE);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.center = center;
        this.outside = outside;
    }

    public Circle(int size, int radius, RGB center, RGB outside) {
        super(size, size, new RGB(1, 1, 1));
        this.width = size;
        this.height = size;
        this.radius = radius;
        this.center = center;
        this.outside = outside;
    }

    public RGB get(int x, int y) {
        double distance = Math.sqrt(Math.pow((x - centerX), 2) + Math.pow((y - centerY), 2));
        return RGB.mix(center, outside, distance / radius);
    }

}
