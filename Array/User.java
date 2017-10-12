/**
 * Created by Administrator on 2017/10/12.
 */
public class User implements Comparable<User> {

    private int score;
    private int age;

    public User(int score, int age) {
        super();
        this.score = score;
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int i = this.getAge() - o.getAge();//先按照年龄排序
        if (i == 0) {
            return this.getScore() - o.getScore();//如果年龄相等再用分数进行排序
        }
        return i;
    }
}
