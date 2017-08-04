/**   
* @Title: jsonTest.java 
* @Package cn.itcast.ssm.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017-8-4 下午4:38:53 
* @version V1.0   
*/
package cn.itcast.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.ItemsCustom;

/** 
 * @ClassName: jsonTest 
 * @Description: json交互测试
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-8-4 下午4:38:53 
 *  
 */
@Controller
public class jsonTest {
	
	//请求json串（商品信息），输出json（商品信息）
	//@RequestBody将请求的商品信息的json串转换成ItemsCustom对象
	//@ResponseBody将itemsCustom转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		
		//@ResponseBody将itemsCustom转成json输出
		return itemsCustom;		
	}
	
	//请求key/value,输出json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
		
		//@ResponseBody将itemsCustom转成json输出
		return itemsCustom;		
	}

}
