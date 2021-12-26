package Day2;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 22:43 2021/12/19
 * @ Description：Hashmap and Treemap
 * @ Modified By：
 * @Version: $
 */
public class HashMapAndSortedMap {

    private static class Node{
        int node = 1000;
    }

    public static void main(String[] args) {
        //Hash表中值无论多大，均是按值传递，不按引用传递（除开自定义类型）
        HashMap<Node,String > map1 = new HashMap<>();
        Node node1 = new Node();
        Node node2 = node1;
        map1.put(node1 , "string");
        map1.put(node2 , "string1");
        System.out.println(map1.size()); //输出1
        //      key       value
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"我是1");
        map.put(2,"我是2");
        map.put(3,"我是3");
        map.put(4,"我是4");
        map.put(5,"我是5");
        map.put(6,"我是6");
        map.put(7,"我是7");
        map.put(8,"我是8");

        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(10));

        System.out.println(map.get(4));
        map.put(4,"I am 4");
        System.out.println(map.get(4));
        map.remove(4);
        System.out.println(map.get(4));

        //       key
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.contains("abc");
        set.remove("abc");

        //哈希表增、删、改、查，使用时时间复杂度 O(1)


        System.out.println("=======================================");


        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2,"我是2");
        treeMap.put(1,"我是1");
        treeMap.put(3,"我是3");
        treeMap.put(8,"我是8");
        treeMap.put(6,"我是6");
        treeMap.put(7,"我是7");
        treeMap.put(4,"我是4");
        treeMap.put(5,"我是5");

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastEntry());
        // <=5
        System.out.println(treeMap.floorKey(5));
        // >=5
        System.out.println(treeMap.ceilingKey(5));

        //treeMap增、删、改、查 时间复杂度 O(log N)
        //底层实现有AVL SB 红黑树  和  跳表这四种

    }
}
