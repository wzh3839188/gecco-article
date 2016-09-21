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
public class CTO51ArticleListEntity implements HtmlBean,IArticleEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6855576161373460702L;

	@Text(own = false)
	@HtmlField(cssPath = "h2 > a")
	private String articleTitle;
	
	@Href
	@HtmlField(cssPath = "h2 > a")
	private String articleUrl;
	
	@Text(own = false)
	@HtmlField(cssPath = "p")
	private String articleDescription;

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
	
	public ArticleModel generateModel(){
		ArticleModel model = new ArticleModel();
		model.setArticleTitle(articleTitle);
		model.setArticleUrl(articleUrl);
		model.setArticleDescription(articleDescription);
		model.setArticleAuthor("unkown");
		model.setArticleAuthorUrl("unkown");
		return model;
	}
}
