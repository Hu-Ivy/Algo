package exercise;

import java.util.*;

public class String_L49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> ans = groupAnagrams(strs);

        System.out.println(ans.toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str :
                strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);

            map.put(key,list);

        }
        return new ArrayList<List<String>>(map.values());
    }
}
