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
        Map map = new HashMap();
        int start = 0;
        int end = 0;
        int max = 0;
        boolean init = true;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]!='\0'){
                Object o = map.get(chars[i]);
                if(o==null){
                    map.put(chars[i],i);
                    end = i;
                    int i1 = end - start + 1;
                    if(i1>max){
                        max = i1;
                    }
                }else {
                    int x = (Integer) o;
                    if(x >= start){
                        int i1 = x - start +1;
                        if(i1 - max > 0){
                            max = i1;
                        }
                        start = x+1;
                    }
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
