package Day1;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 14:28 2021/12/16
 * @ Description：数组中只有一组数出现了奇数次，找到此数
 * @ Modified By：
 * @Version: $
 */
public class EORGetOddTimeNum {

    public static int EORGetOddTimeNum(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5,2,3,4,4,4,5,5};
        System.out.println(EORGetOddTimeNum(arr));
    }
}
