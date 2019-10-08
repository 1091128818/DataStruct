package program;



import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/10/8 15:00
 * @Description:
 */
public class IP {

    public static void main (String[] args) {
        IP ip = new IP();
        String s ="25525511135";
        ip.restoreIpAddresses(s);
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();//保存最终的所有结果
        backtrack(s,0,new StringBuilder(),ans,0);
        System.out.println(ans);
        return ans;
    }

    /**
     *
     * @param s 传入的参数
     * @param st 开始的位置
     * @param t 临时存储的划分结果
     * @param ans 保存所有的解
     * @param c 当前加入的部分
     */
    private void backtrack(String s,int st,StringBuilder t,List<String> ans,int c){
        //如果剩余的长度大于剩下的部分都取 3 位数的长度，那么直接结束
        if ( (s.length() - st) > (3*(4 - c))){
            return;
        }
        //当前刚好到达了末尾
        if (st == s.length()){
            if (c == 4) {//加入结果
                ans.add(new String(t.substring(0,t.length()-1)));
            }
            return;
        }
        //当前超过末位，或者已经到达了 4 部分结束掉
        if (st>s.length()||c==4){
            return;
        }
        //保存的当前的解
        StringBuilder builder = new StringBuilder(t);
        //加入1
        t.append(s.charAt(st)+""+'.');
        backtrack(s,st+1,t,ans,c+1);

        if (s.charAt(st)=='0')return;
        //加入2#10 33
        if(st+1<s.length()){
            t = new StringBuilder(builder);
            t.append(s.substring(st,st+2)+""+'.');
            backtrack(s,st+2,t,ans,c+1);
        }
        //加入3 #225
        if(st+2<s.length()){
            t = new StringBuilder(builder);
            int n =Integer.parseInt(s.substring(st,st+3));
            if(n>=0&&n<=255){
            t.append(s.substring(st,st+3)+""+'.');
            backtrack(s,st+3,t,ans,c+1);
            }

        }
    }

}
