package com.gzw.mp.bean;

/**跟MediaBean类似，多了一个转发评论。
 * coder by 背离记 on 2015/11/13.
 */
public class RepostsMediaBean {

    /**
     * 转发说明
     */
    private String caption;
    /**
     * 转发时间【1446418910需转换】
     */
    private String created_at;
    private String feed_id;
    private String id;
    /**
     * 被转发的视频对象
     */
    private MediaBean reposted_media;
    /**
     * 转发者用户对象
     */
    private User user;

    /**获取转发说明
     * @return
     */
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**获取转发时间
     * @return 【1446418910】
     */
    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**未知
     * @return
     */
    public String getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(String feed_id) {
        this.feed_id = feed_id;
    }

    /**未知，不是视频ID
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**获取转发的视频对象
     * @return MediaBean对象
     * 【Media里包含的User对象是视频作者】
     */
    public MediaBean getReposted_media() {
        return reposted_media;
    }

    public void setReposted_media(MediaBean reposted_media) {
        this.reposted_media = reposted_media;
    }

    /**视频转发者对象
     * @return
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
