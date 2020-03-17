package com;

public class Solution11 {

    /**
     * 删除输入字符串中所有在模式字符串中出现的字符
     * @param strSrc string字符串 源字符串
     * @param strPat string字符串 模式字符串
     * @return string字符串
     */
    public static String stringFilter (String strSrc, String strPat) {

       if(strPat==null||strPat.length()==0||strSrc==null||strSrc.length()==0){
           return  strSrc;
       }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strSrc.length();i++){
            char src=strSrc.charAt(i);
            int j=0;
            for(;j<strPat.length();j++){
                if(src==strPat.charAt(j)){
                    break;
                }
            }
            if(j==strPat.length()){
                sb.append(src);
            }
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        String result=stringFilter("welcome to amazing seasun","waecdf");
        System.out.println(result);
    }
}
