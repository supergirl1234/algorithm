package comm;


import java.util.ArrayList;
import java.util.Comparator;

/*
*
* 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
* 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
* */
public class Solution13 {

    public  static ArrayList<String> Permutation(String str) {
        ArrayList<String> list=new ArrayList<>();

        if(str.length()==0){
          return  list;
        }
        if(str.length()==1){

            list.add(str);
            return  list;
        }
        //先递归求出除了第一个字符外，能排列出的所有字符串
        ArrayList<String> preList=Permutation(str.substring(1,str.length()));
        /*然后将第一个字符依次插入在preList中每一个字符串的各个位置*/
        for(int i=0;i<preList.size();i++){
            for(int j=0;j<=preList.get(i).length();j++){
                StringBuilder sb=new StringBuilder(preList.get(i));//这句要写在最里面，不能写在第一层循环与第二层循环之间，
                // 因为下面对sb进行了操作，要保证每次对sb进行操作的时候，都是prelist中的元素
                sb.insert(j,str.substring(0,1));
                String sttr=sb.toString();
                if(!list.contains(sttr)){//因为给出的字符串中，字符有可能重复，所以要判断一下
                    list.add(sttr);
                }
            }
        }
        /*还要给list排一下序*/
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i=0;
                while (i<o1.length()){
                    if(o1.charAt(i)!=o2.charAt(i)){
                        return o1.charAt(i)-o2.charAt(i);//从小到大排列
                    }else{
                        i++;
                    }
                }
                /*否则就完全相等*/
                return  0;
            }
        });
        return  list;
    }

    public static void main(String[] args) {

        String str="abc";
        ArrayList<String> list=Permutation(str);
        System.out.println(list);

    }
}
