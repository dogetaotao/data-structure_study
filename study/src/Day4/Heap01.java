package Day4;

import java.lang.instrument.ClassDefinition;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 22:23 2021/12/21
 * @ Description：大根堆
 * @ Modified By：
 * @Version: $
 */
public class Heap01 {
    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            this.limit = limit;
            heap = new int[limit];
            heapSize = 0;
        }

        private boolean isEmpty() {
            return heapSize == 0;
        }

        private boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("堆已经满了");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        private void heapInsert(int[] heap, int index) {
            //arr[index]不必arr[index]父节点大，停止
            //index = 0时也停止.
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        //返回大根堆的最大值
        public int popMax() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapIfy(heap, 0, heapSize);
            return ans;
        }

        private void heapIfy(int[] arr, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                //得出index两个子元素比较大的一个
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;
        }
    }
}
