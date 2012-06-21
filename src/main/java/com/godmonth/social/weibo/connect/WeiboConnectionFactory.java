package com.godmonth.social.weibo.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.godmonth.social.weibo.api.Weibo;

/**
 * @author shenyue
 */
public class WeiboConnectionFactory extends OAuth2ConnectionFactory<Weibo> {
	public WeiboConnectionFactory(String clientId, String clientSecret) {
		super("weibo", new WeiboServiceProvider(clientId, clientSecret), new WeiboAdapter());
	}

}
