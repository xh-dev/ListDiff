import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestListDiff {
    @Test
    public void test1(){
        List<Integer> left = Arrays.asList(1, 2, 3);
        List<Integer> right = Arrays.asList(1, 2, 3);
        DiffImpl<Integer> diff = new DiffImpl<Integer>();
        DiffResultImpl<Integer> result = (DiffResultImpl<Integer>) diff.diff(left, right);

        assertEquals(3, result.list.size());
        assertEquals(1, result.list.get(0).item());
        assertEquals(0, result.list.get(0).leftIndex().get());
        assertEquals(0, result.list.get(0).rightIndex().get());
        assertEquals(2, result.list.get(1).item());
        assertEquals(1, result.list.get(1).leftIndex().get());
        assertEquals(1, result.list.get(1).rightIndex().get());
        assertEquals(3, result.list.get(2).item());
        assertEquals(2, result.list.get(2).leftIndex().get());
        assertEquals(2, result.list.get(2).rightIndex().get());

        System.out.println(result);

    }

    @Test
    public void test2(){
        List<Integer> left = Arrays.asList(1, 2, 5);
        List<Integer> right = Arrays.asList(1, 2, 4);
        DiffImpl<Integer> diff = new DiffImpl<Integer>();
        DiffResultImpl<Integer> result = (DiffResultImpl<Integer>) diff.diff(left, right);

        assertEquals(4, result.list.size());
        assertEquals(1, result.list.get(0).item());
        assertEquals(0, result.list.get(0).leftIndex().get());
        assertEquals(0, result.list.get(0).rightIndex().get());
        assertEquals(2, result.list.get(1).item());
        assertEquals(1, result.list.get(1).leftIndex().get());
        assertEquals(1, result.list.get(1).rightIndex().get());
        assertEquals(5, result.list.get(2).item());
        assertEquals(2, result.list.get(2).leftIndex().get());
        assertTrue(result.list.get(2).rightIndex().isEmpty());
        assertEquals(4, result.list.get(3).item());
        assertTrue(result.list.get(3).leftIndex().isEmpty());
        assertEquals(2, result.list.get(3).rightIndex().get());

        System.out.println(result);

    }

    @Test
    public void test3(){
        List<Integer> left = Arrays.asList(1, 2, 5);
        List<Integer> right = Arrays.asList(1, 2, 4, 5, 6);
        DiffImpl<Integer> diff = new DiffImpl<Integer>();
        DiffResultImpl<Integer> result = (DiffResultImpl<Integer>) diff.diff(left, right);

        System.out.println(result);

        assertEquals(5, result.list.size());
        assertEquals(1, result.list.get(0).item());
        assertEquals(0, result.list.get(0).leftIndex().get());
        assertEquals(0, result.list.get(0).rightIndex().get());
        assertEquals(2, result.list.get(1).item());
        assertEquals(1, result.list.get(1).leftIndex().get());
        assertEquals(1, result.list.get(1).rightIndex().get());
        assertEquals(4, result.list.get(2).item());
        assertTrue(result.list.get(2).leftIndex().isEmpty());
        assertEquals(2, result.list.get(2).rightIndex().get());
        assertEquals(5, result.list.get(3).item());
        assertEquals(2, result.list.get(3).leftIndex().get());
        assertEquals(3, result.list.get(3).rightIndex().get());
        assertEquals(6, result.list.get(4).item());
        assertTrue(result.list.get(4).leftIndex().isEmpty());
        assertEquals(4, result.list.get(4).rightIndex().get());


    }
    @Test
    public void test4(){
        List<Integer> left = Arrays.asList(1, 2, 3);
        List<Integer> right = Arrays.asList();
        DiffImpl<Integer> diff = new DiffImpl<>();
        DiffResultImpl<Integer> result = (DiffResultImpl<Integer>) diff.diff(left, right);

        System.out.println(result);

        assertEquals(3, result.list.size());
        assertEquals(1, result.list.get(0).item());
        assertEquals(0, result.list.get(0).leftIndex().get());
        assertTrue(result.list.get(0).rightIndex().isEmpty());
        assertEquals(2, result.list.get(1).item());
        assertEquals(1, result.list.get(1).leftIndex().get());
        assertTrue(result.list.get(1).rightIndex().isEmpty());
        assertEquals(3, result.list.get(2).item());
        assertEquals(2, result.list.get(2).leftIndex().get());
        assertTrue(result.list.get(2).rightIndex().isEmpty());
    }
}
