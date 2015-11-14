package com.gzw.mp.utils;

/**
 * API工具类 本类只返回根据输入的参数拼装好的JSON【链接】，
 * coder by 背离记 on 2015/11/9.
 */
public class APIUtils {
    //电脑浏览器测试不加from，不加EndCache也能正常运行。
    private static String Host="https://newapi.meipai.com";
    private static String EndCache="&language=zh-Hans&client_id=1089857302&device_id=864690025974851&version=4100&channel=brandlinkside&model=MI+3W&locale=1&sig=52b427a9492722b123eadbbde8a8d8c7&sigVersion=1.0";
    /**
     * 获取短信验证码的网址
     */
    public static String getSMSUrl = "https://newapi.meipai.com/common/send_verify_code_to_phone.json";
    /**
     * 注册的网址
     */
    public static String SignUpUrl="https://newapi.meipai.com/oauth/access_token.json";
    public static String LoginUrl = SignUpUrl;
    private static String TAG="API";
    /**
     * 【我】界面最下方的图片广告链接，webView打开。
     */
    public static String SettingADLink="http://xiuxiu.mobile.meitudata.com/tuiguang/android/meipai/1446544192698/";

    /** 拼接时间线话题链接
     * @param scheme 从TimeLine中获取的话题信息
     * @return 拼接好的话题链接
     */
    public static String getTimeLineTopicLink(String scheme){
        String[] m = scheme.split("&");
        String id = m[1];
        String[] n=m[2].split("=");
        String name=n[1];
        String link = Host+"/channels/show.json?"+id+name;
        return link;
    }

    /** 根据ID获取话题中最新和最热视频流链接
     * @param topicId 话题ID
     * @param ConfigType Utils/Config中的配置数据
     * @return
     */
    public static String getTimeLineTopicLinkByType(String topicId,String ConfigType,int page){
        return Host+"/medias/topics_timeline.json?id="+topicId+"&type=2&feature="+ConfigType+"&page="+page;
    }

    /** 根据关键字获取话题信息
     * @param keyWord 关键字，点击的话题
     * @return 包含话题【id】和话题信息,与从TimeLine中的话题进入相同
     */
    public static String getTopicByKey(String keyWord){
        return Host+"/channels/show.json?k="+keyWord;
    }

    /**获取未登陆用户的关注信息流链接
     * @param page
     * @return
     */
    public static String getAnonymousFocusLink(int page){
        return Host+"/medias/anonymous_feeds_timeline.json?page="+page;
    }

    /** 获取7天最热视频流【解析请使用getTopVideo】
     * @param chnnelId 频道ID
     * @return
     */
    public static String getHotIn7DaysById(String chnnelId){
        return Host+"/rank/medias.json?id="+chnnelId;
    }

    /**获取新人报道链接 【解析请使用getFocus】
     * @param page
     * @return
     */
    public static String getNewUserLink(int page){
        return Host+"/suggestions/new_medias.json?page="+page;
    }

    /**活动精选，其实就是话题精选，只不过界面不一样【重要】 解析之后直接根据ID进入话题界面，解析话题数据即可
     * @param page
     * @return 返回的是一个话题集合。
     */
    public static String getSelectedActivity(int page){
        return Host+"/common/square_medias_categories.json?parent_id=33&page="+page;
    }

    /**获取登录用户的信息流链接【获取数据需Access——token】
     * @param page
     * @return
     */
    public static String getUserFocusLink(int page){
        return Host+"/medias/feeds_timeline.json?page="+page;
    }

    /**
     * 根据视频ID获取视频播放页的详细信息
     * @param videoId 视频ID
     * @return 视频播放页链接
     */
    public static String getVideoInfoLink(String videoId){
    return SpliceLink("/medias/show.json?id=",videoId);
    }

    /**
     * 获得与当前视频相关的推荐
     * @param VideoId 当前视频ID
     * @return 推荐视频链接
     */
    public static String getRelativeVideoLink(String VideoId){
        return SpliceLink("/suggestions/medias_by_id.json?id=",VideoId);
    }

    /**
     * 获取当前视频的评论和热评链接
     * @param VideoId 当前视频ID
     * @param page 当前页码
     * @return 评论链接
     */
    public static String getCommentLink(String VideoId,int page){
        return SpliceLink("/comments/show.json?id=",VideoId)+"&page="+page;
    }

    /**创建评论链接【post】
     * @return
     */
    public static String getCommentCreatLink(){
        return Host+"/comments/create.json";
    }


    /**根据频道ID获取横幅图片广告图片
     * @param ChnnelId 频道ID
     * @return 广告图片Link
     */
    public static String getImageADsLink(String ChnnelId){
        return "https://newapi.meipai.com/channels/show.json?id="+ChnnelId;
    }


    /** 根据关键字返回搜索结果，可自定义每页搜索结果
     * @param keyWord 关键字
     * @param page 页码
     * @param count 每页的条目
     * @return 搜索结果链接
     */
    public static String getSearceLinkWithCount(String keyWord,int page,int count){
        return "https://newapi.meipai.com/search/user_mv.json?count="+count+"&page="+page+"&type=0&q="+keyWord;
    }

