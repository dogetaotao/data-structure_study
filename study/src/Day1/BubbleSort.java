package Day1;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 22:43 2021/12/15
 * @ Description：冒泡排序
 * @ Modified By：
 * @Version: $
 */
public class BubbleSort {

    public static void BubbleSort(int[] arr){

        for (int i = arr.length-1; i >= 0; i--) {
            //每次冒泡都会在数组前形成一个长度为arr.length-i的由小到大排序的数组，多次冒泡可以将整个数组排列
            for (int j = arr.length-1; j > arr.length - 1 - i ; j--) {
                if(arr[j] < arr[j-1]){
                   int min = arr[j];
                   arr[j] = arr[j-1];
                   arr[j-1] = min;
                }
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            //外层循环，遍历次数
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                //内层循环，升序（如果前一个值比后一个值大，则交换）
//                //内层循环一次，获取一个最大值
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,45,667,7,88,989,9,0,0,23,43,45456,54,65,6,76,7878,1};
        BubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


}
