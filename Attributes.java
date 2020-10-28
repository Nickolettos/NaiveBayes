import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Attributes {
    private String name;
    private List<String> options;

    public Attributes(String n, String[] lst){
        this.name = n;
        this.options = new ArrayList<>();

        Collections.addAll(options, lst);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOptions() {
        return this.options;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "name='" + name + '\'' +
                ", options=" + options +
                '}';
    }
}