    /**根据关键字返回搜索结果链接，本函数为默认值，每页20条结果
     * 自定义每页条目使用getSearceLinkWithCount
     * @param keyWord 关键字
     * @param page 当前页码
     * @return 搜索结果Link
     */
    public static String getSearceLink(String keyWord,int page){
        return "https://newapi.meipai.com/search/user_mv.json?count=20&page="+page+"&type=0&q="+keyWord;
    }

    /**搜索用户的链接【需要access_token】，获取数据请用getStringWtihAccess
     * @param keyWord
     * @param page
     * @return 返回User类的集合
     */
    public static String getSearchUserLink(String keyWord,int page){
        return Host+"/search/users.json?page="+page+"&q="+keyWord;
    }

    /**添加关注的链接【POST】方法
     * @return
     */
    public static String getFriendShipCreate(){
        return "https://newapi.meipai.com/friendships/create.json";
    }

    /**取消关注的链接
     * @return
     */
    public static String getFriendShipCancle(){
        return "https://newapi.meipai.com/friendships/destroy.json";
    }

    /**用户转发的视频【第一页】
     * @param UserId
     * @return RepostsMediaBean
     */
    public static String getUserRepostsLinkByUID(String UserId) {
        return Host + "/reposts/user_timeline.json?uid="+UserId;
    }

    /**获取指定用户转发的视频【第二页及其以后】
     * 每页20条，不够20条后面就刷新不出来了。
     * @param UserId
     * @param maxMediaId 视频流中最后一个视频的ID
     * @return RepostsMediaBean
     */
    public static String getUserRepostsLinkByUID(String UserId,String maxMediaId) {
        return Host + "/reposts/user_timeline.json?uid="+UserId+"&max_id="+maxMediaId;
    }

    /** 获取指定用户的视频流链接【第一页】
     * @param UserId
     * @return MediaBean集合
     */
    public static String getTimeLineLinkByUID(String UserId){
        return Host+"/medias/user_timeline.json?uid="+UserId;
    }

    /**获取指定用户的视频流链接【第二页及其以后】
     * 每页20条，不够20条后面就刷新不出来了。
     * @param UserId
     * @param maxMediaId TimeLine最后一条Media对象的id值。
     * @return MediaBean集合
     */
    public static String getTimeLineLinkByUID(String UserId,String maxMediaId){
        return Host+"/medias/user_timeline.json?uid="+UserId+"&max_id="+maxMediaId;
    }

    /**获取用户的关注列表,
     * @param UserId
     * @param page
     * @return 【解析请使用getUserList】
     */
    public static String getFriendsLinkByUID(String UserId,int page){
        return "/friendships/friends.json?uid="+UserId+"&page="+page;
    }

    /**获取用户的粉丝列表
     * @param UserId
     * @param page
     * @return 【解析请使用getUserList】
     */
    public static String getFollowedLinkByUID(String UserId,int page){
        return Host+"/friendships/followers.json?uid="+UserId+"&page="+page;
    }

    /**根据输入的关键字获取推荐搜索关键字，自动填充
     * @param text 输入的关键字
     * @return 推荐关键字链接
     */
    public static String getRelativeSearchLink(String text){
        return SpliceLink("/search/word_assoc.json?q=",text);
    }

    /**根据频道ID拼装频道链接
     * @param ChnnelId 频道ID
     * @param page 当前页码
     * @return 获取每个频道的默认视频（进去该频道看到的视频链接）
     */
    public static String getTimeLineLinkById(String ChnnelId,int page){
        return "https://newapi.meipai.com/channels/feed_timeline.json?id="+ChnnelId+"&feature=new&page="+page;
    }

    /**根据频道ID获取频道热门用户排行榜，id!=1,热门频道没有用户排行榜（其他频道请加非空判断）
     * @param ChnnelId 频道ID
     * @return 用户排行榜链接
     */
    public static String getTop50UsersLinkById(String ChnnelId){
        return "https://newapi.meipai.com/rank/users.json?id="+ChnnelId;
    }

    /**根据频道ID获取热门排行榜视频
     * @param ChnnelId 频道ID
     * @return 热门视频排行榜link
     */
    public static String getTopVideoLink(String ChnnelId){
        return "https://newapi.meipai.com/rank/medias.json?id="+ChnnelId;
    }

    /**【我】界面中的美拍小技巧链接，webView中打开
     * @return
     */
    public static String getTipsLink(){
        return Host+"/tips?version=4100&client_id=1089857302&language=zh-Hans";
    }

    /** 获取推荐人链接【获取json需要access_token】
     * @param ConfigWantType 想关注的类型 在Config中
     * @param page
     * @return 获取数据请使用getStringWtihAccess；
     */
    public static String getWantFocusLink(int ConfigWantType,int page){
        return Host+"/suggestions/may_interested_users.json?count=20&page="+page+"&type="+ConfigWantType;
    }

    /**发现界面的link
     * @return
     */
    public static String getFindLink(){
        return Host+"/find/show.json?lat=34.772429&lon=113.675789";
    }

    /** 发现界面的link
     * @param lat 经度
     * @param lon 维度
     * @return
     */
    public static String getFindLink(String lat,String lon){
        return Host+"/find/show.json?lat="+lat+"&lon="+lon;
    }

    /**拼接链接的内部方法。
     * @param param
     * @param id
     * @return
     */
    private static String SpliceLink(String param,String id){
        return Host+param+id;
    }

}
