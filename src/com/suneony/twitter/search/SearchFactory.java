package com.suneony.twitter.search;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.json.DataObjectFactory;

public class SearchFactory {
	private Twitter twitter = null;

	public SearchFactory() {
		TwitterInstance twitterInstance = new TwitterInstance();
		this.twitter = twitterInstance.instance();
	}
	/**
	 * @param keyword 检索的关键词
	 * @return 返回15条相关博文
	 * */
	@SuppressWarnings("unused")
	public List<String> search(String keyword) {
		//根据关键词构建Twitter查询
		Query query = new Query(keyword);
		//查询结果
		QueryResult result = null;
		//函数返回结果
		ArrayList<String> statusStringList = new ArrayList<String>();
		try {
			// 检索
			result = this.twitter.search(query);
			// 获取检索到的Tweet集合
			List<Status> statusList = result.getTweets();
			// 将Status转为标准JSON格式，方便解析
			for (Status status : statusList) {
				String string = DataObjectFactory.getRawJSON(status);
				statusStringList.add(string);
			}
		} catch (TwitterException e) {
			e.printStackTrace();
			return null;
		}
		return statusStringList;
	}
	/**
	 * put your code in your_function
	 */
	public void your_function() {
//		for(String keyword:YourWordList){
//			ArrayList<String> tweetListOfKeyword=(ArrayList<String>) search(keyword);
//			//
//		}
	}
}
