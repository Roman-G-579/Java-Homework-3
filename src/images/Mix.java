package images;

public class Mix extends BinaryImageDecorator {

    private double alpha;
    private int imageOneWidth = base1.getWidth();
    private int imageOneHeight = base1.getHeight();
    private int imageTwoWidth = base2.getWidth();
    private int imageTwoHeight = base2.getHeight();

    public Mix(Image base1, Image base2, double alpha) {
        super(base1, base2);
        this.alpha = alpha;
    }

    public RGB get(int x, int y) {


    }

}
