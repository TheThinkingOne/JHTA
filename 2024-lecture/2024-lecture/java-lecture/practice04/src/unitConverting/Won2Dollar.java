package unitConverting;

public class Won2Dollar extends Converter {
    //private int dollorRate;
    private int rate;
    public Won2Dollar(int rate) {
        this.rate = rate;
    }

    @Override
    protected double convert(double srs) {
        return srs / rate;
    }

    @Override
    protected String getSrcString() {
        return "원";
    }

    @Override
    protected String getDestString() {
        return "달러";
    }

    @Override
    public void run() {
        super.run();
    }
}
