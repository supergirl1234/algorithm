package commm;

import java.util.ArrayList;

/*
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。(输出结果不排序)
 *
 * 思路：快速排序
 * */
public class Solution271 {
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if(k>input.length||k<=0){
            return  list;

        }else if(k==input.length){
            for(int i=0;i<input.length;i++){

                list.add(input[i]);
            }
            return list;

        }
        int left=0;
        int right=input.length;
        int partion= QuickSort(input,left,right);//左闭右开
        while(partion+1!=k){

            if(partion+1>k){

                /*只排左半部分*/
                right=partion;
                partion=QuickSort(input,left,right);

            }else if(partion+1<k){

                /*只排右半部分*/
                left=partion+1;
                partion=QuickSort(input,left,right);
            }
        }
        for(int i=0;i<=partion;i++){
            list.add(input[i]);
        }
        return  list;

    }
    private int QuickSort(int[] input, int left, int right) {
        int part=input[right-1];
        int p=left;
        int q=right-1;
        while(p<q){

            while(p<q&&input[p]<part){
                p++;

            }
            while(p<q&&input[q]>=part){
                q--;

            }
            int temp=input[p];
            input[p]=input[q];
            input[q]=temp;

        }
        int temp=input[right-1];
        input[right-1]=input[p];
        input[p]=temp;

        return  p;

    }


    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {

        ArrayList<Integer> result=new ArrayList<>();
        if(k>input.length||input.length==0||k==0){
            return  result;

        }else if(input.length==k){
            for(int i=0;i<k;i++){

                result.add(input[i]);
            }
            return  result;

        }

        int left=0;
        int right=input.length-1;

        int part=QuickSort2(input,left,right);//左闭右闭

        while (part!=k-1){

            if(part>k-1){
                //排左半部分
                part=QuickSort2(input,left,part-1);

            }else if(part<k-1){

                //排右半部分
                part=QuickSort2(input,part+1,right);


            }
        }

        for(int i=0;i<=part;i++){
            result.add(input[i]);
        }
        return  result;

    }

    private static int QuickSort2(int[] num, int left, int right) {//左闭右闭

        int begin=left;
        int end=right;
        int swp=num[right];
        while (begin<end){
            while (begin<end&&num[begin]<swp){
                begin++;
            }
            while (begin<end&&num[end]>=swp){
                end--;
            }
            int temp=num[begin];
            num[begin]=num[end];
            num[end]=temp;

        }
        int temp=num[right];
        num[right]=num[begin];
        num[begin]=temp;

        return  begin;

    }

    public static void main(String[] args) {
        int[] array=new int[]{4,5,1,6,2,7,3,8};
        int k=4;
        ArrayList<Integer> list=GetLeastNumbers_Solution2(array,k);
        System.out.println(list);
    }
}
