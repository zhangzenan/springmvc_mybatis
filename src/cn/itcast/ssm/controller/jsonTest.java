/**   
* @Title: jsonTest.java 
* @Package cn.itcast.ssm.controller 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author A18ccms A18ccms_gmail_com   
* @date 2017-8-4 ����4:38:53 
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
 * @Description: json��������
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-8-4 ����4:38:53 
 *  
 */
@Controller
public class jsonTest {
	
	//����json������Ʒ��Ϣ�������json����Ʒ��Ϣ��
	//@RequestBody���������Ʒ��Ϣ��json��ת����ItemsCustom����
	//@ResponseBody��itemsCustomת��json���
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		
		//@ResponseBody��itemsCustomת��json���
		return itemsCustom;		
	}
	
	//����key/value,���json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
		
		//@ResponseBody��itemsCustomת��json���
		return itemsCustom;		
	}

}
