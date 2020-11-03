import java.util.List;

public class Data {
    private List<List<String>> data;
    private List<ProbabilityTable> probabilityTables;

    public Data(List<List<String>> lst){
        this.data = lst;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setProbabilityTables(List<ProbabilityTable> lst){
        this.probabilityTables = lst;
    }
}
