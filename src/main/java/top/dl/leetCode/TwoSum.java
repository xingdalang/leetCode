package top.dl.leetCode;

import org.junit.jupiter.api.Test;
import com.alibaba.fastjson.JSON;

public class TwoSum {
    /**
     *
     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。

     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length ;i++){
            for(int j = i+1; j < nums.length ;j++){
                if(nums[i]+nums[j]==target){
                    int[] z = new int[2];
                    z[0]=i;
                    z[1]=j;
                    return z;
                }
            }
        }
        return null;
    }

    @Test
    public void testt(){
        int[] s = {1,2,5,3,6,22,8};
        int t = 10;
        int[] ints = twoSum(s, t);
        System.out.println(JSON.toJSONString(ints));
    }

}
