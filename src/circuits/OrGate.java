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
        int count = 0;

        for (int index = 0; index < inGates.length; index++) {
            if (inGates[index] == TrueGate.instance()) {
                return inGates[index];
            }
            while (inGates[index] == FalseGate.instance()) {
                index++;
                count++;
            }
            if (index == inGates.length - 1) {
                return inGates[index].simplify();
            }
            if (index == inGates.length) {
                return FalseGate.instance();
            }
            count++;
        }
        Gate[] remainingOrGates = new Gate[inGates.length - count];
        for (int i = 0; i < remainingOrGates.length; i++) {
            remainingOrGates[i] = inGates[count].simplify();
        }
        return new OrGate(remainingOrGates);
    }
}