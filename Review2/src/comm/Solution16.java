package comm;


/*
* 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
* 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
* ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
* */

/*
*
* 通过分析可得：
* 个位1出现的次数为：每10次出现一个1(1、11、21...)：i/10*1+i%10<1?0:1
* 十位1出现的次数为：每100次出现10个1(10-19)：i/100*10+if(i%100<10) 0 else if(i%100>19) 10 else i%100-10+1
* 百位1出现的次数为：每1000次出现100个1(100-199)：i/1000*100+if(i%1000<100) 0 else if(i%100>199) 100 else i%100-100+1i
* 千位1出现的次数为：与上同理
*
*
* */
public class Solution16 {

    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n==0){
            return 0;
        }
        int sum=0;
        for(int i=1;i<=n;i=i*10){// i代表个位、百位、千位等
            /*i*10的结果为：10 、100、100...*/
            int div=n/(i*10);//除后得到的结果
            int more=n%(i*10);//余数

            sum+=div*i;
            if(more<i){
                sum+=0;
            }else if(more>i*2-1){
                sum+=i;
            }else {
                sum+=more-i+1;
            }

        }

        return sum;
    }
    public static void main(String[] args) {

        int num=1;
        int result=NumberOf1Between1AndN_Solution(num);
        System.out.println(result);
    }
}
