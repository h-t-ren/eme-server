/**
 * 
 */
package com.huihuan.eme;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:58:43
 *
 */
@RestController
public class RestTest {
	
	@RequestMapping("/restTest")
	public WSUser restTest()
	{
		WSUser user = new WSUser();
		user.setUsername("user");
		user.setPassword("password");
		return user;
	}

}
