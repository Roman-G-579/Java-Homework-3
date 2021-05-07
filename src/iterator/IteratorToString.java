package iterator;

public class IteratorToString {

    //prints the iterations using the proper formatting
    public static String toString(MyIterator it) {
        StringBuilder str = new StringBuilder();
        str.append("[");

        while (it.hasNext()) {
            str.append(it.next());
            str.append(" ");
        }
        str.delete(str.length() - 1, str.length());
        str.append("]");

        return str.toString();
    }
}