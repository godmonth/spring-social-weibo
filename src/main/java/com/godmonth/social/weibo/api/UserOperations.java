package com.godmonth.social.weibo.api;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.twitter.api.TwitterProfile;

/**
 * @author shenyue
 */
public interface UserOperations {
	/**
	 * Retrieves the authenticated user's Twitter ID.
	 * 
	 * @return the user's ID at Twitter
	 * @throws ApiException
	 *             if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException
	 *             if TwitterTemplate was not created with OAuth credentials.
	 */
	long getProfileId();

	/**
	 * Retrieves the authenticated user's Twitter screen name
	 * 
	 * @return the user's screen name
	 * @throws ApiException
	 *             if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException
	 *             if TwitterTemplate was not created with OAuth credentials.
	 */
	String getScreenName();

	/**
	 * Retrieves the authenticated user's Twitter profile details.
	 * 
	 * @return a {@link TwitterProfile} object representing the user's profile.
	 * @throws ApiException
	 *             if there is an error while communicating with Twitter.
	 * @throws MissingAuthorizationException
	 *             if TwitterTemplate was not created with OAuth credentials.
	 */
	WeiboProfile getUserProfile();
}
