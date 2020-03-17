package com;

import java.util.HashMap;

public class Solution10 {

    /**
     * 获取指定字符串中首个重复的字符，没有重复返回0
     * @param strSrc string字符串 源字符串
     * @return char字符型
     */
    public static char getFirstRepeatChar (String strSrc) {

        if(strSrc==null||strSrc.length()==0){
            return  ' ';
        }
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<strSrc.length();i++){
            if(map.containsKey(strSrc.charAt(i))){
                return strSrc.charAt(i);
            }else{
                map.put(strSrc.charAt(i),1);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        char result=getFirstRepeatChar("wuhanjaiyou");
        System.out.println(result);
    }
}
