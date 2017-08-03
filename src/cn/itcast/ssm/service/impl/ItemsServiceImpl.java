package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
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

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// 通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);

		if (items == null) {
			throw new CustomException("修改的商品信息不存在！");
		}

		// 中间对商品信息就行业务处理
		// ...
		// 返回ItemsCustom
		ItemsCustom itemsCustom = null;
		// 将items的属性值拷贝到itemsCustom
		if (items != null) {
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}

		return itemsCustom;
	}

	// 修改商品信息
	@Override
	public void UpdateItems(Integer id, ItemsCustom itemsCustom)
			throws Exception {
		// 添加业务校验，通常在service接口对关键参数进行校验
		// 校验id是否为空，如果为空抛出异常

		// 根据商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括大文本类型字段
		// updateByPrimaryKeyWithBLOBs要求必须传入id
		// 此逆向工程中没有生成updateByPrimaryKeyWithBLOBs方法？？？

		Items items = new Items();
		BeanUtils.copyProperties(itemsCustom, items);
		items.setId(id);
		itemsMapper.updateByPrimaryKey(items);
	}

}
