package com.godmonth.social.weibo.api;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.twitter.api.MessageTooLongException;
import org.springframework.social.twitter.api.Tweet;

/**
 * @author shenyue
 */
public interface TimelineOperations {
	/**
	 * Updates the user's status.
	 * 
	 * @param status
	 *            The status message
	 * @throws ApiException
	 *             if there is an error while communicating with Twitter.
	 * @throws DuplicateTweetException
	 *             if the status message duplicates a previously posted status.
	 * @throws MessageTooLongException
	 *             if the length of the status message exceeds Twitter's 140
	 *             character limit.
	 * @throws MissingAuthorizationException
	 *             if TwitterTemplate was not created with OAuth credentials.
	 */
	Tweet updateStatus(String status);
}
