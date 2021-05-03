package circuits;

public class FalseGate extends Gate {

    private static Gate falseGateInstance = new FalseGate();

    private FalseGate() {
        super(null);
    }

    public static Gate instance() {
        return falseGateInstance;
    }

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
