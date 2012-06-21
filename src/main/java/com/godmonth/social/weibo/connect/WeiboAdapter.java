package com.godmonth.social.weibo.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

import com.godmonth.social.weibo.api.Weibo;
import com.godmonth.social.weibo.api.WeiboProfile;

/**
 * @author shenyue
 */
public class WeiboAdapter implements ApiAdapter<Weibo> {
	
	public boolean test(Weibo weibo) {
		try {
			weibo.userOperations().getUserProfile();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(Weibo weibo, ConnectionValues values) {
		WeiboProfile profile = weibo.userOperations().getUserProfile();
		values.setProviderUserId(Long.toString(profile.getId()));
		values.setDisplayName("@" + profile.getScreenName());
		values.setImageUrl(profile.getProfileImageUrl());
	}

	public UserProfile fetchUserProfile(Weibo weibo) {
		WeiboProfile profile = weibo.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getName()).setUsername(profile.getScreenName()).build();
	}

	public void updateStatus(Weibo weibo, String message) {
		weibo.timelineOperations().updateStatus(message);
	}

}
