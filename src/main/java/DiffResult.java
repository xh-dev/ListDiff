import java.util.List;

public interface DiffResult<Item> {
    List<DiffResultNode<Item>> leftOnly();
    List<DiffResultNode<Item>> rightOnly();
    List<DiffResultNode<Item>> common();
}
