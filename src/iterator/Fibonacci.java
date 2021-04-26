package iterator;

public class Fibonacci implements MyIterator {

    private int upperBound;
    private int previousNum;
    private int nextNum;

    public Fibonacci(int upperBound) {
        this.upperBound = upperBound;
        previousNum = 0;
        nextNum = 1;
    }

    @Override
    public int next() {
        int sum = previousNum + nextNum;
        previousNum = nextNum;
        nextNum = sum;
        return previousNum;
    }

    @Override
    public boolean hasNext() {
        return nextNum <= upperBound;
    }
}
