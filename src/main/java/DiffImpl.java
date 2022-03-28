import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DiffImpl<Item> implements Diff<Item> {
    @Override
    public DiffResult<Item> diff(List<Item> left, List<Item> right) {
        Item[] leftArr = (Item[]) new Object[left.size()];
        for(int i=0; i< left.size(); i++){
            leftArr[i] = left.get(i);
        }
        Item[] rightArr = (Item[]) new Object[right.size()];
        for(int i=0; i< right.size(); i++){
            rightArr[i] = right.get(i);
        }
        return diff(leftArr, rightArr);
    }

    @Override
    public DiffResult<Item> diff(Item[] left, Item[] right) {
        int indexRight = 0;

        DiffResultImpl<Item> result = new DiffResultImpl<>();
        if(right.length == 0){
            for(int index = 0; index < left.length; index ++){
                result.add(DiffResultNodeImpl.of(left[index], Optional.of(index), Optional.empty()));
            }
            return result;
        }

        Item leftNode, rightNode;
        List<Map.Entry<Integer,Item>> unpaired = new ArrayList<>();
        for (int indexLeft = 0; indexLeft < left.length; indexLeft++) {
            leftNode = left[indexLeft];
            unpaired.clear();
            for (int tempIndex = indexRight; tempIndex < right.length; tempIndex++) {
                rightNode = right[tempIndex];
                if (leftNode.equals(rightNode)) {
                    for(Map.Entry<Integer, Item> itemEntry : unpaired){
                        result.add(DiffResultNodeImpl.of(itemEntry.getValue(), Optional.empty(), Optional.of(itemEntry.getKey())));
                    }
                    result.add(DiffResultNodeImpl.of(leftNode, Optional.of(indexLeft), Optional.of(tempIndex)));
                    indexRight = tempIndex + 1;
                    break;
                } else if (tempIndex == right.length - 1) {
                    result.add(DiffResultNodeImpl.of(leftNode, Optional.of(indexLeft), Optional.empty()));
                } else {
                    unpaired.add(Map.entry(tempIndex, rightNode));
                }
            }
        }

        for(;indexRight < right.length; indexRight ++){
            rightNode = right[indexRight];
            result.add(DiffResultNodeImpl.of(rightNode, Optional.empty(), Optional.of(indexRight)));
        }

        return result;
    }
}
