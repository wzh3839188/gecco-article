/**
 * 
 */
package com.wz.article.pipeline;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;

/**
 * 最普通的打印信息的pipeline
 * @author jade
 *
 */
@Service("consolePipeline")
public class ConsolePipeline implements Pipeline<SpiderBean> {

	@Override
	public void process(SpiderBean bean) {
		System.out.println(JSON.toJSONString(bean));
	}

}
