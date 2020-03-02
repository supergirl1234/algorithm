package comm;

/*
*
* 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
* 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*
* */
/*
* 思路：
* 比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，
* 如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面
*
* */
public class Solution19 {


    public static String PrintMinNumber(int [] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = 0; j < numbers.length-1-i; j++) {

                String str1= numbers[j]+""+numbers[j+1];//s1+s2
                String str2= numbers[j+1]+""+numbers[j];//s2+s1
                if(str1.compareTo(str2) > 0){ //如果s1+s2>s2+s1,则说明s1>s2,则交换

                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }

            }
        }

        StringBuffer sb=new StringBuffer();
        for(int i=0;i<numbers.length;i++){
            sb.append(numbers[i]);

        }
        return sb.toString();
    }
    public static void main(String[] args) {

        int[] array=new int[]{3,32,321};
        String result=PrintMinNumber(array);
        System.out.println(result);
    }
}
