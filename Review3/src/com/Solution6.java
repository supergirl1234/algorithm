package com;

/*
* 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
*
*
* 输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
* */

/*数值越界，即大于 2147483647，或小于 -2147483648
 *
 * 这里我们以正数的越界为例进行解释：
 * 当 value > INT_MAX/10 时，说明本轮扩大10倍后，value 必将越界（超过 INT_MAX）；
 * 当 value == INT_MAX/10 时，说明扩大10倍后，value 可能越界，也可能不越界，需要利用当前的加数 digit 来进行进一步的判断：
 * 当 digit > 7 时（以正数为例），越界；否则，当 value < INT_MAX/10 时，本轮循环必不越界（扩大10倍后也小于 INT_MAX）
 *
 * 我们设置一个变量 overValue 来表示当前的值和 INT_MAX/10 的差，因为 INT_MAX/10 为正数，
 * 所以当当前值为负数时，需要统一转化为正数，故而有：
 * overValue = isFu*value - INT_MAX/10;
 *
 * 这样，当 overValue > 0 时，越界，overValue < 0 时，不越界，而当 overValue == 0 时：
 * 正数时（isNegtive == 1），digit > 7 越界，负数时（isNegtive == -1），digit > 8 越界，通过 (isNegtive+1)/2 来将 -1、1转换为0、1，从而使有关 digit 的判断统一转化为：

 *当 (isNegtive+1)/2 + digit > 8 时，数值越界；
 * */

public class Solution6 {

    public static int StrToInt(String str) {
        if (str == null || str.length() <= 0 || str.equals("0")) {
            return 0;
        }
        int result = 0;
        int isFu = 1;//符号位
        int start = 0;
        int num=0;
        int sub=0;

        if (str.substring(0, 1).equals("+")) {
            start = 1;
        } else if (str.substring(0, 1).equals("-")) {
            isFu = -1;
            start = 1;
        }
        for (int i = start; i < str.length(); i++) {

            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
             num = str.charAt(i) - '0';

            /*判断是否越界*/
             sub = isFu * result - Integer.MAX_VALUE/10;//差值
            if (sub > 0) {//越界

                return 0;
            }
            if (sub == 0) {//可能越界，也可能不越界
                //如果是负数
                if (isFu == -1) {
                    if (num > 8) {
                        return 0;
                    }
                }
                //如果是正数
                if (isFu == 1) {
                    if (num > 7) {
                        return 0;
                    }
                }
            }

            result = result * 10 + isFu * num;

        }


        return result;
    }

    public static void main(String[] args) {

        //String str="+2178282";
        //String str="2147483648";
        String str="-2147483648";
        int result=StrToInt(str);
        System.out.println(result);
    }
}
