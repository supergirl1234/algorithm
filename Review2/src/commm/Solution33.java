package commm;

/*
*
* 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
* */

/*
* 思路：
第一步：相加各位的值，不算进位，二进制每位相加就相当于各位做异或操作；
第二步：计算进位值，相当于各位做与操作，再向左移一位。（在位运算中，我们用“<<”表示向左移动一位，也就是“进位”）
第三步重复上述两步， 各位相加 ，计算进位值。进位值为0，跳出循环
*
* */
public class Solution33 {

    public  static int Add(int num1,int num2) {

        int result=0;//存放结果，即^ (异或)之后的结果
        int pre=0;//存放进位，即& (与)之后的结果
       do {
            result=num1^num2;
            pre=(num1&num2)<<1;
            num1=result;
            num2=pre;

        } while (pre!=0);
        return  result;

    }
    public static void main(String[] args) {

        System.out.println(Add(3,2));
    }
}
