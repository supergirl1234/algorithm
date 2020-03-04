package commm;


import java.util.ArrayList;
import java.util.Arrays;


/*
* 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
* 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
* {[2,3,4],2,6,2,5,1}，{2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
* {2,3,4,[2,6,2],5,1}，{2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
* */
public class Solution28 {

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(size<=0){

            return list;
        }
         if(size==1){

             for(int i=0;i<num.length;i++){

                 list.add(num[i]);
             }

         }else{
             for(int i=0;i<=num.length-size;i++){

                 list.add(max(Arrays.copyOfRange(num,i,i+size)));
             }

         }

        return   list;
    }

    /*找出数组中的最大值*/
    public static  int max(int[] num){
        int max=num[0];
        for(int i=1;i<num.length;i++){

            if(num[i]>max){

                max=num[i];
            }
        }
        return  max;
    }
    public static void main(String[] args) {

        int[] array=new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> list=maxInWindows(array,3);
        System.out.println(list);
    }
}
