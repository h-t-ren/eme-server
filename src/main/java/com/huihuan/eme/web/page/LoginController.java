/**
 * 
 */
package com.huihuan.eme.web.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:38:36
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login()
	{
		return "/login";
	}

}
