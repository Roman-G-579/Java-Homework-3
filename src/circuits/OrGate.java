package circuits;

public class OrGate extends Gate {

    public OrGate(Gate[] inGates) {
        super(inGates);
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (Gate inGate : inGates) {
            if (inGate.func()) {
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
        return null;
    }
}
