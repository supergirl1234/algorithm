package commm;


/*
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * */
public class Solution32 {

    public static int Sum_Solution(int n) {
        int sum = n;
        /*利用短路与的性值，终止递归*/
        boolean ant = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);

        return sum;
    }

    public static void main(String[] args) {
        int result = Sum_Solution(5);
        System.out.println(result);

    }
}
