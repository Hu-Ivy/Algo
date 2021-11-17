package exercise;

import java.lang.reflect.Array;
import java.util.*;

public class StringEx {
    public static void main(String[] args) {
        String[] strs = {
                "time", "me", "bell"
        };
        String str1 = "3[a]2[bc]";
        String str2 = "a(bcdefghijkl(mno)p)q";
//        String res = reverseWords(str);
//        boolean res = isIsomorphic(str1, str2);

//        List<List<String>> res = groupAnagrams(strs);
        //L249
        int res = minimumLengthEncoding2(strs);
        System.out.println(res);


    }

    //L14 最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        char[] ch1 = strs[0].toCharArray();
        for (int i = 0; i < strs[0].length(); i++) {
            for (String str :
                    strs) {
                char[] temp = str.toCharArray();
                if (i > temp.length - 1 || temp[i] != ch1[i]) {
                    return res.toString();
                }
            }
            res.append(ch1[i]);
        }

        return res.toString();
    }

    //L14 最长公共前缀 优化
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;

        }
        return ans;
    }

    //L5 最强回文子串， 动态规划。
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //如果小于3就是三个字符串的，i+1，j-1就不够了。所以要单独判断。
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //49. 字母异位词分组, map的value还可以存储List呢！

    /**
     * Map<String, List<String>> map = new HashMap<String, List<String>>();
     * for (String str : strs) {
     * char[] array = str.toCharArray();
     * Arrays.sort(array);
     * String key = new String(array);
     * List<String> list = map.getOrDefault(key, new ArrayList<String>());
     * list.add(str);
     * map.put(key, list);
     * }
     * return new ArrayList<List<String>>(map.values());
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>(strs.length);
        if (strs.length == 0) {
            return res;
        }
        int index = 0;
        Map<String, Integer> map = new HashMap<>();

        for (String str :
                strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String key = String.copyValueOf(strChar);

            if (map.containsKey(key)) {
                res.get(map.get(key)).add(str);

            } else {
                map.put(key, index);
                res.add(new ArrayList<String>() {{
                    add(str);
                }});
                index++;
            }
        }
        return res;
    }

    //L151 反转字符串里的单词
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word :
                words) {
            if (!"".equals(word)) {
                sb.insert(0, word);
                sb.insert(0, " ");
            }
        }

        return sb.substring(1);
    }

    //L205 同构字符串,两个哈希表
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (maps.containsKey(chars[i]) && maps.get(chars[i]) != chart[i]) {
                return false;
            } else if (mapt.containsKey(chart[i]) && mapt.get(chart[i]) != chars[i]) {
                return false;
            } else {
                maps.put(chars[i], chart[i]);
                mapt.put(chart[i], chars[i]);
            }

        }
        return true;
    }

    //L249 以为字符串分组
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str :
                strings) {
            char[] strChar = str.toCharArray();
            int n = strChar[0] - 'a';
            for (int i = 0; i < strChar.length; i++) {
                int temp = strChar[i] - n;
                //此处可以写为    (strChar[i]-n + 26)%26 这样就不用判断是否小于97了。
                if (temp < 97) {
                    temp += 26;
                }
                strChar[i] = (char) (temp);
            }
            String key = new String(strChar);

            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    //L394 字符串解码
    private static LinkedList<String> stk = new LinkedList<String>();
    private static int ptr;

    public static String decodeString(String s) {
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);

            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }

                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);

                while (repTime-- > 0) {
                    t.append(o);
                }
                stk.addLast(t.toString());
            }

        }
        return getString(stk);
    }

    public static String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    public static String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    //L557 单词反转
    public static String reverseWords3(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word :
                words) {
            int left = 0;
            int right = word.length() - 1;
            char[] chars = word.toCharArray();
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            sb.append(chars);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    //L820 单词的压缩编码，字典树查询后缀法
    public static int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet<String>(Arrays.asList(words));
        //枚举所有单词的所有后缀，并使用set删除存在的单词
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word: good) {
            ans += word.length() + 1;
        }

        return ans;
    }
    public static int minimumLengthEncoding2(String[] words) {
        Trie trie = new Trie();
        int len = 0;

        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());

        for (String word: words) {
            len+=trie.insertR(word);
        }
        return len;
    }
    //L1190 反转每对括号间的子串

    public static String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack2.offer(stack.pop());
                }
                stack.pop();
                while (!stack2.isEmpty()) {
                    stack.push(stack2.poll());
                }
                continue;
            }
            stack.push(temp);

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char t = stack.pollLast();
            sb.append(t);
        }
        return sb.toString();
    }
}
