import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */
public class ListAPI {

    /**
     * 一.排序
     * 有时候需要对集合中的元素按照一定的规则进行排序，这就需要用到
     * Java中提供的对集合进行操作的工具类Collections，其中的sort方法
     */
    //例一：简单的排序
    public static void example01() {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(8);
        nums.add(5);
        nums.add(0);
        nums.add(3);
        nums.add(6);
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
    }
    //例二：复杂的对象
    public static void example02() {
        List<User> users = new ArrayList<>();
        users.add(new User(78, 26));
        users.add(new User(80, 22));
        users.add(new User(60, 22));
        users.add(new User(65, 31));
        users.add(new User(90, 27));
        Collections.sort(users);
        for (User user : users) {
            System.out.println(user.getAge()+","+user.getScore());
        }
    }

    public static void main(String[] args) {
        example01();
        example02();
    }

}
