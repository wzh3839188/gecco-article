/**
 * 
 */
package com.wz.article.crawler;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.wz.article.entity.CSDNArticleListEntity;

/**
 * CSDN搜索页解析类
 * @author jade
 *
 */
@Gecco(matchUrl="http://so.csdn.net/so/search/s.do?p={page}&q={keyword}", pipelines={"consolePipeline","CSDNSearchListPipeline"})
public class CSDNSearchPage implements HtmlBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8768911729454034269L;
	
	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String page;

	@RequestParameter
	private String keyword;
	
	@RequestParameter
	private String siteType;
	
	@HtmlField(cssPath = ".search-list")
	List<CSDNArticleListEntity> articleList;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public List<CSDNArticleListEntity> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<CSDNArticleListEntity> articleList) {
		this.articleList = articleList;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public static void main(String[] args) {
		HttpGetRequest start = new HttpGetRequest("http://so.csdn.net/so/search/s.do?p=1&q=Java");
		start.setCharset("UTF-8");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PipelineFactory springPipelineFactory = (PipelineFactory) ctx.getBean("springPipelineFactory");
		GeccoEngine.create()
				.pipelineFactory(springPipelineFactory)
				.classpath("com.wz.article")
				.start(start)
				.run();
	}
}
