import java.util.ArrayList;
import java.util.List;

public class Attributes {
    private String name;
    private List<String> options;

    public Attributes(String n, ArrayList<String> lst){
        this.name = n;
        this.options = lst;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOptions() {
        return this.options;
    }
}
