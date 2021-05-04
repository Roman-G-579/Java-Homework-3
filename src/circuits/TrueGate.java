package circuits;

public class TrueGate extends Gate {

    private static TrueGate trueGateInstance = null;

    private TrueGate() {
        super(trueGateInstance.inGates);
    }

    public static Gate instance() {
        return trueGateInstance == null ? new TrueGate() : trueGateInstance;
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
