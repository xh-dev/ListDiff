import java.util.Iterator;
import java.util.List;

public interface Diff<Item> {
    DiffResult diff(List<Item> left, List<Item> right);
    DiffResult diff(Item[] left, Item[] right);
}
