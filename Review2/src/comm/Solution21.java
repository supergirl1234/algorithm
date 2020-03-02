package comm;


/*
* 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
* 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
* 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
* Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
*
* */
public class Solution21 {

    /*先反转所有的字母，然后使用滑动窗口，每遇到“ ”（空格），就反转该字母*/
    public  static String ReverseSentence(String str) {

        char[] chars=str.toCharArray();
        Reverse(chars,0,chars.length-1);

        /*滑动窗口*/
        int left=0;
        int right=0;
        while(right<str.length()){
            if(chars[right]==' '){

                Reverse(chars,left,right-1);
                left=right+1;
            }

            /*针对于最后一个字符串*/
            if(right==str.length()-1){

                Reverse(chars,left,right);
                break;
            }

            right++;

        }


       return  String.valueOf(chars);
    }

    public static  void Reverse(char[] chars,int left,int right){

        int i=left;
        int j=right;
        while(i<j){
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;

            i++;
            j--;
        }

    }
    public static void main(String[] args) {

        String str="student. a am I";
        //String str=" ";
        String result=ReverseSentence(str);
        System.out.println(result);


    }
}
