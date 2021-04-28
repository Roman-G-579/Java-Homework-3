package images;

public class Filter extends ImageDecorator {

    private Image base;
    private RGB filter;

    public Filter(Image base, RGB filter) {
        this.base = base;
        this.filter = filter;
    }

    public RGB get(){
        return null;
    }

}