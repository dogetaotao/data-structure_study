package Day1;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 14:47 2021/12/16
 * @ Description：数组中有两组数出现了奇数次，其余数出现的都是偶数次，找到这两个数
 * @ Modified By：
 * @Version: $
 */
public class EORGetTwoOddTimeNum {

    public static int[] EORGetTwoOddTimeNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; //此时得到的eor = a^b
        }
        int R = eor & (~eor + 1);  //找到a^b最右侧的那个1
        int eor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            //将数组分成两类
            if ((arr[i] & R) != 0) {
                eor2 ^= arr[i];
            }
        }
        return new int[]{eor2, (eor ^ eor2)};
    }

    //拓展：找到一个数在内存中有几个1
    public static void PSGetAllOne(int a){
        int count = 0;
        while (a != 0){
            int rightOne = a & ((~a) + 1);
            count++;
            a ^= rightOne;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 5, 5, 3, 3, 3, 88, 88, 88, 111, 111};
        int[] result = EORGetTwoOddTimeNum(arr);
        System.out.println(result[0] + "   " + result[1]);

    }
}


