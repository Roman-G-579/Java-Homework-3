package iterator;

public class MyArray {

    private int[] array;
    private int index = 0;

    MyArray(int[] array) {
        this.array = array;
    }

    @Override
    public int next() {
        return array[index++];
    }

    @Override
    public boolean hasNext() {
        return index != array.length;
    }
}
