package test.ArrTest;

/**
 * 冒泡排序
 * Created by Administrator on 2018/1/9.
 */
public class Array {

    private int[] a;
    private int length;

    public Array(int max) {
        a = new int[max];
        length = 0;
    }

    public void insert(int value) {
        a[length] = value;
        length++;
    }

    public void display() {
        for (int i=0; i<length; i++) {
            System.out.println("a["+i+"]="+a[i]);
        }
    }

    //核心代码
    public void bubbleSort() {
        for (int i=0; i<length-1; i++) {
            for (int j=0; j<length-i-1; j++) {
                if (a[j] > a[j+1]) {
                    swap(j,j+1);
                }
            }
        }
    }

    //核心代码
    public void swap(int indexa, int indexb) {
        int temp = a[indexa];
        a[indexa] = a[indexb];
        a[indexb] = temp;
    }

    public static void main(String[] args) {
        Array arr = new Array(100);
        for (int i=0; i<10; i++) {
            arr.insert(10-i);
        }
        arr.bubbleSort();
        arr.display();
    }
}
