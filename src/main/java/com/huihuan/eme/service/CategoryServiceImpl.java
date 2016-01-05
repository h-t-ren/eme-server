/**
 * 
 */
package com.huihuan.eme.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.huihuan.eme.domain.db.Category;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:12:53
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Override
	public Collection<String> getItemsByCategory(Category cat) {
		  Collection<String> items = new ArrayList<String>();
          return items;
	}

}
