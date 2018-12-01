package top.dl.leetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class l3_loggest {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

     示例 1:

     输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:

     输入: "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:

     输入: "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Object,Integer> map = new HashMap();
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]!='\0'){// 非空判断
                Integer o = map.get(chars[i]);// 在重复表里拿值
                if(o==null){                  // 拿不到，则是新的字符
                    map.put(chars[i],i);      // put进去 该字符和位置
                    end = i;                  // 刷新字符串的结尾位置
                    int i1 = end - start + 1; // 设置最大字符串长度
                    if(i1>max){
                        max = i1;
                    }
                }else {                         // 有重复字符
                    if(o >= start){             // 重复字符串在目前字符串里面，进行判断处理
                        int i1 = o - start +1;  // 处理最新的最大字符串长度
                        if(i1 - max > 0) {
                            max = i1;
                        }
                        start = o+1;            // 刷新字符串，开始位置为目前字符的上次位置加1
                    }                           // 没有在目前的字符串里面，刷新最新位置
                    map.put(chars[i],i);
                }
                end = i;
            }
            if(end -start +1> max){
                max = end - start +1;
            }
        }

        return max;
    }

    @Test
    public void test(){
        int abc = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(abc);
    }
}
