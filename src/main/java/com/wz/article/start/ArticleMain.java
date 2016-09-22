/**
 * 
 */
package com.wz.article.start;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;

/**
 * @author jade
 *
 */
public class ArticleMain {
	
	private static final int MAXPAGE = 5;
	private static String[][] siteList = {
			{"CSDN", "http://so.csdn.net/so/search/s.do?p=%s&q=%s"},
			{"51CTO", "http://so.51cto.com/index.php?project=blog&p=%s&keywords=%s"},
			{"51CTO", "http://so.51cto.com/index.php?project=bbs&p=%s&keywords=%s"},
			{"ITEYE", "http://www.iteye.com/search?page=%s&query=%s&type=topic"},
			{"ITEYE", "http://www.iteye.com/search?page=%s&query=%s&type=blog"},
			{"ITEYE", "http://www.iteye.com/search?page=%s&query=%s&type=news"},
			{"CNBLOG", "http://zzk.cnblogs.com/s/blogpost?pageIndex=%s&Keywords=%s"},
			//OSCHINA有个问题，如果不加fromerr会返回一个scrpit，这个脚本啥都没干就是参数加上fromerr然后重新刷页面。。。
			{"OSCHINA", "https://www.oschina.net/search?p=%s&q=%s&scope=all&fromerr=MBhZhRzC"}
			}; 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String keyword = "Java";
		if(args != null && args.length > 0){
			keyword = args[0];
		}
		List<HttpRequest> requestList = new ArrayList<>();
		for(int i = 0;i < siteList.length;i++){
			String[] siteInfo = siteList[i];
			for(int page = 1;page <= MAXPAGE;page++){
				HttpGetRequest start = new HttpGetRequest(String.format(siteInfo[1], page, keyword));
				start.addParameter("siteType", siteInfo[0]);
				start.setCharset("UTF-8");
				requestList.add(start);
			}
		}
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PipelineFactory springPipelineFactory = (PipelineFactory) ctx.getBean("springPipelineFactory");
		GeccoEngine.create()
				.pipelineFactory(springPipelineFactory)
				.classpath("com.wz.article")
				.start(requestList)
				.run();
	}

}
