package access;

import sample.Sample;

public class AccessTest {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.c = 10;
        sample.setB(20);
        System.out.println(sample.getB());
    }
}
