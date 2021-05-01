package circuits;

public abstract class Gate {

    protected Gate[] inGates;

    public Gate(Gate[] inGates) {
        this.inGates = inGates;
    }

    public boolean calc(func) throws CircuitException {
        return true;
    }

    protected abstract boolean func(boolean[] inValues) throws CircuitException;

    public abstract String getName();

    public abstract Gate simplify();

    public String toString() {
        int count = 0;

        for (Gate inGate : inGates) {
            if (inGate.equals(null)) {
                count++;
            }
            if (count == inGates.length) {
                return getName();
            }
        }
        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append("[");

        for (Gate inGate : inGates) {
            if (!inGate.equals(null)) {
                str.append(inGate.toString());
                str.append(",");
            }
        }
        return str.append("]").toString();
    }
}
