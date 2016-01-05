/**
 * 
 */
package com.huihuan.eme.service;

import java.util.Collection;

import org.springframework.security.access.annotation.Secured;

import com.huihuan.eme.domain.db.Category;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:10:42
 *
 */
public interface CategoryService {
	
	 @Secured("ROLE_USER")
	 Collection<String> getItemsByCategory(Category cat);

}
