package Day1;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 23:32 2021/12/15
 * @ Description：查找满足大于等于某个数的最左位置
 * @ Modified By：
 * @Version: $
 */
public class BSNearLeft {

    public static int BSNearLeft(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if(arr[mid]>=value){
                index = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,76,745,6767,45123};
        int num = 456;
        int index = BSNearLeft(arr , num);
        System.out.println(index);
    }


}
