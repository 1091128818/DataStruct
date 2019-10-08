package program;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/10/1 17:14
 * @Description:
 */
public class tiaotaijie {
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int p2=1,p1=2;
        for(int i=3;i<=n;i++){
            int c=p2+p1;
            p2=p1;
            p1=c;
        }
        return p1;
    }
}
