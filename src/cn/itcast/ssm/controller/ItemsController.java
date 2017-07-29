package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

/**
 * @ClassName: ItemsController
 * @Description: 商品Controller
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-7-23 下午12:49:37
 */

@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问的url是根路径+子路径
//比如：商品列表：/items
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	// 商品查询列表
	// @RequestMapping实现对queryItems方法和url进行映射，一个方法对应一个url
	// 一般建议将url和方法写成一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception {

		//测试forward后request是否可以共享
		
		System.out.println(request.getParameter("id"));
		
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

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

	/**
	 * @Title: editItems
	 * @Description: 商品信息修改页面显示
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	//@RequestMapping("/editItems")
	//限制http请求方法，可以post和get	
/*	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView editItems() throws Exception {

		// 调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(1);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// 将商品信息放到model
		modelAndView.addObject("itemsCustom", itemsCustom);

		// 商品修改页面
		modelAndView.setViewName("items/editItems");

		return modelAndView;
	}*/
	
	//返回String
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	//如果不使用@RequestParam，request传入的参数名称必须和形参的参数名称一致
	//@RequestParam里边指定request传入参数和形参进行绑定
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定
	public String editItems(Model model,@RequestParam(value="id",required=true,defaultValue="1") Integer items_id) throws Exception {

		// 调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
	
		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
		model.addAttribute("itemsCustom",itemsCustom);

		return "items/editItems";
	}

	/**
	 * @Title: editItemsSubmit
	 * @Description: 商品信息修改提交
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom) throws Exception {

		//调用service更新商品信息，页面需要将商品你信息传到此方法
		itemsService.UpdateItems(id, itemsCustom);
		
		//重定向到商品查询列表
		//return "redirect:queryItems.action";
		
		//页面转发
		return "forward:queryItems.action";

	}
	
	//返回json格式数据
	@RequestMapping("/getItemsJson")
	public void getItemsJson(HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charse=utf-8");
		response.getWriter().write("{name:zhangsan}");

	}

}
