package circuits;

public class TrueGate extends Gate {

    private static Gate trueGateInstance = new TrueGate();

    private TrueGate() {
        super(instance().inGates);
    }

    public static Gate instance() {
        return trueGateInstance;
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (Boolean value : inValues) {
            if (value == null) {
                throw new CircuitException("Error! Not all gates contain values");
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "T";
    }

    @Override
    public Gate simplify() {
        return instance();
    }
}
