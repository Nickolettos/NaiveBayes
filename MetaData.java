import java.util.ArrayList;
import java.util.List;

public class MetaData {
    private List<Attributes> metaData;

    public MetaData(ArrayList<Attributes> lst){
        this.metaData = lst;
    }

    public List<Attributes> getMetaData(){
        return this.metaData;
    }
}
