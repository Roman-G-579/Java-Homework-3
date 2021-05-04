package circuits;

public abstract class Gate {

    protected Gate[] inGates;

    public Gate(Gate[] inGates) {
        this.inGates = inGates;
    }

    public boolean calc() throws CircuitException {
        boolean[] inValues = new boolean[inGates.length];
        int index = 0;

        for (Gate gate : inGates) {
            if (gate == null) {
                throw new CircuitException("Error! Not all gates contain values");
            }
            inValues[index++] = gate.calc();
        }
        return func(inValues);
    }

    protected abstract boolean func(boolean[] inValues) throws CircuitException;

    public abstract String getName();

    public abstract Gate simplify();

    public String toString() {
        ////// polymorphism
        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append("[");

        for (Gate inGate : inGates) {
            if (inGate != null) {
                str.append(inGate.getName());
                str.append(", ");
            }
        }
        if (str.charAt(str.length() - 1) == '[') {
            str.delete(str.length() - 1, str.length() - 1);
            return str.toString();
        }

        str.append("]");
        return str.toString();
    }
}