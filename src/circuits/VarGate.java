package circuits;

public class VarGate extends Gate {

    String name;
    Boolean val = null;

    public VarGate(String name) {
        super();
    }

    @Override
    public String getName() {
        return "V" + name;
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
