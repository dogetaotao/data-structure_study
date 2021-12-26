package Day1;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 22:27 2021/12/15
 * @ Description：选择排序
 * @ Modified By：
 * @Version: $1.8
 */
public class SelectionSort {

    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            //默认第一个数为最小的
            int min = arr[i];
            //纪录最小值的下标
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                //遍历i+1之后的所有元素，如果发现比arr[i]小的，把min和index均设置成对应值
                if(min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            //将i与之后的最小值进行交换
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,45,667,7,88,989,9,0,0,23,43,45456,54,65,6,76,7878,1};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }


}
