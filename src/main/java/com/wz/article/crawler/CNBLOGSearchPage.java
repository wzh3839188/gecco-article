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
import com.wz.article.entity.CNBLOGArticleListEntity;

/**
 * @author jade
 *
 */
@Gecco(matchUrl="http://zzk.cnblogs.com/s/blogpost?pageIndex={page}&Keywords={keyword}",pipelines={"consolePipeline","CNBLOGSearchListPipeline"})
public class CNBLOGSearchPage implements HtmlBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5423203445326376800L;

	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String page;

	@RequestParameter
	private String keyword;
	
	@RequestParameter
	private String siteType;
	
	@HtmlField(cssPath = ".searchItem")
	List<CNBLOGArticleListEntity> articleList;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
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

	public List<CNBLOGArticleListEntity> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<CNBLOGArticleListEntity> articleList) {
		this.articleList = articleList;
	}
	
}
