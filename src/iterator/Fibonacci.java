package iterator;

public class Fibonacci implements MyIterator {

    private int upperBound;
    private int last;
    private int secondToLast;

    public Fibonacci(int upperBound) {
        this.upperBound = upperBound;
        last = 1;
        secondToLast = 0;
    }

    @Override
    public int next() {
        int sum = last + secondToLast;
        secondToLast = last;
        last = sum;
        return sum;
    }

    @Override
    public boolean hasNext() {
        return next() <= upperBound;
    }
}
