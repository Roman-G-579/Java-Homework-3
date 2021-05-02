package images;

public class Superpose extends BinaryImageDecorator {

    int imageOneWidth = base1.getWidth();
    int imageOneHeight = base1.getHeight();
    int imageTwoHeight = base2.getHeight();

    public Superpose(Image base1, Image base2) {
        super(base1, base2);
    }

    public RGB get(int x, int y) {


    }
}
