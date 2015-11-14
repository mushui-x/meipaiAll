package com.gzw.mp.bean;

import java.io.Serializable;

/**
 * 用户信息
 * coder by 背离记 on 2015/11/10.
 */
public class User implements Serializable{

    private int age;
    /**用户封面
     * @return
     */
    private String avatar;
    /**
     * 被点赞次数
     */
    private int be_liked_count;
    private String birthday;
    /**
     * 用户城市码
     */
    private int city;
    /**
     * 用户省市码
     */
    private int province;
    /**
     * 用户国家码
     */
    private int country;
    /**
     * 未知，推测账号创建时间
     */
    private long created_at;
    /**
     * 用户粉丝数
     */
    private int followers_count;
    /**
     * 好友数量
     */
    private int friends_count;
    /**
     * 发送的图片数量
     */
    private int photos_count;

    /**h获取用户转发了多少视频
     * @return
     */
    public int getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    /**获取用户发送的图片的数量
     * @return
     */
    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    /**
     * 转发数量
     */
    private int reposts_count;
    /**
     * 性别 取值f和m
     */
    private String gender;
    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户昵称
     */
    private String screen_name;
    /**
     * 用户美拍网页版URL
     */
    private String url;
    /**
     * 未知，单词意思：验证
     */
    private boolean verified;
    /**
     * 用户视频总量
     */
    private int videos_count;
    /**
     * 当前登录用户是否关注该对象
     */
    private boolean following;

    /**
     * 当前登录用户是否关注该对象
     * 未关注可以添加一个【关注】按钮
     */
    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**用户封面
     * @return
     */
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 被点赞次数
     */
    public int getBe_liked_count() {
        return be_liked_count;
    }

    public void setBe_liked_count(int be_liked_count) {
        this.be_liked_count = be_liked_count;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 用户城市码
     */
    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    /**
     * 用户省市码
     */
    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    /**
     * 用户国家码
     */
    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    /**
     * 未知，推测为账号注册时间
     */
    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    /**
     * 用户粉丝数
     */
    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    /**
     * 好友数量
     */
    public int getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(int friends_count) {
        this.friends_count = friends_count;
    }

    /**
     * 性别 取值f和m
     */
    public String getGender() {
        if(gender.equals("f")){return "女"; }
        if(gender.equals("m")){return "男";}
        return "未知";
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 用户ID
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 用户昵称
     */
    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    /**
     * 用户美拍网页版URL
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 未知，单词意思：验证
     */
    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * 用户视频总量
     */
    public int getVideos_count() {
        return videos_count;
    }

    public void setVideos_count(int videos_count) {
        this.videos_count = videos_count;
    }
}
