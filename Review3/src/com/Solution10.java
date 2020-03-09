package com;

/*
* 请实现一个函数用来找出字符流中第一个只出现一次的字符。
* 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
* 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
*
*
* 输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
* */
public class Solution10 {

    static int[] chars = new int[256];//存放字符，记录字符出现的次数；哈希表
    static int[] count = new int[256];//记录字符是第几次出现的；

    static int num=0;

    //Insert one char from stringstream
    public static void Insert(char ch) {

        chars[ch]++;
        count[ch]=num++;
       ;
    }

    /*思路：就是要找出字符出现次数为1，且出现最早的那个字符*/
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {

        int minNum=num;
        char result='#';
        for(int i=0;i<256;i++){

            if(chars[i]==1&&count[i]<minNum){
                result=(char) i;
                minNum=count[i];
            }
        }
        return  result;
    }

    public static void main(String[] args) {

        Insert('h');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        char result1 = FirstAppearingOnce();
        System.out.println(result1);
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('w');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('r');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('d');
        char result2 = FirstAppearingOnce();
        System.out.println(result2);
    }
}
