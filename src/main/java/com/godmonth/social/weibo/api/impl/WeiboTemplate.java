package com.godmonth.social.weibo.api.impl;

import org.codehaus.jackson.map.DeserializationConfig;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

import com.godmonth.social.weibo.api.TimelineOperations;
import com.godmonth.social.weibo.api.UserOperations;
import com.godmonth.social.weibo.api.Weibo;

/**
 * @author shenyue
 */
public class WeiboTemplate extends AbstractOAuth2ApiBinding implements Weibo {
	private UserOperations userOperations;
	private TimelineOperations timelineOperations;

	public WeiboTemplate(String accessToken) {
		super(accessToken);
		initialize();
	}

	@Override
	public UserOperations userOperations() {
		return userOperations;
	}

	protected void initialize() {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();

	}

	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.BEARER_DRAFT_2;
	}

	private void initSubApis() {
		userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
	}

	@Override
	public TimelineOperations timelineOperations() {
		return timelineOperations;
	}

	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
		converter.getObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return converter;
	}
}
