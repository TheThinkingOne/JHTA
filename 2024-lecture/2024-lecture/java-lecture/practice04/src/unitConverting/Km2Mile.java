package unitConverting;

public class Km2Mile extends Converter{

    // Converter converter = new Converter();
    //

    private double mile;

    public Km2Mile(double mile){
        this.mile = mile;
    }
    @Override
    protected double convert(double srs) {
        return srs / mile;
    }

    @Override
    protected String getSrcString() {
        return "Km";
    }

    @Override
    protected String getDestString() {
        return "mile";
    }

    @Override
    public void run() {
        super.run();
    }
}
