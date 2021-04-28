package images;

public abstract class ImageDecorator implements Image{

    private int width;
    private int height;

    public ImageDecorator(){

    }

    @Override
    public int getWidth(){
     return width;
    }

    @Override
    public int getHeight(){
        return height;
    }

    @Override
    public RGB get(int x, int y){
        return null;
    }

}
