package com.gyq.quiz.util;

import com.gyq.quiz.vo.Nabean;

import java.util.Comparator;

public class ComparatorUtil implements Comparator<Nabean> {
    @Override
    public int compare(Nabean o1, Nabean o2) {
        int i1=(o1.getScore()==null)?(-1):((o1.getScore()==400)?0:(o1.getScore()));
        int i2=(o2.getScore()==null)?(-1):((o2.getScore()==400)?0:(o2.getScore()));
        if(i1>i2){
            return -1;
        }else if(i1<i2){
            return 1;
        }else{
            return 0;
        }
    }
}
