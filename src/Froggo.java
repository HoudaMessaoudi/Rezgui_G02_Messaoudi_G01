import java.util.Comparator;
import java.util.TreeSet;

public class Froggo implements Comparator<TreeSet> {
    @Override
    public int compare(TreeSet o1, TreeSet o2) {
        if (o1.size()!=o2.size()) return 1;
        else{
            for(Object obj:o1){
                if(!o2.contains(obj)) return 1;
            }
            return 0;
        }
    }
}
