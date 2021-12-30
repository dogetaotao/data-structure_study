package Day8;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 17:45 2021/12/30
 * @ Description：反复对折一张纸条，假设第一次折痕为凹，打印出由上至下打印出折痕
 * @ Modified By：
 * @Version: $
 */
public class PaperFolding {
    public static void printAllFolds(int N) {
        printProcess(1,N,true);
    }
    //空间复杂度：O(N)
    //递归过程，来到了某一节点
    //i是第几层节点，N一共有多少层数，down == true 凹  down == false 凸
    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        //二叉树的中序遍历，因为此二叉树每项的value和子项都已知，不需要建出二叉树也可以实现
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, false);
    }


}
