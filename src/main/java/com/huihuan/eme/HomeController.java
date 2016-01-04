/**
 * 
 */
package com.huihuan.eme;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */
@Controller
public class HomeController {
	

	private static final Log logger = LogFactory.getLog(EMEWebApplication.class);
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		logger.debug("to home");
		return "index";
	}
}
