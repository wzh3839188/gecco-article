/**
 * 
 */
package com.wz.article.pipeline;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.wz.article.crawler.CNBLOGSearchPage;
import com.wz.article.entity.CNBLOGArticleListEntity;
import com.wz.article.model.ArticleModel;
import com.wz.article.service.ArticleBriefService;

/**
 * @author jade
 *
 */
@Service("CNBLOGSearchListPipeline")
public class CNBLOGSearchListPipeline implements Pipeline<CNBLOGSearchPage> {

	@Resource(name="articleBriefServiceImpl")
	private ArticleBriefService articleBriefService;
	
	@Override
	public void process(CNBLOGSearchPage bean) {
		List<CNBLOGArticleListEntity> articleList = bean.getArticleList();
		if(articleList != null){
			for(CNBLOGArticleListEntity entity : articleList){
				if(entity.getArticleTitle() != null){
					ArticleModel model = articleBriefService.selectByArticleUrl(entity.getArticleUrl());
					if(model == null){
						//插入数据库
						model = entity.generateModel();
						model.setKeyword(bean.getKeyword());
						model.setSiteType(bean.getSiteType());
						articleBriefService.save(model);
						//TODO 爬取子页面，即文章详情页
					}
				}
			}
		}
	}

}
