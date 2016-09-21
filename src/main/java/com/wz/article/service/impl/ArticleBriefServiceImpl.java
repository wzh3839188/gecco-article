/**
 * 
 */
package com.wz.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wz.article.mapper.ArticleBriefMapper;
import com.wz.article.model.ArticleModel;
import com.wz.article.service.ArticleBriefService;

/**
 * @author jade
 *
 */
@Service
public class ArticleBriefServiceImpl implements ArticleBriefService {

	@Autowired
    private ArticleBriefMapper articleBriefMapper;
	
	@Override
	public void save(ArticleModel article) {
		articleBriefMapper.insert(article);
	}

	@Override
	public List<ArticleModel> findAll() {
		return articleBriefMapper.findAll();
	}

	@Override
	public ArticleModel selectByArticleUrl(String articleUrl) {
		return articleBriefMapper.selectByArticleUrl(articleUrl);
	}

}
