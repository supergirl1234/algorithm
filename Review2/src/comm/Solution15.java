package comm;


/*
* HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
* 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
* 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
* 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
* 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
*
* */
public class Solution15 {


    public  static int FindGreatestSumOfSubArray1(int[] array) {
        if(array.length==0){

            return  0;
        }
        int max=array[0];//记录所有结果中连续子向量的最大和
        int num=array[0];//记录当前数处的连续子向量的最大和
        for(int i=1;i<array.length;i++){

            /*判断array[i]处，其前面的连续子向量的和对该处是有益（>=0）还是无益(<0)的
            * 如果是有益的，则对于array[i]处，其连续子向量的最大和为其前面的连续子向量的最大和+array[i],若无益，则为array[i]
            * */

            /*求出每个元素处连续子向量的最大和*/
            if(num>=0){
                num=num+array[i];
            }else{
                num=array[i];
            }
            if(num>max){
                max=num;
            }
        }
        return  max;
    }

    public  static int FindGreatestSumOfSubArray2(int[] array) {

        if(array.length==0){

            return  0;
        }
        int[] result=new int[array.length];
        result[0]=array[0];
        for(int i=1;i<array.length;i++){
            if(result[i-1]>=0){
                result[i]=result[i-1]+array[i];

            }else{
                result[i]=array[i];
            }

        }
        int max=result[0];

        for(int i=1;i<result.length;i++){
            if(result[i]>max){
                max=result[i];

            }

        }
        return  max;

    }
    public static void main(String[] args) {

        int[] array=new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray1(array));
        System.out.println(FindGreatestSumOfSubArray2(array));

    }
}
