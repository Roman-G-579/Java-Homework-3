package circuits;

public class FalseGate extends Gate {

    private static FalseGate falseGateInstance = null;

    private FalseGate() {
        super(new Gate[]{});
    }

    public static Gate instance() {
        if (falseGateInstance == null) {
            falseGateInstance = new FalseGate();
        }
        return falseGateInstance;
    }
    // returns false if the gate has a value and throws an exception if not
    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (Boolean value : inValues) {
            if (value == null) {
                throw new CircuitException("Error! Not all gates contain values");
            }
        }
        return false;
    }

    public String getName() {
        return "F";
    }

    public Gate simplify() {
        return instance();
    }

}
