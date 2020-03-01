package comm;


/*
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
* 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*
*思路：类似于快速排序
* */
public class Solution11 {


    public static void reOrderArray(int [] array) {
        /*类似于快速排序*/
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                continue;
            }
            int num=array[i];
            int j=i-1;
            for(;j>=0;j--){
                if(array[j]%2==0){
                    array[j+1]=array[j];
                }else{
                    break;

                }
            }
            array[j+1]=num;
        }
    }
    public static void main(String[] args) {

        int[] arary=new int[]{2,3,1,6,8,9,10,5};
        reOrderArray(arary);
        for(int i=0;i<arary.length;i++){
            System.out.print(arary[i]+" ");

        }
    }
}
