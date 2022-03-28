import java.util.List;
import java.util.Optional;

public class DiffResultNodeImpl<Item> implements DiffResultNode<Item>{
    private Item item;
    private Optional<Integer> leftIndex;
    private Optional<Integer> rightIndex;
    @Override
    public Item item() {
        return item;
    }

    @Override
    public Optional<Integer> leftIndex() {
        return leftIndex;
    }

    @Override
    public Optional<Integer> rightIndex() {
        return rightIndex;
    }


    public static <Item> DiffResultNode<Item> of(Item item, Optional<Integer> leftIndex, Optional<Integer> rightIndex){
        DiffResultNodeImpl<Item> node = new DiffResultNodeImpl();
        node.item = item;
        node.leftIndex = leftIndex;
        node.rightIndex = rightIndex;
        return node;
    }

    @Override
    public String toString() {
        return "DiffResultNodeImpl{" +
                "item=" + item +
                ", leftIndex=" + leftIndex +
                ", rightIndex=" + rightIndex +
                '}';
    }
}
