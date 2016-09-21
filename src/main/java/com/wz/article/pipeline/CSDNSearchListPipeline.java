/**
 * 
 */
package com.wz.article.pipeline;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.wz.article.crawler.CSDNSearchPage;
import com.wz.article.entity.CSDNArticleListEntity;
import com.wz.article.model.ArticleModel;
import com.wz.article.service.ArticleBriefService;

/**
 * @author jade
 *
 */
@Service("CSDNSearchListPipeline")
public class CSDNSearchListPipeline implements Pipeline<CSDNSearchPage> {

	@Resource(name="articleBriefServiceImpl")
	private ArticleBriefService articleBriefService;
	
	@Override
	public void process(CSDNSearchPage bean) {
		List<CSDNArticleListEntity> articleList = bean.getArticleList();
		if(articleList != null){
			for(CSDNArticleListEntity entity : articleList){
				if(entity.getArticleTitle() != null 
						&& entity.getArticleAccessInfo() != null
						&& entity.getArticleAccessInfo().contains("浏览")){
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
