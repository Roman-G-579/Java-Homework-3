package iterator;

public class Fibonacci implements MyIterator {

    private int upperBound;
    private int currentNum = 0;
    private int nextNum = 1;

    public Fibonacci(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public int next() {
        int sum = currentNum + nextNum;
        currentNum = nextNum;
        nextNum = sum;
        int previousNum = nextNum - currentNum;
        if (currentNum > upperBound) {
            return previousNum;
        }
        return currentNum;
    }

    @Override
    public boolean hasNext() {
        return nextNum <= upperBound;
    }
}
