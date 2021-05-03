package images;

public class Superpose extends BinaryImageDecorator {

    private int imageOneWidth = base1.getWidth();
    private int imageOneHeight = base1.getHeight();
    private int imageTwoHeight = base2.getHeight();

    public Superpose(Image base1, Image base2) {
        super(base1, base2);
    }

    public RGB get(int x, int y) {


    }
}
