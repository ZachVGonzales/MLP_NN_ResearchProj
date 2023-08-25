public class Neuron {
    double numHeld = 0;
    double heldPrevSig = 0;
    double bias = 0;
    String name = "";

    public Neuron() {
        numHeld = 0;
        name = "neuron not changed";
    }

    public Neuron(double n) {
        heldPrevSig = n;
        numHeld = Calc.sigmoid(n+bias);
        name = "neuron changed";
    }

    public Neuron(double n, String word) {
        heldPrevSig = n;
        numHeld = n;
        name = word;
    }

    public double getOutput (double w) {
        double n = numHeld * w;
        return n;
    }

    public double weightHeldMult(double w) {
        return (w * numHeld);
    }

    public void setNumHeld(double n) {
        numHeld = Calc.sigmoid(n+bias);
    }
    public double getNumHeld() {
        return numHeld;
    }

    public void setBias(double b) {
        bias = b;
    }
    public double getBias() {
        return bias;
    }

    public double getHeldPrevSig() {
        return heldPrevSig;
    }
    public void setHeldPrevSig(double n) {
        heldPrevSig = n;
    }
}
