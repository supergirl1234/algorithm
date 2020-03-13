package comm;



/*
* 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
* 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
* 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它
*
* */
public class Solution6 {

    public static String LeftRotateString(String str,int n) {


        int length=str.length();
        if(length==0){
            return  str;
        }
        n=n%length;
        return  str.substring(n,length)+str.substring(0,n);
    }
    //如果不使用String类自带的方法，原理：YX = (X^tY^t)^t
    public static String LeftRotateString2(String str,int n) {
        int length=str.length();
        if(length==0){
            return  str;
        }
        n=n%length;
        char[] chars=str.toCharArray();
        for(int i=0,j=n-1;i<j;i++,j--){
            swap(chars,i,j);

        }
        for(int i=n,j=length-1;i<j;i++,j--){
            swap(chars,i,j);

        }
        for(int i=0,j=length-1;i<j;i++,j--){
            swap(chars,i,j);

        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

    public static void main(String[] args) {
        String  str="abcXYZdef";
        int k=3;
        String result1=LeftRotateString(str,k);
        String result2=LeftRotateString2(str,k);
        System.out.println( result1);
        System.out.println( result2);

    }
}
