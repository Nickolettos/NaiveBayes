public class Probability {
    private String name;
    private double accValue;
    private double unaccValue;

    public Probability(String n, double a, double u){
        this.name = n;
        this.accValue = a;
        this.unaccValue = u;
    }

    public String getName() {
        return name;
    }

    public double getAccValue() {
        return accValue;
    }

    public double getUnaccValue() {
        return unaccValue;
    }
}
