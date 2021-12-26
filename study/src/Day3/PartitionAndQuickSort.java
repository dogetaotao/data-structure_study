package Day3;

import static Day3.NetherlandsFlag.netherlandsFlag;
import static Day3.NetherlandsFlag.swap;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 23:05 2021/12/20
 * @ Description：快速排序的两种方法
 * @ Modified By：
 * @Version: $
 */
public class PartitionAndQuickSort {

    //quickSort1:时间复杂度O(N^2)
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);

    }
    //quickSort2:时间复杂度O(N*log N) 额外空间复杂度O(log N)
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //利用荷兰国旗问题得到与arr[R]相等的区域边界的索引
        int[] equalArea = netherlandsFlag(arr, L, R);
        process1(arr, L, equalArea[0] - 1);
        process1(arr, equalArea[1] + 1, R);
    }

    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //和process1的区别在于，随机将数组中一个数放到R位置，这样可以避免每次均使大于R和小于R数
        // 的数量非常悬殊，避免了最差情况，这个方法时间复杂度的期望为O(N*log N),
        // 此过程为随机行为,样本相同时也不一定必定命中最差情况O(N^2),所以这种具有随机性的方法，时间复杂度为其期望
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        //利用荷兰国旗问题得到与arr[R]相等的区域边界的索引
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }
}
