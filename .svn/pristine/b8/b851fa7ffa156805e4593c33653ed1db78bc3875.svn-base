package com.gzw.mp.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gzw.mp.bean.CommentBean;
import com.gzw.mp.bean.FindBean;
import com.gzw.mp.bean.LogInBean;
import com.gzw.mp.bean.MediaBean;
import com.gzw.mp.bean.RepostsMediaBean;
import com.gzw.mp.bean.SearchResultBean;
import com.gzw.mp.bean.SelectActivityBean;
import com.gzw.mp.bean.TimeLineBean;
import com.gzw.mp.bean.TimeLineTopicBean;
import com.gzw.mp.bean.TopUsersBean;
import com.gzw.mp.bean.TopVideoBean;
import com.gzw.mp.bean.TopicBean;
import com.gzw.mp.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * coder by 背离记 on 2015/11/10.
 */
public class JsonParser {
    public static final String TAG = "JsonParser";

    /**
     * 解析TimeLine的视频集合json数据
     *
     * @param json 要解析的数据
     * @return 数据集合，包括media和user
     */
    public static List<TimeLineBean> getTimeLine(String json) {
        List<TimeLineBean> list = new ArrayList<>();
        try {
            list = JSON.parseArray(json, TimeLineBean.class);
        } catch (Exception e) {
            LogUtil.i(TAG, e.toString());
        }
        return list;
    }

    /**解析关注流。
     * @param json
     * @return 包含了n个Media对象的List。
     */
    public static List<MediaBean> getFocus(String json){
        List<MediaBean> list =new ArrayList<>();
        list=JSON.parseArray(json,MediaBean.class);
        return list;
    }


    /** 解析精选活动列表【重要】 解析之后直接根据ID进入话题界面，解析话题数据即可
     * @param json
     * @return
     */
    public static List<SelectActivityBean> getSelectActivity(String json){
        List<SelectActivityBean> list =new ArrayList<>();
        list=JSON.parseArray(json,SelectActivityBean.class);
        return list;
    }

    /**
     * 解析排行榜用户
     *
     * @param json 要解析的数据
     * @return 排行榜用户集合
     */
    public static List<TopUsersBean> getTopUser(String json) {
        List<TopUsersBean> list = new ArrayList<>();
        try {
            JSONObject jo = JSON.parseObject(json);
            list = JSON.parseArray(jo.getJSONArray("rank_list").toString(), TopUsersBean.class);
        } catch (Exception e) {
            LogUtil.i(TAG, e.toString());
        }
        return list;
    }

    /**解析用户列表【想关注的人，搜索结果的人，关注的人】
     * @param json
     * @return
     */
    public static List<User> getUserList(String json){
        List<User> list = new ArrayList<>();
        list=JSON.parseArray(json,User.class);
        return list;
    }

    /**
     * 解析视频排行榜
     *
     * @param json 要解析的数据
     * @return 视频排行榜集合
     */
    public static List<TopVideoBean> getTopVideo(String json) {
        List<TopVideoBean> list = new ArrayList<>();
        try {
            list = JSON.parseArray(json, TopVideoBean.class);
        } catch (Exception e) {
            LogUtil.i(TAG, e.toString());
        }
        return list;
    }

    /**解析 根据输入的关键字获取的推荐搜索关键字
     * @param json 要解析的数据
     * @return 解析后的数组
     */
    public static List<String> getRelativeSearch(String json) {
        List<String> list = new ArrayList<>();
        try {
            list = JSON.parseArray(json, String.class);
        }catch (Exception e){
            LogUtil.i(TAG,e.toString());
        }
        return list;
    }

    /**解析搜索结果【重要】此方法返回一个对象，其他的方法返回的是集合。
     * 每页的搜索返回结果都包含视频和用户，第二页以后可以都只使用视频数据。
     * @param json 要解析的数据
     * @return 搜索结果对象，里面包含视频和用户两个List
     */
    public static SearchResultBean getSearchResult(String json){
        SearchResultBean bean= new SearchResultBean();
        List<MediaBean> media = new ArrayList<>();
        List<User> users=new ArrayList<>();
        JSONObject jo=JSON.parseObject(json);
        JSONArray mv = jo.getJSONArray("mv");
        JSONArray user = jo.getJSONArray("user");
        media=JSON.parseArray(mv.toString(),MediaBean.class);
        users=JSON.parseArray(user.toString(),User.class);
        bean.setMv(media);
        bean.setUser(users);
        return bean;
    }

    /**解析视频详情页数据
     * @param json
     * @return 视频详情类对象
     */
    public static MediaBean getVideoInfo(String json){
        MediaBean bean = JSON.parseObject(json,MediaBean.class);
        return bean;
    }

    /**解析评论详情
     * @param json
     * @return
     */
    public static List<CommentBean> getCommentList(String json){
        List<CommentBean> list= new ArrayList<>();
        list=JSON.parseArray(json, CommentBean.class);
        return list;
    }

    /**解析Media集合型的JSON数据【看完之后的视频推荐，用户的美拍列表】
     * @param json
     * @return
     */
    public static List<MediaBean> getMediaList(String json){
        List<MediaBean> list = new ArrayList<>();
        list=JSON.parseArray(json,MediaBean.class);
        return list;
    }

    /**解析转发的视频JSON数据集合
     * @param json
     * @return
     */
    //TODO
    public static List<RepostsMediaBean> getRepostsMediaBean(String json){
        List<RepostsMediaBean> list =new ArrayList<>();
        list =JSON.parseArray(json,RepostsMediaBean.class);
        return list;
    }

    /**解析登录成功之后返回的数据。
     * @param json
     * @return 返回一个对象，里面包含一个【access_token】和一个User对象。
     * 请存储access_token和用户id
     */
    public static LogInBean getLogInInfo(String json){
        LogInBean bean = JSON.parseObject(json, LogInBean.class);
        return bean;
    }

    /** 返回首页时间线中夹杂的话题的信息。
     * @param json
     * @return 话题名称，话题介绍，话题主持人
     */
    public static TimeLineTopicBean getTimeLineTopic(String json){
        TimeLineTopicBean bean =JSON.parseObject(json,TimeLineTopicBean.class);
        return bean;
    }

    /** 获取话题视频列表
     * @param json
     * @return
     */
    public static List<TopicBean> getTopicList(String json){
        List<TopicBean> list = JSON.parseArray(json, TopicBean.class);
        return list;
    }

    public static List<FindBean> getFindList(String json){
        return JSON.parseArray(json,FindBean.class);
    }

}
