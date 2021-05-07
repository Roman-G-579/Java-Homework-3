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
        int counter = 0;
        int indexOfUnique = 0;

        //checks whether there is a false gate
        for (int i = 0; i < inGates.length; i++) {
            if (inGates[i].simplify() instanceof FalseGate) {
                return FalseGate.instance();
            }
            if (!(inGates[i].simplify() instanceof TrueGate)) {
                counter++;
                indexOfUnique = i;
            }
        }
        if (counter == 1) {
            return inGates[indexOfUnique].simplify();
        }

        // gets the index of the first non true gate
        int index = 0;
        while (index < inGates.length && inGates[index].simplify() instanceof TrueGate) {
            index++;
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

