/**
 * 
 */
package com.wz.article.service;

import java.util.List;

import com.wz.article.model.ArticleModel;

/**
 * @author jade
 *
 */
public interface ArticleBriefService {
	void save(ArticleModel article);
    
    List<ArticleModel> findAll();
    
    ArticleModel selectByArticleUrl(String articleUrl);
}
