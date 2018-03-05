package com.gyq.quiz.vo;

public class NaQuestion {
    private int qid;
    private String qtext;
    private boolean over;
    private int score;

    public NaQuestion(){
        this.score=400;//初始化成400 如果没有被修改为其他的分数默认未打分
    }
    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQtext() {
        return qtext;
    }

    public void setQtext(String qtext) {
        this.qtext = qtext;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
