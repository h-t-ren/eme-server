/**
 * 
 */
package com.huihuan.eme.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huihuan.eme.domain.page.EMEUser;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午9:58:43
 *
 */
@RestController
public class RestTest {
	
	@RequestMapping("/restTest")
	public EMEUser restTest()
	{
		EMEUser user = new EMEUser();
		user.setUsername("user");
		user.setPassword("password");
		return user;
	}

}
