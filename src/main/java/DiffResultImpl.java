import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiffResultImpl<Item> implements DiffResult<Item>{
    protected final List<DiffResultNode> list = new ArrayList<>();

    public DiffResult<Item> add(DiffResultNode<Item> node){
        this.list.add(node);
        return this;
    }


    @Override
    public List<DiffResultNode<Item>> leftOnly() {
        return null;
    }

    @Override
    public List<DiffResultNode<Item>> rightOnly() {
        return null;
    }

    @Override
    public List<DiffResultNode<Item>> common() {
        return null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("DiffResultImpl{\n");
        sb.append(list.stream().map(it->"\t"+it.toString()).collect(Collectors.joining(",\n")));
        sb.append("\n}");
        return sb.toString();
    }
}
