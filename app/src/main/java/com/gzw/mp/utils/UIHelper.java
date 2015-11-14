package com.gzw.mp.utils;

import android.content.Context;
import android.widget.Toast;

import com.gzw.mp.MyApplication;
import com.gzw.mp.callBack.CallString;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.http.client.multipart.HttpMultipartMode;
import com.lidroid.xutils.http.client.multipart.MultipartEntity;
import com.lidroid.xutils.http.client.multipart.content.StringBody;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * coder by 背离记 on 2015/11/3.
 */
public class UIHelper {

    private static final String TAG = "UIHelper";

    /**
     * 通过线程池方式实现获取String类型数据
     *【所有根据链接获取字符串的方法】
     * @param url             地址
     * @param requestCallBack 收到数据之后的监听对象
     */
    public static String getStringFromNet(final String url, final RequestCallBack<String> requestCallBack) {
                HttpUtils httpUtils = new HttpUtils();
                httpUtils.send(HttpRequest.HttpMethod.GET, url, requestCallBack);
        return null;
    }


    /** 获取已登录用户的JSON数据【需要access_token才能访问的数据】
     * @param url
     * @param access_token 测试用口令在Config中
     * @param call
     * @return
     */
    public static String getStringWtihAccess(String url,String access_token,RequestCallBack<String> call){
        HttpUtils httpUtils = new HttpUtils();
        RequestParams params =new RequestParams();
        params.addHeader("access-token", access_token);
        httpUtils.send(HttpRequest.HttpMethod.GET, url, params, call);
        return null;
    }



    /**
     * 获取短信验证码，已经在子线程中。n秒后重新发送验证码请重新调用我
     *
     * @param phoNum 电话号码
     * @param pwd    密码
     * @param call   返回信息的回调结果。
     *               一切顺利返回的json中包含一个true
     */
    public static void getVerifySMS(final String phoNum, final String pwd, final CallString call) {
        String url = APIUtils.getSMSUrl;
        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        try {
            reqEntity.addPart("password", new StringBody(pwd));
            reqEntity.addPart("device_id", new StringBody("864690025974851"));
            reqEntity.addPart("client_id", new StringBody("1089857302"));
            reqEntity.addPart("phone", new StringBody(phoNum));
        } catch (Exception e) {
            e.printStackTrace();
        }
        POST2meiPai(reqEntity, url, call);
    }

    /**注册方法。
     * @param phoNum
     * @param pwd
     * @param SMSCode 短信验证码
     * @param call 注册回调接口，字符串包含error证明错误
     */
    public static void SignUp(String phoNum,String pwd,String SMSCode,CallString call){
        String url = APIUtils.SignUpUrl;
        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        try {
            reqEntity.addPart("password", new StringBody(pwd));
            reqEntity.addPart("device_id", new StringBody("864690025974851"));
            reqEntity.addPart("client_id", new StringBody("1089857302"));
            reqEntity.addPart("phone", new StringBody(phoNum));
            reqEntity.addPart("client_secret",new StringBody("38e8c5aet76d5c012e32"));
            reqEntity.addPart("verify_code",new StringBody(SMSCode));
            reqEntity.addPart("grant_type",new StringBody("phone"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        POST2meiPai(reqEntity,url,call);
    }

    /** 通过ID关注用户
     * @param access_token
     * @param id
     * @param call 成功返回"following": true,"followed_by": false
     *             错误返回"error_code": 20506, "error": "已经关注过TA了"
     */
    public static void FriendShipCreate(String access_token,String id,CallString call){
        String url = APIUtils.getFriendShipCreate();
        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        try {
            reqEntity.addPart("access_token", new StringBody(access_token));
            reqEntity.addPart("id", new StringBody(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        POST2meiPai(reqEntity,url,call);
    }

    /** 通过ID取消关注
     * @param access_token
     * @param id
     * @param call 成功返回 "following": false,"followed_by": false
     *             失败返回"error_code": 20508,"error": "你还未关注此用户"
     */
    public static void FriendShipCancle(String access_token,String id,CallString call){
        String url = APIUtils.getFriendShipCancle();
        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        try {
            reqEntity.addPart("access_token", new StringBody(access_token));
            reqEntity.addPart("id", new StringBody(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        POST2meiPai(reqEntity,url,call);
    }

    /**发送评论方法
     * @param access_token
     * @param MediaId 要评论视频的ID
     * @param comment 评论内容
     * @param call 成功 返回一个单个的CommentBean的json，即刚刚发送的评论
     *             错误 "error_code": 10107,"error": "系统错误",
     */
    public static void CommentCreate(String access_token,String MediaId,String comment,CallString call){
        String url = APIUtils.getCommentCreatLink();
        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        try {
            reqEntity.addPart("access_token", new StringBody(access_token));
            reqEntity.addPart("id", new StringBody(MediaId));
            reqEntity.addPart("comment",new StringBody(comment));
        } catch (Exception e) {
            e.printStackTrace();
        }
        POST2meiPai(reqEntity,url,call);

    }

    /**登录方法 返回结果调用JsonPaser解析
     * @param phoNum
     * @param pwd
     * @param call 登录信息回调接口 登录成功返回包含access_token和一个User对象的JSON
     */
    public static void Login(String phoNum,String pwd,CallString call){
    String url = APIUtils.LoginUrl;
        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        try {
            reqEntity.addPart("password", new StringBody(pwd));
            reqEntity.addPart("device_id", new StringBody("864690025974851"));
            reqEntity.addPart("client_id", new StringBody("1089857302"));
            reqEntity.addPart("phone", new StringBody(phoNum));
            reqEntity.addPart("client_secret",new StringBody("38e8c5aet76d5c012e32"));
            reqEntity.addPart("grant_type",new StringBody("phone"));
            reqEntity.addPart("device_token",new StringBody("5198a1385aa95a5a77660e889df26f11"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        POST2meiPai(reqEntity,url,call);
    }


    /** 发送POST请求的真正工作者.
     * @param reqEntity
     * @param url
     * @param call
     */
    private static void POST2meiPai(final MultipartEntity reqEntity, final String url, final CallString call) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost post = new HttpPost(url);
                post.setEntity(reqEntity);
                try {
                    HttpResponse response = httpClient.execute(post);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                    String sResponse;
                    StringBuilder s = new StringBuilder();
                    while ((sResponse = reader.readLine()) != null) {
                        s = s.append(sResponse);
                    }
                    call.getString(s.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolUtil.addThread(runnable);
    }


    public static void ToastUtil(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void ToastUtil(String msg) {
        Toast.makeText(MyApplication.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }

}
