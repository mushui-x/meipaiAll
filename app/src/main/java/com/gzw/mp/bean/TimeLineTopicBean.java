package com.gzw.mp.bean;

/**话题详情页
 * coder by 背离记 on 2015/11/11.
 */
public class TimeLineTopicBean {
    /**
     * 话题介绍
     */
    private String description;
    /**
     * 未知，推测话题ID
     */
    private String id;
    /**
     * 未知，推测，当前用户是否参与
     */
    private String join_type;
    /**
     * 未知，推测，视频数量
     */
    private String medias;
    /**
     * 话题名称，标题栏里写的那个
     */
    private String name;
    /**
     * 话题banner图片
     */
    private String picture;
    /**
     * 用户对象
     */
    private User user;

    /**
     * 话题介绍
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 未知，推测话题ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 未知，推测，当前用户是否参与
     */
    public String getJoin_type() {
        return join_type;
    }

    public void setJoin_type(String join_type) {
        this.join_type = join_type;
    }

    /**
     * 未知，推测，视频数量
     */
    public String getMedias() {
        return medias;
    }

    public void setMedias(String medias) {
        this.medias = medias;
    }

    /**
     * 话题名称，标题栏里写的那个
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 话题banner图片
     */
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**一个用户对象，测试数据返回了一个系统账号。推测为话题主持人
     * @return
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
