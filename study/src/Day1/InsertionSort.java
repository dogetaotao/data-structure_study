package Day1;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 23:12 2021/12/15
 * @ Description：插入排序
 * @ Modified By：
 * @Version: $
 */
public class InsertionSort {
    
    public static void InsertionSort(int[] arr){
        //外循环遍历整个数组
        for (int i = 0; i < arr.length; i++) {
            //内循环让前i个元素形成有序数组，再在一个元素找到合适位置插入前列数组
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    int min = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = min;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,45,667,7,88,989,9,0,0,23,43,45456,54,65,6,76,7878,1};
        InsertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    
}
