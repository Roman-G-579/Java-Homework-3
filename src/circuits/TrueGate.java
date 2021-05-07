package circuits;

public class TrueGate extends Gate {

    private static TrueGate trueGateInstance = null;

    private TrueGate() {
        super(new Gate[]{});
    }

    //creates an instance of the 'True' gate
    public static Gate instance() {
        if (trueGateInstance == null) {
            trueGateInstance = new TrueGate();
        }
        return trueGateInstance;
    }

    // returns true if the gate has a value and throws an exception if not
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
