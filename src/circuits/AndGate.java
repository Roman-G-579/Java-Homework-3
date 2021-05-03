package circuits;

public class AndGate extends Gate {

    private Gate[] inGates;

    public AndGate(Gate[] inGates) {
        super(inGates);
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (boolean value : inValues) {
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
        return null;
    }
}
