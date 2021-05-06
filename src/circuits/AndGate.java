package circuits;

public class AndGate extends Gate {

    private Gate[] inGates;

    public AndGate(Gate[] inGates) {
        super(inGates);
        this.inGates = inGates;
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (Boolean value : inValues) {
            if (value == null) {
                throw new CircuitException("Error! Not all gates contain values");
            }
            if (!value) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "AND";
    }

    @Override
    public Gate simplify() {

        //checks whether there is a false gate
        for (Gate inGate : inGates) {
            if (inGate.simplify() instanceof FalseGate) {
                return FalseGate.instance();
            }
        }

        // skips all the true gates
        int index = 0;
        while (index < inGates.length && inGates[index].simplify() instanceof TrueGate) {
            index++;
        }

        //if only one gate remains, returns it
        if (index == inGates.length - 1) {
            return inGates[index].simplify();
        }

        // if no gate left, returns true gate
        if (index == inGates.length) {
            return TrueGate.instance();
        }

        //returns the gate in a simplified state
        Gate[] remainingAndGates = new Gate[inGates.length - index];
        for (int i = 0; i < remainingAndGates.length; i++, index++) {
            if (!(inGates[index].simplify() instanceof TrueGate)) {
                remainingAndGates[i] = inGates[index].simplify();
            }
        }
        return new AndGate(remainingAndGates);
    }
}

