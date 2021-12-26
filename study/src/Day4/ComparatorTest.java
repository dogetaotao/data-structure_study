package Day4;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @ Author     ：chensir.
 * @ Date       ：Created in 20:37 2021/12/22
 * @ Description：比较器
 * @ Modified By：
 * @Version: $
 */
public class ComparatorTest {

    public static class Student{
        int id;
        int age;
        String name;

        public Student(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1 , Student o2){
//          if(o1.id<o2.id){
//              return -1;
//          }else if(o1.id>o2.id){
//              return 1;
//          }else{
//              return 0;
//          }
            return o1.id - o2.id;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1,1,"A");
        Student student2 = new Student(2,1,"D");
        Student student3 = new Student(3,1,"C");
        Student student4 = new Student(4,1,"B");
        Student[] students = new Student[] {student1,student3,student4,student2};
        Arrays.sort(students,new IdAscendingComparator());
    }
}


