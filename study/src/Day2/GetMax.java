package Day2;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 19:38 2021/12/19
 * @ Description：递归求L..R范围上的最大值
 * @ Modified By：
 * @Version: $
 */
public class GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    //此函数所有行为最终都会变为
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        //此处必须要用mid+1，否则因为mid总是舍弃小数位，到最后无法使L == R成立，会造成栈溢出
        int rightMax = process(arr, mid + 1, R);

        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 6, 9, 6, 3, 5, 2};
        System.out.println(getMax(arr));
    }
}
