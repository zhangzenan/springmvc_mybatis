/**   
 * @Title: CustomDateConverter.java 
 * @Package cn.itcast.ssm.controller.converter 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2017-7-28 下午2:13:12 
 * @version V1.0   
 */
package cn.itcast.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @ClassName: CustomDateConverter
 * @Description: 自定义日期转换
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-7-28 下午2:13:12
 * 
 */
public class CustomDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {

		// 实现将日期串转换为日期类型（格式yyyy-MM-dd HH:mm:ss）
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			//转成直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果参数绑定失败返回null
		return null;
	}

}
