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
import com.wz.article.entity.CTO51ArticleListEntity;

/**
 * @author jade
 *
 */
@Gecco(matchUrl="http://so.51cto.com/index.php?project={project}&p={page}&keywords={keyword}", pipelines={"consolePipeline", "CTO51SearchListPipeline"})
public class CTO51SearchPage implements HtmlBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6991217496225912047L;

	@Request
	private HttpRequest request;
	
	@RequestParameter
	private String project;
	
	@RequestParameter
	private String keyword;
	
	@RequestParameter
	private String page;
	
	@RequestParameter
	private String siteType;
	
	@HtmlField(cssPath = ".res-doc")
	List<CTO51ArticleListEntity> articleList;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public List<CTO51ArticleListEntity> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<CTO51ArticleListEntity> articleList) {
		this.articleList = articleList;
	}
	
}
