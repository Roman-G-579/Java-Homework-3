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
        int count = 0;

        for (int index = 0; index < inGates.length; index++) {
            if (inGates[index] == FalseGate.instance()) {
                return inGates[index];
            }
            while (inGates[index] == TrueGate.instance()) {
                index++;
                count++;
            }
            if (index == inGates.length - 1) {
                return inGates[index];
            }
            if (index == inGates.length) {
                return TrueGate.instance();
            }
        }
        Gate[] remainingAndGates = new Gate[inGates.length - count];
        for (int i = 0; i < remainingAndGates.length; i++) {
            remainingAndGates[i] = inGates[count].simplify();
        }
        return new OrGate(remainingAndGates);
    }
}

