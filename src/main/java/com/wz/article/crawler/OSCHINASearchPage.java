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
import com.wz.article.entity.OSCHINArticleListEntity;

/**
 * @author jade
 *
 */
@Gecco(matchUrl="https://www.oschina.net/search?{params}", pipelines={"consolePipeline", "OSCHINASearchListPipeline"})
public class OSCHINASearchPage implements HtmlBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8700674273469531881L;

	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String params;
	
	@RequestParameter
	private String keyword;
	
	@RequestParameter
	private String page;
	
	@RequestParameter
	private String siteType;
	
	@HtmlField(cssPath=".obj_type_3")
	private List<OSCHINArticleListEntity> articleList;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPage() {
		//因为之前会打印，所以这个方法会被调用，可以作为其他参数的初始化方法
		if(params != null && !"".equals(params)){
			String[] kvs = params.split("&");
			if(kvs != null && kvs.length > 0){
				for(String kv : kvs){
					String[] kvArray = kv.split("=");
					if(kv.contains("p")){
						this.page = kvArray[1];
					}else if(kv.contains("q")){
						this.keyword = kvArray[1];
					}
				}
			}
		}
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

	public List<OSCHINArticleListEntity> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<OSCHINArticleListEntity> articleList) {
		this.articleList = articleList;
	}
	
	
}
