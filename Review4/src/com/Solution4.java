package com;

import java.util.ArrayList;

/*
* 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
* HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
* 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
* 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
* 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
* 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
* 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

如果没有小朋友，请返回-1
*
*
* */
public class Solution4 {

    /*使用链表的方法*/
    public static int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1) return -1;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index=0;
        while (list.size()>1){

            index=(index+m-1)%list.size();
            list.remove(index);

        }
        return  list.size() == 1 ? list.get(0) : -1;
    }

    /*使用数组的方法*/
    public static int LastRemaining_Solution2(int n, int m) {
        if(n<1||m<1) return -1;
        int[] array=new int[n];
        for (int i=0;i<n;i++){
            array[i]=i;
        }
        int num=-1;//记录数组的下标
        int count=n;
        int step=0;//记录走了几步
        while (count>0){  //跳出循环时将最后一个元素也设置为了-1
            num++;
            if(num>=n){
                num=0;
            }
            if(array[num]==-1){//说明该处已经删除掉了
                 continue;
            }
            step++;
            if(step==m){//说明该点该删除了
                array[num]=-1;
                step=0;
                count--;
            }
        }
        return  num;
    }
        public static void main(String[] args) {

        int result1=LastRemaining_Solution(5,3);
        int result2=LastRemaining_Solution2(5,3);
        System.out.println(result1);
        System.out.println(result2);
    }
}
