package com.common.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Segmentation {
    private StringBuilder sb=new StringBuilder();
    private List<String> ls=new ArrayList<String>();
    private int maxwl;//���ôʵ���󳤶�
    /*
     * @param source ���ִʵľ���
     * @return �ִʺ�Ľ�����ÿո������
     */
    public String seg_str(String source){
        sb.delete(0, sb.length());
        int len;
        String word;
        maxwl=5;
        while((len=source.length())>0){
            if(maxwl>len){
                maxwl=len;
            }
            word=source.substring(len-maxwl);
            int start=len-maxwl;
            boolean find=false;
            //����߲��ϼ��֣�ֱ��ƥ��ɹ������ֵĳ���Ϊһ
            while(word.length()>1){
                if(DictionaryUtil.match(word)){
                    sb.insert(0, "\t"+word);find=true;
                    break;
                }
                ++start;
                word=source.substring(start);
            }
            if(!find){
                sb.insert(0,"\t"+ word);
            }
            source=source.substring(0, start);
        }
        return sb.toString();
    }
    /*
     * @param source ���ִʵľ���
     * @return �ִʺ�Ľ������list�洢��
     * */
    public List<String> seg_list(String source){
        ls.clear();
        int len;
        String word;
        maxwl=5;
        while((len=source.length())>0){
            if(maxwl>len){
                maxwl=len;
            }
            word=source.substring(len-maxwl);
            int start=len-maxwl;
            boolean find=false;
            while(word.length()>1){
                if(DictionaryUtil.match(word)){
                    ls.add(word);
                    find=true;
                    break;
                }
                ++start;
                word=source.substring(start);
            }
            if(!find){
                ls.add(word);
            }
            source=source.substring(0, start);
        }
        Collections.reverse(ls);
        return ls;
    }
                                                                                                                                                                                                                             
}