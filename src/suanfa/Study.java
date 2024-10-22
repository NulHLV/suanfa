package suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NulLV
 * @create 2024年10月22日
 */

public class Study {
    public static void main(String[] args) {
        // 字符串中第一个重复字符 双循环遍历
//        String s1 = "weiweimao";
//        System.out.println(s1(s1));

        // 反转字符串 双指针遍历
//        String s2 = "1234";
//        System.out.println(s2(s2));

        // 反转单链表



    }

    public static char s1(String s) {
        Map<Character, Integer> retult = new HashMap<>();
        for (char c : s.toCharArray()) {
            retult.put(c, retult.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (retult.get(c) > 1) {
                return c;
            }
        }
        return 'n';
    }

    public static String s2(String s) {
        char[] charArray = s.toCharArray();
        int j = 0;
        int k = s.length() - 1;

        while (j < k) {
            char tmp = charArray[j];
            charArray[j] = charArray[k];
            charArray[k] = tmp;
            j++;
            k--;
        }
        return new String(charArray);
    }
}