import java.util.*;
import java.util.Map.Entry;

/**
 * @description: 使用泛型，统计字符串中的字符的次数
 * @author: 22783
 * @date: 2023/7/31
 **/
public class StrTimes {

    /**
     * 统计字符串次数
     *
     * @param str
     */
    public void testTimes(String str) {//str = ahbdjkhasjdjkahsdkasd
        HashMap<Character, Integer> hashMap = new HashMap<>();

        /*getOrDefault第一次添加时，里面没有该元素，默认值0+1 = 1；之后在添加会去找之前添加过的元素的值*/
        for (char c: str.toCharArray()) {
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }

        for (Character c: hashMap.keySet()) {
            System.out.println(c+" : " +hashMap.get(c));
        }

        Set<Entry<Character, Integer>> entries = hashMap.entrySet();
        Optional<Entry<Character, Integer>> max = entries.stream().max(Entry.comparingByValue());

        System.out.println("entries = " + entries);
        System.out.println("max = " + max);
    }

    /** main测试
     * @param args
     */
    public static void main(String[] args) {
        StrTimes times = new StrTimes();
        String str = "ahbaabbbbbbddjkhasjdjkahsdkasd";

        times.testTimes(str);
    }
}
