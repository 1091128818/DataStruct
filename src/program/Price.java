package program;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/10/1 17:22
 * @Description:
 */
public class Price {

    public static void main (String[] args) {
        int [] a={7,1,5,3,6,4};
        Price price = new Price();
        price.maxProfit(a);
       
    }
        public int maxProfit(int[] prices) {
            int len = prices.length;
            int min = Integer.MAX_VALUE;
            int max= 0;
            for (int i = 0; i <len ; i++) {
                if (prices[i]<min){
                   min = prices[i];
                }
                else if(prices[i]-min>max){
                  max =prices[i]-min;
                }

            }
            System.out.println(max);
            return max;
        }

}
