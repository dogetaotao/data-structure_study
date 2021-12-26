package Day1;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 23:21 2021/12/15
 * @ Description：二分查找
 * @ Modified By：
 * @Version: $
 */
public class BSExist {
    public static boolean BSExist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1); //mid = (L+R)/2
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] == num;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 324, 354, 546, 645, 767, 87657, 232398};
        int num1 = 324;
        int num2 = 333;
        boolean exist1 = BSExist(arr, num1);
        boolean exist2 = BSExist(arr, num2);
        System.out.println(exist1 + "  " + exist2);
    }
}
