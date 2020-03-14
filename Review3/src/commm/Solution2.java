package commm;

/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

/*
 * 思路：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身
 * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
 *
 *

我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字
 * */
public class Solution2 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int num = 0;
        if (array.length < 2) {
            return;
        }
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        for (int i = 0; i < array.length; i++) {

            num ^= array[i];
        }
        /*找出num中第几位为1，代表那两个数不同位的起始位置*/
        int index = findIndex(num);
        for (int i = 0; i < array.length; i++) {
            /*判断数组中哪些数index位为1,将数组中的数分为两组，index位为1的分为一组，index位不为1的分为一组*/
            if (isBitIndex(array[i], index)) {

                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }

        }

    }

    /*找出num中起始位置为1的下标*/
    private int findIndex(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num = num >> 1;
            index++;

        }
        return index;
    }

    /*判断一个数中index位是否为1*/
    public boolean isBitIndex(int target, int index) {
        return ((target >> index) & 1) == 1;

    }

    public static void main(String[] args) {

    }
}