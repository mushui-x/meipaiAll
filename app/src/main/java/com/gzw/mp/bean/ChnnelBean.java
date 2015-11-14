package com.gzw.mp.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * coder by 背离记 on 2015/11/10.
 */
public class ChnnelBean {
    private String chnnelTitle;
    private String chnnelId;
    public static final int HOT=0;
    public static final int FUNNY=1;
    public static final int MAKEUP=2;
    public static final int FOOD=3;
    public static final int BEAUTY=4;
    public static final int START=5;
    public static final int BABY=6;
    public static final int DANCE=7;
    public static final int MUSIC=8;
    public static final int TRAVEL=9;
    public static final int KNOWLEDGE=10;
    public static final int SB=11;
    public static final int PAT=12;
    public static final int BOYGOD=13;
    public static final int CARTOON=14;

    private static String[] chnnelTitles={"热门","搞笑","美妆时尚","美食","女神",
    "明星名人","宝宝","舞蹈","音乐","旅行","涨知识","逗比","宠物","男神","二次元"};
    private static String[] chnnelIds={"1","13","27","59","19","16",
    "18","63","62","3","5","64","6","31","193"};

    /**
     * @return获取频道列表
     */
    public static List<ChnnelBean> getChnnel(){
        List<ChnnelBean> list = new ArrayList<>();
        for(int i=0;i<chnnelTitles.length;i++){
            ChnnelBean bean = new ChnnelBean();
            bean.setChnnelTitle(chnnelTitles[i]);
            bean.setChnnelId(chnnelIds[i]);
            list.add(bean);
        }
        return list;
    }

    public String getChnnelTitle() {
        return chnnelTitle;
    }

    public void setChnnelTitle(String chnnelTitle) {
        this.chnnelTitle = chnnelTitle;
    }

    public String getChnnelId() {
        return chnnelId;
    }

    public void setChnnelId(String chnnelId) {
        this.chnnelId = chnnelId;
    }

}
