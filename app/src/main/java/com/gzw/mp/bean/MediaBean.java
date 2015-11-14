package com.gzw.mp.bean;

/**视频信息
 * coder by 背离记 on 2015/11/10.
 */
public class MediaBean {
    /**
     * 用户对象
     */
    private User user;
    /**
     * 视频介绍
     */
    private String caption;
    /**
     * 评论数量
     */
    private int comments_count;
    /**
     * 视频封面
     */
    private String cover_pic;
    /**
     * 视频创建时间
     */
    private String created_at;
    /**
     * 视频ID
     */
    private String id;
    /**
     * 未知
     */
    private boolean is_long;
    /**
     * 未知
     */
    private boolean is_popular;
    /**
     * 点赞数量
     */
    private int likes_count;
    /**
     * 分享信息
     */
    private String qq_share_caption;
    /**
     * 视频在美拍网页版的地址，配合分享信息qq_share_caption使用
     */
    private String url;
    /**
     * 未知
     */
    private int reposts_count;
    /**
     * 视频时长
     */
    private int time;

    /**
     * 视频文件地址 *.mp4
     */
    private String video;

    /**
     * 视频文件地址 *.mp4
     */
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    /**
     * 视频时长
     */
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /**
     * 未知
     */
    public int getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    /**
     * 视频在美拍网页版的地址，配合分享信息qq_share_caption使用
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 分享信息
     */
    public String getQq_share_caption() {
        return qq_share_caption;
    }

    public void setQq_share_caption(String qq_share_caption) {
        this.qq_share_caption = qq_share_caption;
    }

    /**
     * 点赞数量
     */
    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    /**
     * 未知
     */
    public boolean is_popular() {
        return is_popular;
    }

    public void setIs_popular(boolean is_popular) {
        this.is_popular = is_popular;
    }

    /**
     * 未知
     */
    public boolean is_long() {
        return is_long;
    }

    public void setIs_long(boolean is_long) {
        this.is_long = is_long;
    }

    /**
     * 视频ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 视频创建时间
     */
    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * 视频封面
     */
    public String getCover_pic() {
        return cover_pic;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }

    /**
     * 评论数量
     */
    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    /**
     * 视频介绍
     */
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * 用户对象
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
