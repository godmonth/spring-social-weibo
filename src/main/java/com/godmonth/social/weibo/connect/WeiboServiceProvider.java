package com.godmonth.social.weibo.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

import com.godmonth.social.weibo.api.Weibo;
import com.godmonth.social.weibo.api.impl.WeiboOauth2Template;
import com.godmonth.social.weibo.api.impl.WeiboTemplate;

/**
 * @author shenyue
 */
public class WeiboServiceProvider extends AbstractOAuth2ServiceProvider<Weibo> {

	public WeiboServiceProvider(String clientId, String clientSecret) {
		super(new WeiboOauth2Template(clientId, clientSecret));
	}

	@Override
	public Weibo getApi(String accessToken) {
		return new WeiboTemplate(accessToken);
	}

}
