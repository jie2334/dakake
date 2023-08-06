package map;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

/**
 * @description: 测试类
 * @author: 22783
 * @date: 2023/7/28
 **/
public class TestMap {

    static {
        System.out.println("盛开在冬天的水仙!");
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("1", "jiejie");


        String s = map.get("1");
        System.out.println("s = " + s);

        System.out.println("map = " + map);


        //Collection<String> stringCollection = new Collection<>();

        /*hashMap测试*/
        HashMap<String, List<String>> hashMap = new HashMap<>();

        /*hashMap.put("女神","刘亦菲");
        hashMap.put("南韩女神","裴珠泫");

        hashMap.put("南韩女神","林允儿");*/

        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap = " + hashMap.size());
        /*hashMap不允许定义相同的key,必须唯一*/
        List<String> list = new ArrayList<>();

        list.add("裴珠泫");

        hashMap.put("list", list);

        System.out.println("hashMap = " + hashMap);

        Collection<List<String>> values = hashMap.values();
        Iterator<List<String>> iterator = values.iterator();


        for (String s1 : hashMap.keySet()) {
            System.out.println("s1 = " + s1);
        }


        //TODO 了解entrySet的API
        for (Map.Entry<String, List<String>> stringListEntry : hashMap.entrySet()) {
            String key = stringListEntry.getKey();
            List<String> value = stringListEntry.getValue();
            /*打印entrySet*/
            System.out.println("key = " + key);
            System.out.println("value = " + value);
            System.out.println("stringListEntry = " + stringListEntry);
        }

        //TODO Properties配置文件
        Properties properties = new Properties();
        properties.setProperty("name", "jiejie");
        String name = properties.getProperty("name");
        System.out.println("name = " + name);

        System.out.println("======================================================");


        ArrayList<String> strings = new ArrayList<>();
        strings.add("裴珠泫");
        strings.add("林允儿");
        strings.add("刘亦菲");
        strings.add("jiejie");

        strings.sort(String::compareTo);
        System.out.println("strings = " + strings);

        /*Collections.reverse(strings);
        System.out.println("strings = " + strings);*/

        /*Collections.fill(strings,s);
        System.out.println("strings = " + strings);
*/
        String max = Collections.max(strings);
        String min = Collections.min(strings);
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}
