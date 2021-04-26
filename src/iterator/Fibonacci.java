package iterator;

public class Fibonacci implements MyIterator {

    private int upperBound;
    private int currentNum;
    private int nextNum;
    private int previousNum;

    public Fibonacci(int upperBound) {
        this.upperBound = upperBound;
        currentNum = 0;
        previousNum = 0;
        nextNum = 1;
    }

    @Override
    public int next() {
        int sum = currentNum + nextNum;
        currentNum = nextNum;
        nextNum = sum;
        previousNum = nextNum - currentNum;
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
