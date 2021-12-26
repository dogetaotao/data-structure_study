package Day1;

import sun.security.util.Length;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 23:50 2021/12/15
 * @ Description：二分法查找无序且相邻两项不相等的局部局部最小值
 * @ Modified By：
 * @Version: $
 */
public class BSGetLessIndex {

    public static int BSGetLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int L = 1;
        int R = arr.length - 2;
        int mid = 0;
        while (L < R) {
            mid = (L + R) / 2;
            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 34, 5, 1, 46, 21, 567, 678, 8, 78};
        System.out.println(BSGetLessIndex(arr));
    }

}
