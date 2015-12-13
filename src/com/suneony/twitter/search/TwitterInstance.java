package com.suneony.twitter.search;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterInstance {
	private Properties config=null;
	private Twitter twitter=null;
	public TwitterInstance(){
		config=new Properties();
		InputStream configStream=null;
		//load properties file
		try {
			configStream=new FileInputStream("config.properties");
			config.load(configStream);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//close the stream
				configStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Twitter auth
		ConfigurationBuilder twitterConfigurationBuilder=null;
		twitterConfigurationBuilder=new ConfigurationBuilder();
		twitterConfigurationBuilder.setDebugEnabled(true).setOAuthConsumerKey(config.getProperty("CONSUMER_KEY"))
		.setOAuthConsumerSecret(config.getProperty("CONSUMER_SECRET"))
		.setOAuthAccessToken(config.getProperty("ACCESS_TOKEN"))
		.setOAuthAccessTokenSecret(config.getProperty("ACCESS_TOKEN_SECRET"));
		TwitterFactory twitterFactory=new TwitterFactory(twitterConfigurationBuilder.build());
		//返回认证后Twitter实例
		this.twitter=twitterFactory.getInstance();
	}
	public Twitter instance(){
		return this.twitter;
	}
}
