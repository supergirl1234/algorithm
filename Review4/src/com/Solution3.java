package com;

import java.util.Arrays;

/*
* LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
* 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
* “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
* LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
* 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
* LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
* 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
*
* */

/*
* 必须满足两个条件
1. 除0外没有重复的数
2. max(最大值) - min（最小值） < 5
*
* */
public class Solution3 {

    public boolean isContinuous(int [] numbers) {

        if(numbers.length!=5){
            return  false;
        }
        int[] hash=new int[14];//记录每个数字出现的次数
        int i;
        int  max=-1;//记录数组中的最大值
        int min=14;//记录数组中除0之外的最小值
        for( i=0;i<numbers.length;i++) {

            if (numbers[i] < 0 || numbers[i] > 13) {//数值范围为0-13，如果数值不在该范围内，则构不成顺子；
                return false;
            }
            hash[numbers[i]]++;
            if(numbers[i]>0&&hash[numbers[i]]>1){ //如果除零之外，其他数有重复的数，则构不成顺子
                return  false;
            }
            if(numbers[i]>max){
                max=numbers[i];
            }
            if(numbers[i]>0&&numbers[i]<min){
                min=numbers[i];
            }

        }

        if(max-min<5){
            return  true;
        }
        return  false;
    }

    public static void main(String[] args) {

    }
}
