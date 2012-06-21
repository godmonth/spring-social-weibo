package com.godmonth.social.weibo.api;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shenyue
 */
public class WeiboProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String screenName;
	private String name;
	private String url;
	private String profileImageUrl;
	private String description;
	private String location;
	private Date createdDate;

	public long getId() {
		return id;
	}

	public String getScreenName() {
		return screenName;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
