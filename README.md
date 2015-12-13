# TwitterSearch
a tool for searching tweets by giving keyword

com.suneony.twitter.search.SearchFactory\n
  List<List> search(String keyword)\n
  输入搜索关键词，返回15条相关博文，博文都是String存储的JSON。可以通过net.sf.json下面的工具进行解析（相关包已包含在工程中）
