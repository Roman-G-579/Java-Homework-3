package circuits;

public class FalseGate extends Gate {

    private FalseGate() {
        super(null);
    }

    public static Gate instance() {

    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return false;
    }

    public String getName() {
        return "F";
    }

    public Gate simplify() {
        return null;
    }

}
