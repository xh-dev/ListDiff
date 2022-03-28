import java.util.Optional;

public interface DiffResultNode<Item> {
    Item item();
    Optional<Integer> leftIndex();
    Optional<Integer> rightIndex();
}
