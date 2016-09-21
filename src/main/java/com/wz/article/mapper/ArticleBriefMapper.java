/**
 * 
 */
package com.wz.article.mapper;

import java.util.List;

import com.wz.article.model.ArticleModel;

/**
 * @author jade
 *
 */
public interface ArticleBriefMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(ArticleModel record);

    ArticleModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ArticleModel record);

	List<ArticleModel> findAll();
	
	ArticleModel selectByArticleUrl(String articleUrl);
}
