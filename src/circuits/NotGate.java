package circuits;

public class NotGate extends Gate {

    public NotGate(Gate in) {
        super(new Gate[]{in});
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return !func();
    }

    @Override
    public String getName() {
        return "NOT";
    }

    @Override
    public Gate simplify() {
        return null;
    }
}
