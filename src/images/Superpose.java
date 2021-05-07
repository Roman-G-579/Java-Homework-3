package images;

public class Superpose extends BinaryImageDecorator {

    private Image base1, base2;

    public Superpose(Image base1, Image base2) {
        super(base1, base2);
        this.base1 = base1;
        this.base2 = base2;
    }

    //returns the color at the given coordinate of a 4 tone image,
    //whereas 2 colors are given by the base images,
    //one color is a superpose of the two,
    //and one color is the space between the two images
    public RGB get(int x, int y) {
        int base1Width = base1.getWidth();
        int base1Height = base1.getHeight();
        int base2Width = base2.getWidth();
        int base2Height = base2.getHeight();

        //in case the first image is wider than the second
        if (base1Width > base2Width) {
            //if the coordinate is inside both images
            if (x <= base2Width && y <= base1Height) {
                return RGB.superpose(base1.get(x, y), base2.get(x, y));
            }

            //if the coordinate is only inside the first image
            if (x > base2Width && y <= base1Height) {
                return base1.get(x, y);
            }

            //if the coordinate is only inside the second image
            if (x <= base2Width) {
                return base2.get(x, y);
            }
            return RGB.BLACK;
        }

        //in case the second image is wider than the first
        //if the coordinate is inside both images
        if (x <= base1Width && y < base2Height) {
            return RGB.superpose((base1.get(x, y)), base2.get(x, y));
        }

        //if the coordinate is only inside the first image
        if (x <= base1Width) {
            return base1.get(x, y);
        }

        //if the coordinate is only inside the second image
        if (y <= base2Height) {
            return base2.get(x, y);
        }
        return RGB.BLACK;
    }
}
