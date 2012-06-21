package com.godmonth.social.weibo.api.impl;

import org.springframework.web.client.RestTemplate;

import com.godmonth.social.weibo.api.UserOperations;
import com.godmonth.social.weibo.api.WeiboProfile;

/**
 * @author shenyue
 */
public class UserTemplate extends AbstractWeiboOperations implements UserOperations {
	private final RestTemplate restTemplate;

	public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	public long getProfileId() {
		requireAuthorization();
		return getUserProfile().getId();
	}

	public String getScreenName() {
		requireAuthorization();
		return getUserProfile().getScreenName();
	}

	private Uid uid;

	private static class Uid {
		private String uid;

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

	}

	private String getUid() {
		if (uid == null) {
			uid = restTemplate.getForObject(buildUri("account/get_uid.json"), Uid.class);
		}
		return uid != null ? uid.getUid() : null;
	}

	@Override
	public WeiboProfile getUserProfile() {
		requireAuthorization();
		return restTemplate.getForObject(buildUri("users/show.json?uid=" + getUid()), WeiboProfile.class);
	}
}
