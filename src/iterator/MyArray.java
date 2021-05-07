package iterator;

import java.util.NoSuchElementException;

public class MyArray implements MyIterator {

    private int[] array;
    private int index = -1;

    public MyArray(int[] array) {
        this.array = array;
    }

    //prints the next element of the array
    @Override
    public int next() {
        index++;
        if (index == array.length) {
            throw new NoSuchElementException();
        }
        return array[index];
    }

    //checks whether the array is not full
    @Override
    public boolean hasNext() {
        return (index + 1) != array.length;
    }
}
