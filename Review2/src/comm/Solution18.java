package comm;


/*
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
* 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*
* */

import java.util.Arrays;

/*
* 思路：
* 如果该数组时某二叉搜索树的后续遍历，则数组中最后一个数是根节点，前半部分比他大的数是他的左子树，后半部分比他小的数是他的右子树
*
* 所以，如果想要判断一个数组是不是某二叉搜索树的后序遍历的结果，则就判断该数组中是否是：前半部分都比最后一个数大，后半部分都比最后一个数小
*
* 然后再递归检查前半部分和递归检查后半部分数组
* */
public class Solution18 {


    public  static boolean VerifySquenceOfBST(int [] sequence) {


        /*只有在给的数组是空的时候，返回flase*/
        if (sequence.length == 0) {
            return false;

        }

        return  isBoolean(sequence);
    }

    public static boolean isBoolean(int [] sequence){
        if (sequence.length == 0) {
            return true;

        }
        int num=sequence[sequence.length-1];
        int medium=0;
        for(int i=0;i<sequence.length;i++){

            if(sequence[i]<num){
                medium++;  //找出左子树和右子树的分界点     //这样子写可以解决只有两个数时的判断错误；如果写成  if(sequence[i]>num){medium=i;break;} 则在判断两个数时会发生错误
            }else {

                break;
            }
        }
        for(int i=medium;i<sequence.length-1;i++){

            if(sequence[i]<num){
                return  false;

            }
        }

        return  isBoolean(Arrays.copyOfRange(sequence,0,medium))&&isBoolean(Arrays.copyOfRange(sequence,medium,sequence.length-1));
    }
    public static void main(String[] args) {


        int[] array=new int[]{4,6,7,5};

        boolean result=VerifySquenceOfBST(array);
        System.out.println(result);
    }
}
