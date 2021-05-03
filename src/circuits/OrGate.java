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
        for (int i = 0; i < inGates.length; i++) {
            if (inGates[i] == TrueGate.instance()) {
                return inGates[i];
            }
            if (i == inGates.length - 2) {
                return inGates[i].simplify();
            }
        }
        return FalseGate.instance();
    }
}
