/**
 * 
 */
package com.wz.article.entity;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.wz.article.model.ArticleModel;

/**
 * @author jade
 *
 */
public class CNBLOGArticleListEntity implements HtmlBean, IArticleEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Text(own = false)
	@HtmlField(cssPath = ".searchItemTitle > a")
	private String articleTitle;
	
	@Href
	@HtmlField(cssPath = ".searchItemTitle > a")
	private String articleUrl;
	
	@Text(own = false)
	@HtmlField(cssPath = ".searchCon")
	private String articleDescription;
	
	@Text
	@HtmlField(cssPath = ".searchItemInfo > .searchItemInfo-userName > a")
	private String articleAuthor;
	
	@Href
	@HtmlField(cssPath = ".searchItemInfo > .searchItemInfo-userName > a")
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

	@Override
	public ArticleModel generateModel() {
		ArticleModel model = new ArticleModel();
		model.setArticleTitle(articleTitle);
		model.setArticleUrl(articleUrl);
		model.setArticleDescription(articleDescription);
		model.setArticleAuthor(articleAuthor);
		model.setArticleAuthorUrl(articleAuthorUrl);
		return model;
	}

}
