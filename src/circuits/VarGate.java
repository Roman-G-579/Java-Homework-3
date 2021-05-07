package circuits;

public class VarGate extends Gate {

    private String name;
    private Boolean val = null;

    public VarGate(String name) {
        super(new Gate[]{});
        this.name = name;
    }

    //returns the gate's name with "V" before the name
    @Override
    public String getName() {
        return "V" + name;
    }

    //returns the gate value. if it has no value, returns the gate itself
    @Override
    public Gate simplify() {
        if (val == null) {
            return this;
        }
        return val ? TrueGate.instance() : FalseGate.instance();
    }

    //returns the gate value. if it has no value, throws an exception
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