package Day3;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 22:27 2021/12/20
 * @ Description：荷兰国旗问题
 * @ Modified By：
 * @Version: $
 */
public class NetherlandsFlag {

    //以int[R]为划分值i，得出<i和>i的左边界和右边界
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                //此时一定不要index++,否则无法判断交换过来的数是否应该在此位置
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
        // 1 6 3 4 4 4 4 4 5 5 2 2 3
        // 1 2 2 3 3 4 4 5 5 4 4 6 4
    }

    public static void swap(int[] arr, int i, int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }
}
