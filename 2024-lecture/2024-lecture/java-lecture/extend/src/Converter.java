import java.util.Scanner;

abstract class Converter {
    abstract protected double convert(double srs);
    abstract protected String getSrcString();
    abstract protected String getDestString();
    protected double ratio;


}
