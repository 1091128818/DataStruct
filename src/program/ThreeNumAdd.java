package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/9/29 13:29
 * @Description:
 */
public class ThreeNumAdd {
    List<List<Integer>> res = new ArrayList<>();
    private int [] nums;
    private int len;
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (nums==null||len<3){
            return res;
        }
        Arrays.sort(nums);
        this.len =len;
        this.nums =nums;
        threeAdd(nums);
        return  res;

    }
    private void threeAdd(int []nums){
        for (int i = 0; i <len ; i++) {
            int l =i + 1;
            int r = len -1;
            if (nums[i]>0)break;//如果i为正和大于零不用继续
            if (i>0&&nums[i]==nums[i-1])continue;//去除重叠的项类似数组和
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (sum==0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r&&nums[l]==nums[l+1])l++;//如果相等就去不计算后面的后移
                    while (l<r&&nums[r]==nums[r-1])r--;//如果相等就去不计算后面的前移
                        l++;
                        r--;
                }
                else {
                    if (sum>0)r--;//当和大于零的时候说明正数大了往小缩5->1
                    if (sum<0)l++;//当和小于零的时候说明负数小了往大-4->-1
                }
            }
        }
    }

    public static void main (String[] args) {
        int[] a={-1, 0, 1, 2, -1, -4};
        ThreeNumAdd threeNumAdd = new ThreeNumAdd();
        List<List<Integer>> t = threeNumAdd.threeSum(a);
        System.out.println(t);
    }
}
