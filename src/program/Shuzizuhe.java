package program;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/9/28 15:05
 * @Description:刚开始想的是用整数划分将所有结果存储然后再和原数组匹配但是后面的思路没了
 * 然后就看人家用回溯解似乎也行
 */
public class Shuzizuhe {
    //首先是创建一list的全局变量作为返回值
    List<List<Integer>> lists = new ArrayList<>();
    private int []candidates;
    private int len;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //判断是否符合组合数组的要求不符合直接返回
        int len = candidates.length;
        if (candidates == null||len==0||target<0){
            return lists;
        }
        //对要用的数组排序可以简单降低复杂度
        Arrays.sort(candidates);
      this.len =len;
      this.candidates =candidates;
      findshuzuzuhe(target,0,new Stack<>());
        return lists;
    }

    /**
     *
     * @param target 要形成组合的数
     * @param start 开始判断的位置
     * @param p 存放值
     */
    private void  findshuzuzuhe(int target, int start, Stack<Integer> p){
        if(target == 0){
            //将值存入
            lists.add(new ArrayList<>(p));

            return;
        }

        for (int i = start; i <len && target-candidates[i]>=0 ; i++) {
            if (i>start&&candidates[i]==candidates[i-1])continue;//去重的时候是现在的值和之前的值进行匹配
            p.add(candidates[i]);

            findshuzuzuhe(target-candidates[i],i+1,p);

            p.pop();

        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
       Shuzizuhe shuzizuhe = new Shuzizuhe();
        List<List<Integer>> combinationSum = shuzizuhe.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}

