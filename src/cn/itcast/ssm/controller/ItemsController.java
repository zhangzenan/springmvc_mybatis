package cn.itcast.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;

/**
 * @ClassName: ItemsController
 * @Description: 商品Controller
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-7-23 下午12:49:37
 */

@Controller
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	// 商品查询列表
	// @RequestMapping实现对queryItems方法和url进行映射，一个方法对应一个url
	// 一般建议将url和方法写成一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception {

		List<ItemsCustom> itemsList = itemsService.findItemsList(null);	

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request的setAttribut,在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

}
