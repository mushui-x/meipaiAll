package com.gzw.mp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.gzw.mp.activities.WelcomeActivity;
import com.gzw.mp.utils.LogUtil;

/**
 * coder by 背离记 on 2015/11/12.
 */
public class TopicTextView extends TextView {

    public TopicTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopicTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setClickable(true);
        //setText(getClickableSpan());
        setMovementMethod(LinkMovementMethod.getInstance());
        String text = this.getText().toString();
        String[] m = text.split("#");
        if(m.length>2) {//判断是否有话题
            for(int i=0;i<m.length;i++){//有话题遍历数组，把话题高亮
                if(i%2==1){//这里是话题
                    String temptopic=m[i];
                    int index= text.indexOf(temptopic);
                    String topic=text.substring(index-1,index+temptopic.length());
                    if(null!=text.substring(index+temptopic.length(),index+temptopic.length()+1)) {
                   /* if(topic.endsWith("#")) {
                        setText(getClickableSpan(index-1, topic));
                    }*/
                        setText(getClickableSpan(index-1,topic));
                    }
                    LogUtil.i("View",topic);
                }
            }
        }

    }

    private SpannableString getClickableSpan(int begin,String topic) {
        View.OnClickListener l = new View.OnClickListener() {
            //如下定义自己的动作
            public void onClick(View v) {
                LogUtil.i("View", "========");
                //在这里就可以做跳转到activity或者弹出对话框的操作了

                Intent intent =new Intent(getContext(), WelcomeActivity.class);
                getContext().startActivity(intent);
            }
        };
        SpannableString spanableInfo = new SpannableString(this.getText());
            int start = begin;
            int end = begin+topic.length();
            spanableInfo.setSpan(new Clickable(l), start, end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spanableInfo;
    }

    class Clickable extends ClickableSpan implements View.OnClickListener {
        private final View.OnClickListener mListener;

        public Clickable(View.OnClickListener l) {
            mListener = l;
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v);
        }
    }
}
