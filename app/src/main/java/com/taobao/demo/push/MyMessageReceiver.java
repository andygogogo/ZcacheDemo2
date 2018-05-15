package com.taobao.demo.push;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.sdk.android.push.MessageReceiver;
import com.alibaba.sdk.android.push.notification.CPushMessage;

import java.util.Map;

/**
 * @author: 正纬
 * @since: 15/4/9
 * @version: 1.1
 * @feature: 用于接收推送的通知和消息
 */
public class MyMessageReceiver extends MessageReceiver {

    // 消息接收部分的LOG_TAG
    public static final String REC_TAG = "receiver";

    /**
     * 从通知栏打开通知的扩展处理
     *
     * @param context
     * @param title
     * @param summary
     * @param extraMap
     */
    @Override
    public void onNotificationOpened(Context context, String title, String summary, String extraMap) {
        Log.i(TAG, "onNotificationOpened ： " + " : " + title + " : " + summary + " : " + extraMap);
    }

    /**
     * 通知删除回调
     *
     * @param context
     * @param messageId
     */
    @Override
    public void onNotificationRemoved(Context context, String messageId) {
        Log.i(TAG, "onNotificationRemoved ： " + messageId);
    }

    /**
     * 推送消息的回调方法
     *
     * @param context
     * @param cPushMessage
     */
    @Override
    public void onMessage(Context context, CPushMessage cPushMessage) {
        Log.i(TAG, "收到一条推送消息 ： " + cPushMessage.getTitle() + ", content:" + cPushMessage.getContent());
    }

    /**
     * 推送通知的回调方法
     *
     * @param context
     * @param title
     * @param summary
     * @param extraMap
     */
    @Override
    public void onNotification(Context context, String title, String summary, Map<String, String> extraMap) {
        // TODO 处理推送通知
        if (null != extraMap) {
            for (Map.Entry<String, String> entry : extraMap.entrySet()) {
                Log.i(TAG, "@Get diy param : Key=" + entry.getKey() + " , Value=" + entry.getValue());
            }
        } else {
            Log.i(TAG, "@收到通知 && 自定义消息为空");
        }
        Log.i(TAG, "收到一条推送通知 ： " + title + ", summary:" + summary);
        if (title.equals("10010:0")) {
            Toast.makeText(context, "中长期理财 预期收益达5.5%", Toast.LENGTH_LONG).show();
        }
        if (title.equals("10010:1")) {
            Toast.makeText(context, "理财进阶 老司机是怎样炼成的", Toast.LENGTH_LONG).show();
        }
        if (title.equals("10010:2")) {
            Toast.makeText(context, "新客专享 银行理财第一桶金", Toast.LENGTH_LONG).show();
        }
//        Toast.makeText(context, "收到一条推送通知 ： " + title + ", summary:" + summary, Toast.LENGTH_LONG).show();
    }

    /**
     * 应用处于前台时通知到达回调。注意:该方法仅对自定义样式通知有效,相关详情请参考https://help.aliyun.com/document_detail/30066.html?spm=5176.product30047.6.620.wjcC87#h3-3-4-basiccustompushnotification-api
     *
     * @param context
     * @param title
     * @param summary
     * @param extraMap
     * @param openType
     * @param openActivity
     * @param openUrl
     */
    @Override
    protected void onNotificationReceivedInApp(Context context, String title, String summary, Map<String, String> extraMap, int openType, String openActivity, String openUrl) {
        Log.i(TAG, "onNotificationReceivedInApp ： " + " : " + title + " : " + summary + "  " + extraMap + " : " + openType + " : " + openActivity + " : " + openUrl);
    }

    /**
     * 无动作通知点击回调。当在后台或阿里云控制台指定的通知动作为无逻辑跳转时,通知点击回调为onNotificationClickedWithNoAction而不是onNotificationOpened
     *
     * @param context
     * @param title
     * @param summary
     * @param extraMap
     */
    @Override
    protected void onNotificationClickedWithNoAction(Context context, String title, String summary, String extraMap) {
        Log.i(TAG, "onNotificationClickedWithNoAction ： " + " : " + title + " : " + summary + " : " + extraMap);
    }
}