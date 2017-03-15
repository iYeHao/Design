package com.common.code;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
public class DictionaryUtil {
    static Map<String,Integer> dic=new HashMap<String,Integer>(160000);
    static{
        //loadDic("dictionary/SougouLabDic_utf8.txt");
        loadDic("./resources/dic.txt");
    }
    public static void loadDic(String name){
        BufferedReader br=null;
        try {
            br=new BufferedReader(new InputStreamReader(new FileInputStream("./resources/dic.txt"),"utf-8"));
                                                                                                                                                                                                                 
            String line;
            int end;
            while((line=br.readLine())!=null){
                
                    dic.put(line, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{try {br.close();} catch (IOException e) {e.printStackTrace();}}
        System.out.println("dic load success,have been load "+dic.size()+" words!");
    }
                                                                                                                                                                                                         
    public static boolean match(String word){
        if(dic.containsKey(word))
            return true;
        return false;
    }
}