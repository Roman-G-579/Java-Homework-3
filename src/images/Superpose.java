package images;

public class Superpose extends BinaryImageDecorator {

    int imageOneWidth = base1.getWidth();
    int imageOneHeight = base1.getHeight();
    int imageTwoWidth = base2.getWidth();
    int imageTwoHeight = base2.getHeight();

    public Superpose(Image base1, Image base2) {
        super(base1, base2);
    }

    @Override
    public RGB get(int x, int y) {

        //if x and y inside both images
        if (x <= imageOneWidth && y <= imageTwoHeight) {
            return RGB.superpose(base1.get(x, y), base2.get(x, y));
        }

        //if x and y inside the first image but not the second
        if (x <= imageOneWidth && y < imageOneHeight) {
            return base1.get(x, y);
        }

        //if x and y inside the second image but not the first
        if (x >= imageOneWidth && x < imageTwoWidth && y <= imageTwoHeight) {
            return base2.get(x, y);
        }

        return RGB.BLACK;
    }
}
