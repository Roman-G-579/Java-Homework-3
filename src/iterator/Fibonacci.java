package iterator;

    public class Fibonacci implements MyIterator {

        private int upperBound;
        private int last = 1;
        private int secondToLast = 0;

        Fibonacci(int upperBound) {
            this.upperBound = upperBound;
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
            return this.next() == upperBound;
        }


    }
