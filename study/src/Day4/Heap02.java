package Day4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 23:21 2021/12/22
 * @ Description：堆结构
 * @ Modified By：
 * @Version: $
 */
public class Heap02 {

    //堆
    public static class MyHeap<T> {
        private ArrayList<T> heap;
        //
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> com) {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            comparator = com;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public int size() {
            return heapSize;
        }

        public boolean contains(T key) {
            return indexMap.containsKey(key);
        }

        public void push(T value) {
            heap.add(value);
            indexMap.put(value, heapSize);
            heapInsert(heapSize++);
        }

        public T pop() {
            T ans = heap.get(0);
            int end = heapSize - 1;
            swap(0, end);
            heap.remove(end);
            indexMap.remove(ans);
            heapIfy(0, --heapSize);
            return ans;
        }

        //当元素的某一个参与比较的属性发生变化，调用此方法重新排序堆
        public void resign(T value){
            int valueIndex = indexMap.get(value);
            //heapInsert和heapIfy两个方法只会执行一个，因为某一属性变化时，要么向上移动，要么向下移动，要么不移动
            heapInsert(valueIndex);
            heapIfy(valueIndex,heapSize);
        }

        private void heapInsert(int index) {
            //arr[index]不必arr[index]父节点大，停止
            //index = 0时也停止.
            while (comparator.compare(
                    heap.get(index),
                    heap.get((index - 1) / 2)) < 0) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }


        private void heapIfy(int i, int heapSize) {
            int left = i * 2 + 1;
            while (i < heapSize) {
                int largest = left + 1 < heapSize && (comparator.compare(
                        heap.get(left + 1),
                        heap.get(left))) > 0 ? left + 1 : left;
                largest = comparator.compare(heap.get(largest), heap.get(i)) < 0 ? i : largest;
                if (largest == i) {
                    break;
                }
                swap(largest, i);
                i = largest;
                left = i * 2 + 1;
            }
        }

        private void swap(int i, int j) {
            T o1 = heap.get(i);
            T o2 = heap.get(j);
            //堆里面互换位置
            heap.set(i, o2);
            heap.set(j, o1);
            //哈希表里互换位置
            indexMap.put(o1, j);
            indexMap.put(o2, i);
        }
    }
}
