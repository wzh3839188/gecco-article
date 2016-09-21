/**
 * 
 */
package com.wz.article.model;

/**
 * @author jade
 *
 */
public class ArticleModel {
	private int id;
	private String articleTitle;
	private String articleUrl;
	private String articleDescription;
	private String articleAuthor;
	private String articleAuthorUrl;
	private String keyword;
	private String siteType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
}
