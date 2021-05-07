package iterator;

public class Fibonacci implements MyIterator {

    private int upperBound;
    private int currentNum = 0;
    private int nextNum = 1;

    public Fibonacci(int upperBound) {
        this.upperBound = upperBound;
    }

    //returns the next value in the fibonacci series
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

    //checks whether the next value in the fibonacci sequence is inside the determined bounds
    @Override
    public boolean hasNext() {
        return nextNum <= upperBound;
    }
}
