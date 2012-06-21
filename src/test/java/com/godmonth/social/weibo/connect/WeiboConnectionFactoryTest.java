package com.godmonth.social.weibo.connect;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.client.HttpClientErrorException;
import org.testng.annotations.Test;

import com.godmonth.social.weibo.api.Weibo;

public class WeiboConnectionFactoryTest {

	@Test(enabled = true)
	public void WeiboConnectionFactory() {
		WeiboConnectionFactory wcf = new WeiboConnectionFactory("3921313684", "3b6943fe1082b2f03552d14d4e5c545b");
		OAuth2Operations oAuthOperations = wcf.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri("http://shenyue.weibopay.com/echo/hello");
		String authorizeUrl = oAuthOperations.buildAuthorizeUrl(GrantType.IMPLICIT_GRANT, params);
		System.out.println(authorizeUrl);
	}

	@Test
	public void getO() {
		WeiboConnectionFactory wcf = new WeiboConnectionFactory("3921313684", "3b6943fe1082b2f03552d14d4e5c545b");
		try {
			Connection<Weibo> createConnection = wcf.createConnection(new AccessGrant(
					"2.00dL49pBuo74RE9ebb5e764fAPvMED"));
			UserProfile fetchUserProfile = createConnection.fetchUserProfile();
			System.out.println(ToStringBuilder.reflectionToString(fetchUserProfile, ToStringStyle.MULTI_LINE_STYLE));
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
		}

	}
}
