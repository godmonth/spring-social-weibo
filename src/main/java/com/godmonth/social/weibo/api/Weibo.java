package com.godmonth.social.weibo.api;

/**
 * @author shenyue
 */
public interface Weibo {
	/**
	 * Returns the portion of the Twitter API containing the user operations.
	 */
	UserOperations userOperations();

	TimelineOperations timelineOperations();
}
