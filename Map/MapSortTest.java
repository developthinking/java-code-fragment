package test.MapTest;

import java.util.*;

/**
 * Map排序
 * Created by Administrator on 2018/1/25.
 */
public class MapSortTest {

    public static void sortTest() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("d", 2);
        map.put("c", 1);
        map.put("b", 4);
        map.put("a", 3);

        List<Map.Entry<String, Integer>> keyList = new ArrayList<>(map.entrySet());
        //对HashMap中的key进行排序
        Collections.sort(keyList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getKey()).toString().compareTo(o2.getKey().toString());
            }
        });
        //对HashMap中的key进行排序后 显示排序结果
        for (int i = 0 ; i < keyList.size(); i++) {
            String id = keyList.get(i).toString();
            System.out.println(id + " ");
        }

        System.out.println();

        //对HashMap中的value进行排序
        Collections.sort(keyList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).toString().compareTo(o2.getValue().toString());
            }
        });
        // 对HashMap中的 value 进行排序后  显示排序结果
        for (int i = 0; i < keyList.size(); i++) {
            String id = keyList.get(i).toString();
            System.out.println(id + " ");
        }
    }

    public static void main(String[] args) {
        sortTest();
    }
}
