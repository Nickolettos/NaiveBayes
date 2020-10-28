import java.util.ArrayList;
import java.util.List;

public class MetaData {
    private List<Attributes> data;
    private Attributes classification;

    public MetaData(ArrayList<Attributes> lst1, Attributes a){
        this.data = lst1;
        this.classification = a;
    }

    public List<Attributes> getData(){
        return this.data;
    }

    public List<String> getClassifications(){
        return this.classification.getOptions();
    }
}
