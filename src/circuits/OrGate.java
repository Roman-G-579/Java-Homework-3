package circuits;

public class OrGate extends Gate {

    public OrGate(Gate[] inGates) {
        super(inGates);
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (Boolean value : inValues) {
            if (value == null) {
                throw new CircuitException("Error! Not all gates contain values");
            }
            if (value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "OR";
    }

    @Override
    public Gate simplify() {

        //checks whether one of the inputs is a true gate
        for (Gate inGate : inGates) {
            if (inGate.simplify() instanceof TrueGate) {
                return TrueGate.instance();
            }
        }

        // skips all the false gates
        int index = 0;
        while (index < inGates.length && inGates[index].simplify() instanceof TrueGate) {
            index++;
        }

        //if only one get remains, returns it
        if (index == inGates.length - 1) {
            return inGates[index].simplify();
        }
        //if no gate left, returns false
        if (index == inGates.length) {
            return FalseGate.instance();
        }

        //simplifies the remaining gates
        Gate[] remainingOrGates = new Gate[inGates.length - index];
        for (int i = 0; i < remainingOrGates.length; i++, index++) {
            //skips all the remaining false gates
            if (!(inGates[index].simplify() instanceof FalseGate)) {
                remainingOrGates[i] = inGates[index].simplify();
            }
        }
        return new OrGate(remainingOrGates);
    }
}