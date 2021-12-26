package Day4;


/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 14:03 2021/12/22
 * @ Description：堆排序
 * @ Modified By：
 * @Version: $
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //method1:从上往下形成大根堆，空间复杂度O(1),时间复杂度O(N * log N)
        //可以实现用户一个一个给数字进行排序
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//        }

        //method2:从下往上形成大根堆，空间复杂度O(1),时间复杂度O(N)，
        // 但是这种情况下，没办法实现用户一个一个给数字的
        for (int i = arr.length - 1; i >= 0; i--) {
            heapIfy(arr, i, arr.length);
        }

        //时间复杂度O(N * log N)
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            //每次都能得到堆中最大的数
            heapIfy(arr, 0, heapSize);
            //每次减小heapSize,然后将堆中最大的数后置到heapSize之前的位置
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapIfy(int[] arr, int index, int heapSize) {
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

    private static void swap(int[] arr, int i, int j) {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 1, 0, 9};
        heapSort(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }

    private static void heapInsert(int[] heap, int index) {
        //arr[index]不必arr[index]父节点大，停止
        //index = 0时也停止.
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
