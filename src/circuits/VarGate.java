package circuits;

public class VarGate extends Gate {

    private String name;
    private Boolean val = null;

    public VarGate(String name) {
        super();
        this.name = name;
    }

    @Override
    public String getName() {
        return "V" + name;
    }

    @Override
    public Gate simplify() {
        if (val == null) {
            return this;
        }
        return val ? TrueGate.instance() : FalseGate.instance();
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        if (val == null) {
            throw new CircuitException("Error! No value set");
        }
        return val;
    }

    public void setVal(boolean value) {
        val = value;
    }
}