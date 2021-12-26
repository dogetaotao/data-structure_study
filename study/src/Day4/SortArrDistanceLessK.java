package Day4;

import java.util.PriorityQueue;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 16:28 2021/12/22
 * @ Description：将一个近乎有序的数组(每个数排序过程中移动距离都不超过K,
 * K相对于数组长度很小),选择合适排序方法排序
 * @ Modified By：
 * @Version: $
 */
public class SortArrDistanceLessK {

    //时间复杂度：O(N*log K)
    public void sortArrDistanceLessK(int[] arr, int K) {
        //生成个默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length - 1, K); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();//弹出小根堆最小值赋给数组i位置
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
