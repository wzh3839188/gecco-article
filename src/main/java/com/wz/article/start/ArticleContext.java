/**
 * 
 */
package com.wz.article.start;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpGetRequest;

/**
 * 文章爬虫启动上下文
 * 
 * @author jade
 *
 */
@Service
public class ArticleContext implements ApplicationContextAware, InitializingBean {

	private ApplicationContext context;

	@Override
	public void afterPropertiesSet() throws Exception {
//		PipelineFactory springPipelineFactory = (PipelineFactory) this.context.getBean("springPipelineFactory");
//		HttpGetRequest start = new HttpGetRequest("http://so.csdn.net/so/search/s.do?p=1&q=Java");
//		start.setCharset("UTF-8");
//		GeccoEngine.create().classpath("com.wz.article")
//			.pipelineFactory(springPipelineFactory)
//			.interval(2000)
//			.start(start)
//			.run();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.in.read();
		context.close();
	}

}
