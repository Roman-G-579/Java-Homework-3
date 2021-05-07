package circuits;

public abstract class Gate {

    protected Gate[] inGates;

    public Gate(Gate[] inGates) {
        this.inGates = inGates;
    }

    //performs the relevant function of the current gate
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

    //prints the gate using the proper formatting
    public String toString() {
        //if the gate has no inner gates
        if (inGates.length == 0) {
            return getName();
        }

        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append("[");

        for (Gate inGate : inGates) {
            if (inGate != null) {
                str.append(inGate);
                str.append(", ");
            }
        }
        str.delete(str.length() - 2, str.length());
        return str.append("]").toString();
    }
}