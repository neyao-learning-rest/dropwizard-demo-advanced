package cn.com.deepdata.frontend.service;

import cn.com.deepdata.frontend.pojo.WeixinSentMessage;

/**
 * Created by neyao@github.com on 2016/3/31.
 */
public interface WeiXinService {

    public void recordWeixinSentLog(WeixinSentMessage weixinSentMessage);

}
