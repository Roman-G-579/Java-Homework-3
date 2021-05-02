package images;

public class Mix extends BinaryImageDecorator {

    double alpha;

    int imageOneWidth = base1.getWidth();
    int imageOneHeight = base1.getHeight();
    int imageTwoWidth = base2.getWidth();
    int imageTwoHeight = base2.getHeight();

    public Mix(Image base1, Image base2, double alpha) {
        super(base1, base2);
        this.alpha = alpha;
    }

    public RGB get(int x, int y) {


    }

}
