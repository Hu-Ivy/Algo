package huawei;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * IPv6 的地址格式如下：
 * XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX的格式，它是128位的，用":"分成8段，每段包含4个X是一个16进制数(0-9,A-F),全部大写,如下就是一个IPv6地址：
 *
 * IPv6地址一般较长，IPv6提供了一些规则来压缩地址，规则如下：
 * -规则1：丢弃前导零。
 * -规则2：如果两个或者多个块包含连续零，则省略它们，并用::替换。连续的零块只能被::替换一次，优先优化左侧的。如果地址中仍有零块，它们可以缩小到一个零。
 */
public class Ipv6 {
    public static void main(String[] args) {
        String s = "2001:0db8:0000:0000:ffff:0000:0000:0001";
        String s2 = "2001:0db8:0000:0000:0001:0000:0000:0000";
        System.out.println(compressIpv6(s2));
    }

    private static String compressIpv6(String rawIpv6) {
        //长度不是39位
        if (rawIpv6.length() != 39) {
            return "error";
        }
        //转到10进制再转到16进制会把前导0去掉。剩下的就是寻找连续0的小组。
        int[] segments = Arrays.stream(rawIpv6.split(":")).mapToInt(s -> Integer.valueOf(s, 16)).toArray();
        // 寻找连续零区间的下标
        int[] index = startIndexAndLengthOfContinuousZero(segments);
        int startIndex = index[0];
        int endIndex = index[0] + index[1] - 1;

        StringJoiner joiner = new StringJoiner(":");
        for (int i = 0; i < segments.length; i++) {
            if (segments[i] == 0 && i >= startIndex && i <= endIndex) {
                // 连续零的一部分
                if (i == 0 || i == segments.length - 1) {
                    // 如果是连续零下标是首个或者最后一个时，补空字符串
                    joiner.add("");
                }
                if (i == endIndex) {
                    // 表示连续零的压缩
                    joiner.add("");
                }
                continue;
            }
            joiner.add(Integer.toHexString(segments[i]) + "");
        }

        return joiner.toString().toUpperCase();
    }

    private static int[] startIndexAndLengthOfContinuousZero(int[] segments) {
        int maxZeroLen=0;
        int zeroStart = 0;

        int subStart = -1;
        int subLen=0;

        for (int i = 0; i < segments.length; i++) {
            if (segments[i]==0) {
                if (subStart==-1) {
                    subStart=i;
                }
                subLen++;
                //记录第一组0的长度，如果中间断掉，新的一组连续0长度除非超过之前的最大连续0，重新赋值zeroStart，否则不记录此数据。
                if (subLen>maxZeroLen) {
                    maxZeroLen = subLen;
                    zeroStart = subStart;
                }

            }else {
                subStart=-1;
                subLen=0;
            }

        }
        if (maxZeroLen > 1) {
            return new int[]{zeroStart, maxZeroLen};
        } else {
            // 仅有一个0不算连续零
            return new int[]{-1, 0};
        }
    }
}
