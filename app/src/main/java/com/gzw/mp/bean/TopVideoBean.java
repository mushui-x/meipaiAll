package com.gzw.mp.bean;

/**
 * coder by 背离记 on 2015/11/10.
 */
public class TopVideoBean {
    /**
     * 媒体对象 内含用户对象
     */
    private MediaBean media;
    /**
     * 视频标题
     */
    private String recommend_caption;

    /**
     * 视频封面

     */
    private String recommend_cover_pic;
    /**
     * @return 视频封面链接
     */
    public String getRecommend_cover_pic() {
        return recommend_cover_pic;
    }

    public void setRecommend_cover_pic(String recommend_cover_pic) {
        this.recommend_cover_pic = recommend_cover_pic;
    }

    /**
     * @return 视频标题
     */
    public String getRecommend_caption() {
        return recommend_caption;
    }

    public void setRecommend_caption(String recommend_caption) {
        this.recommend_caption = recommend_caption;
    }

    public MediaBean getMedia() {
        return media;
    }

    public void setMedia(MediaBean media) {
        this.media = media;
    }

}
