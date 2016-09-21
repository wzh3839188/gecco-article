/**
 * 
 */
package com.wz.article.entity;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.wz.article.model.ArticleModel;

/**
 * 文章列表实体，简单包含文章标题，url和文章简述
 * 
 * @author jade
 *
 */
public class CSDNArticleListEntity implements HtmlBean,IArticleEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8538067140547057799L;
	
	@Text(own = false)
	@HtmlField(cssPath = ".csdn-tracking-statistics > a")
	private String articleTitle;
	
	@Href
	@HtmlField(cssPath = ".csdn-tracking-statistics > a")
	private String articleUrl;
	
	@Text(own = false)
	@HtmlField(cssPath = ".search-detail")
	private String articleDescription;
	
	@Text(own = false)
	@HtmlField(cssPath = ".author-time")
	private String articleAccessInfo;
	
	@Text
	@HtmlField(cssPath = ".author-time > a")
	private String articleAuthor;
	
	@Href
	@HtmlField(cssPath = ".author-time > a")
	private String articleAuthorUrl;

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public String getArticleAccessInfo() {
		return articleAccessInfo;
	}

	public void setArticleAccessInfo(String articleAccessInfo) {
		this.articleAccessInfo = articleAccessInfo;
	}
	
	public String getArticleAuthor() {
		return articleAuthor;
	}

	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}

	public String getArticleAuthorUrl() {
		return articleAuthorUrl;
	}

	public void setArticleAuthorUrl(String articleAuthorUrl) {
		this.articleAuthorUrl = articleAuthorUrl;
	}

	public ArticleModel generateModel(){
		ArticleModel model = new ArticleModel();
		model.setArticleTitle(articleTitle);
		model.setArticleUrl(articleUrl);
		model.setArticleDescription(articleDescription);
		model.setArticleAuthor(articleAuthor);
		model.setArticleAuthorUrl(articleAuthorUrl);
		return model;
	}

}
