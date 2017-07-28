/**   
 * @Title: CustomDateConverter.java 
 * @Package cn.itcast.ssm.controller.converter 
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2017-7-28 ����2:13:12 
 * @version V1.0   
 */
package cn.itcast.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @ClassName: CustomDateConverter
 * @Description: �Զ�������ת��
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-7-28 ����2:13:12
 * 
 */
public class CustomDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {

		// ʵ�ֽ����ڴ�ת��Ϊ�������ͣ���ʽyyyy-MM-dd HH:mm:ss��
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			//ת��ֱ�ӷ���
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���������ʧ�ܷ���null
		return null;
	}

}
