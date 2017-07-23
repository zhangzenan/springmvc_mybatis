package cn.itcast.ssm.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

/** 
 * @ClassName: ItemsServiceImpl 
 * @Description: 商品管理Service实现
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-7-22 下午10:44:25 
 */

public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom; 	

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// 通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

}
 