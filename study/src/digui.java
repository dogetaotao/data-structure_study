/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 15:18 2021/11/19
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class digui {
    //案例一
    public static int f(int x) {
        //处理基准情况，递归方法必须有一个基准情况，否则是毫无意义的
        if (x == 0) return 0;
            //递归求解的情形必须是递归调用总能朝着一个基准情形推进，否则会引发无穷递归，
            //例如：f(-1)会朝着负无穷无限递归,直到占满内存
        else return 2 * f(x - 1) + x * x;
    }

    //案例二
    static void printDigit(int x) {
        System.out.print(x);
    }

    static void printOut(int n) {
        //基准情况为n >= 10
        if (n >= 10) {
            printOut(n / 10);
        }
        printDigit(n % 10);
    }

    /**
     * 四条法则：
     * 1.基准情形：必须总要有某些基准情形，它无需递归就能解出
     * 2.不断推进：对于某些需要递归求解的情形，每一次递归调用都必须时装狂潮某一基准情形推进
     * 3.设计法则：假设所有的递归调用都能运行
     * 4.合法效益法则：求解同样一个实例时，切勿在不同的调用中重复性工作
     */

    public static void main(String[] args) {
        System.out.println(f(5));
        printOut(7473);
    }
}
