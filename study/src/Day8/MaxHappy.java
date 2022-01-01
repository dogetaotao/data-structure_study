package Day8;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 17:29 2022/1/1
 * @ Description：公司年会，发邀请函，被邀请的人的直接下属不能参加，每个员工都有各不相同的快乐值，请问如何邀请能使快乐值总和最大
 * @ Modified By：
 * @Version: $
 */
public class MaxHappy {

    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int h) {
            happy = h;
            nexts = new ArrayList<>();
        }
    }

    public static class Info {
        public int yes;
        public int no;

        public Info(int y, int n) {
            yes = y;
            no = n;
        }
    }

    public static Info process2(Employee x) {
        if (x.nexts.isEmpty()) {
            return new Info(x.happy, 0);
        }
        int yes = x.happy;
        int no = 0;
        for (Employee next : x.nexts) {
            Info nextInfo = process2(next);
            yes += nextInfo.no;
            no += Math.max(nextInfo.yes, nextInfo.no);
        }
        return new Info(yes, no);
    }


}
