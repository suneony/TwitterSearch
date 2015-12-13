package com.suneony.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.suneony.twitter.search.SearchFactory;

public class SearchFactoryTest {

	@Test
	public void testSearchFactory() {
	}

	@Test
	public void testSearch() {
		SearchFactory searchFactory=new SearchFactory();
		ArrayList<String> jsonList=(ArrayList<String>) searchFactory.search("cyber");
		for(String string:jsonList){
			System.out.println(string);
		}
	}

	@Test
	public void testMain() {
	}

}
