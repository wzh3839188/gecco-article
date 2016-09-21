/**
 * 
 */
package com.wz.article.crawler;

import java.util.List;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.wz.article.entity.ITETYEArticleListEntity;

/**
 * @author jade
 *
 */
@Gecco(matchUrl="http://www.iteye.com/search?{params}", pipelines={"consolePipeline", "ITEYESearchListPipeline"})
public class ITEYESearchPage implements HtmlBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4472320622588435892L;

	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String params;
	
	@RequestParameter
	private String keyword;
	
	@RequestParameter
	private String type;
	
	@RequestParameter
	private String page;
	
	@RequestParameter
	private String siteType;
	
	@HtmlField(cssPath=".topic")
	private List<ITETYEArticleListEntity> articleList;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public List<ITETYEArticleListEntity> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ITETYEArticleListEntity> articleList) {
		this.articleList = articleList;
	}

	public String getParams() {
		//因为之前会打印，所以这个方法会被调用，可以作为其他参数的初始化方法
		if(params != null && !"".equals(params)){
			String[] kvs = params.split("&");
			if(kvs != null && kvs.length > 0){
				for(String kv : kvs){
					String[] kvArray = kv.split("=");
					if(kv.contains("page")){
						this.page = kvArray[1];
					}else if(kv.contains("query")){
						this.keyword = kvArray[1];
					}else if(kv.contains("type")){
						this.type = kvArray[1];
					}
				}
			}
		}
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
}
