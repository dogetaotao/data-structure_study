package Day3;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 10:55 2021/12/20
 * @ Description：归并排序
 * @ Modified By：
 * @Version: $
 */
public class MergeSort {

    //递归实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //要么p1越界，要么p2越界，下方两个while只会发生一个
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }


    //非递归实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;//当前有序的，左组长度
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                //L..M左组
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                //L..M左组  M+1..R右组
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            //防止数组长度很大时，mergeSize越过int最大界限
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }
}
