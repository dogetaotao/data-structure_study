package Day5;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 14:17 2021/12/23
 * @ Description：前缀树的实现
 * @ Modified By：
 * @Version: $
 */
public class TrieTree {

    //实现1
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] next;

        public Node1() {
            pass = 0;
            end = 0;
            next = new Node1[26];
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        //向前缀树添加字符串
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] str = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a'; //由字符对应走向哪条路(0--25)
                //如果这条路没有走过，则新建此方向的路
                if (node.next[path] == null) {
                    node.next[path] = new Node1();
                }
                //将node移动到下一个节点，并将pass加一
                node = node.next[path];
                node.pass++;
            }
            node.end++;

        }

        //查找一个字符串加入了几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] str = word.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.end;
        }

        //查找以某一字符串作为前缀的字符串数量
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] str = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.pass;
        }

        public void delete(String del) {
            if (search(del) != 0) {
                char[] str = del.toCharArray();
                Node1 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < str.length; i++) {
                    index = str[i] - 'a';
                    //如果删除时某个节点pass值变为0了，直接将此节点的路变为null，无需往下进行了
                    if (--node.next[index].pass == 0) {
                        node.next[index] = null;
                        return;
                    }
                    node = node.next[index];
                }
                node.end--;
            }
        }
    }

    //实现2:用哈希表，可以实现特殊字符
    public static class Node2 {
        public int pass;
        public int end;
        public HashMap<Integer, Node2> next;

        public Node2() {
            pass = 0;
            end = 0;
            next = new HashMap<>();
        }
    }

    public static class Trie2{
        private Node2 root;

        public Trie2(){
            root = new Node2();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] str = word.toCharArray();
            Node2 node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a'; //由字符对应走向哪条路(0--25)
                //如果这条路没有走过，则新建此方向的路
                if (node.next.containsKey(path)) {
                    node.next.put(path,new Node2());
                }
                //将node移动到下一个节点，并将pass加一
                node = node.next.get(path);
                node.pass++;
            }
            node.end++;        }


        //查找一个字符串加入了几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] str = word.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (node.next.containsKey(index)) {
                    return 0;
                }
                node = node.next.get(index);
            }
            return node.end;
        }

        //查找以某一字符串作为前缀的字符串数量
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] str = pre.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < str.length; i++) {
                index = str[i] - 'a';
                if (node.next.containsKey(index)) {
                    return 0;
                }
                node = node.next.get(index);
            }
            return node.pass;
        }

        public void delete(String del) {
            if (search(del) != 0) {
                char[] str = del.toCharArray();
                Node2 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < str.length; i++) {
                    index = str[i] - 'a';
                    //如果删除时某个节点pass值变为0了，直接将此节点的路变为null，无需往下进行了
                    if (--node.next.get(index).pass == 0) {
                        node.next.remove(index);
                        return;
                    }
                    node = node.next.get(index);
                }
                node.end--;
            }
        }
    }
}



















