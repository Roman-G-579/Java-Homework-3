package images;

public class Superpose extends BinaryImageDecorator {

    public Superpose(Image base1, Image base2) {
        super(base1, base2);
    }

    @Override
    public RGB get(int x, int y) {
        int imageOneWidth = base1.getWidth();
        int imageOneHeight = base1.getHeight();
        int imageTwoWidth = base2.getWidth();
        int imageTwoHeight = base2.getHeight();

        //if x and y exceeds both images
        if (x > imageOneWidth && y > imageOneHeight) {
            if (x > imageTwoWidth && y > imageTwoHeight) {
                return RGB.BLACK;
            }
            return base2.get(x, y);
        }
        if (x > imageTwoHeight) {
            return base1.get(x, y);
        }
        return RGB.superpose(base1.get(x, y), base2.get(x, y));
    }
}
