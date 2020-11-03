import java.util.List;

public class ProbabilityTable {
    private String name;
    private boolean b;
    private List<Probability> table;

    public ProbabilityTable(String n, boolean b, List<Probability> p){
        this.name = n;
        this.b = b;
        this.table = p;
    }

    public double getValueAtPoint(String n, boolean b){
        for(Probability p : this.table){
            if(p.getName().equals(n))
                if(b)
                    return p.getAccValue();
                else
                    return p.getUnaccValue();
        }

        return -1.0;
    }
}
