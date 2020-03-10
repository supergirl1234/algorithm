package commm;

import java.util.ArrayList;
import java.util.LinkedList;


/*
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，{2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，{2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * */
public class Solution281 {

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {


        ArrayList<Integer> result = new ArrayList<>();//结果

        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return result;
        }
        LinkedList<Integer> queue = new LinkedList<>();//用来存储窗口中的值的下标，首位数字保存最大值的下标

        for (int i = 0; i < num.length; i++) {

            while (!queue.isEmpty() && num[i] >= num[queue.peekLast()]) {//保证首位为最大值，如果该值大于链表中后面的值，从链表的后面比较，将小于该值的数都删除
                queue.pollLast();
            }

            queue.add(i);//添加该值      如果该值小于链表中后面的值，直接将该值添加在链表中后面
            if (queue.peekFirst() < i - size + 1) {//说明该处的值过期了

                queue.pollFirst();
            }
            if (i >= size - 1) {//从长度为size处开始往result中添加链表中的首位值

                result.add(num[queue.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> result = maxInWindows(array, 3);
        System.out.println(result);

    }
}
