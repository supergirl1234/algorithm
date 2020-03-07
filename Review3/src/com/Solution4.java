package com;


import java.util.ArrayList;

/*
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 *
 * 输出描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * */


/*
 *
 * 思路;双指针的方式
 * */
public class Solution4 {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (sum <= 0) {

            return lists;
        }
        int left = 1;
        int right = 2;
        int total = left + right;
        while (right < sum) {  /*因为至少包括两个数，所以不能=*/
            if (total < sum) {

                right++;
                total += right;

            } else if (total > sum) {

                total -= left;
                left++;

            } else {

                ArrayList<Integer> list = new ArrayList<>();
                for (int k = left; k <= right; k++) {

                    list.add(k);
                }

                lists.add(list);


                right++;
                total += right;

            }

        }
        return lists;

    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> result = FindContinuousSequence(9);
        System.out.println(result);
    }
}
