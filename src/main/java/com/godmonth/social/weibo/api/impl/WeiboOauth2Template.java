package com.godmonth.social.weibo.api.impl;

import java.util.Collections;

import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestTemplate;

/**
 * @author shenyue
 */
public class WeiboOauth2Template extends OAuth2Template {
	public WeiboOauth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret, "https://api.weibo.com/oauth2/authorize",
				"https://api.weibo.com/oauth2/access_token");
	}

	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
		FormHttpMessageConverter messageConverter = new FormHttpMessageConverter() {
			public boolean canRead(Class<?> clazz, MediaType mediaType) {
				// always read as x-www-url-formencoded even though Facebook
				// sets contentType to text/plain
				return true;
			}
		};
		restTemplate.setMessageConverters(Collections.<HttpMessageConverter<?>> singletonList(messageConverter));
		return restTemplate;
	}

}
