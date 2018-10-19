package com.springboot005;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer>data=new ArrayList<Integer>();
    private List<Integer>mins=new ArrayList<Integer>();

    public void push(int num) throws  Exception{
        if(mins.size()==0){
            mins.add(0);
        }else{
            int value=getmin();
            if(num<value){
                mins.add(mins.size()-1);
            }
        }
    }
    public int getmin() throws Exception {
        if(data.size()==0){
            throw  new Exception("栈为空");
        }else{
            int index=mins.get(mins.size()-1);
            int min=data.get(index);
            return min;
        }
    }
    public void  pop() throws Exception {
        if(data.size()==0){
            throw new Exception("栈为空");
        }else{
            int popindex=data.size()-1;
            int minindex=mins.get(mins.size()-1);
            if(popindex==minindex){
                mins.remove(popindex);
            }
            data.remove(popindex);
        }
    }
}
