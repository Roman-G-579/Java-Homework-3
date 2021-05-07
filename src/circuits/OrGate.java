package circuits;

public class OrGate extends Gate {

    public OrGate(Gate[] inGates) {
        super(inGates);
    }

    //performs a boolean 'Or' operation
    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (Boolean value : inValues) {
            if (value == null) {
                throw new CircuitException("Error! Not all gates contain values");
            }
            if (value) {
                return true;
            }
        }
        return false;
    }

    //returns the gate's name
    @Override
    public String getName() {
        return "OR";
    }

    //condenses the Or gate's structure into a simplified form
    @Override
    public Gate simplify() {
        int counter = 0;
        int indexOfUnique = 0;

        //checks whether one of the inputs is a true gate
        for (int i = 0; i < inGates.length; i++) {
            if (inGates[i].simplify() instanceof TrueGate) {
                return TrueGate.instance();
            }
            if (!(inGates[i].simplify() instanceof FalseGate)) {
                counter++;
                indexOfUnique = i;
            }
        }

        //if a single inGate remains, returns that gate
        if (counter == 1) {
            return inGates[indexOfUnique].simplify();
        }

        // gets the index of the first non false gate
        int index = 0;
        while (index < inGates.length && inGates[index].simplify() instanceof FalseGate) {
            index++;
        }

        //if no gate left, returns false
        if (index == inGates.length) {
            return FalseGate.instance();
        }

        //simplifies the remaining gates
        Gate[] remainingOrGates = new Gate[inGates.length - index];

        for (int i = 0; i < remainingOrGates.length; i++, index++) {
            //skips all the remaining false gates
            if (!(inGates[index].simplify() instanceof FalseGate)) {
                remainingOrGates[i] = inGates[index].simplify();
            }
        }
        return new OrGate(remainingOrGates);
    }
}