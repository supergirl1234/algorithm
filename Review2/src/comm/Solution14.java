package comm;


/*
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
* 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*
* */
public class Solution14 {

    public  static int MoreThanHalfNum_Solution(int [] array) {


        int count=1;//用来记录个数
        int num=array[0];//用来记录上一次的值
        for (int i=1;i<array.length;i++){

            if(array[i]==array[i-1]){

                count++;
            }else if(count==0){


                num=array[i];
                count=1;
            }else {
                count--;
            }
        }

        /*然后还要判断一下，num的个数是否真的是大于数组的一般*/
         count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==num){

                count++;
            }

        }
        return  count>array.length/2?num:0;
    }
    public static void main(String[] args) {

        int[] array=new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
