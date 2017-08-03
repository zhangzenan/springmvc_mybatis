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
 * @Description: ��Ʒ����Serviceʵ��
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-7-22 ����10:44:25
 */

public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// ͨ��ItemsMapperCustom��ѯ���ݿ�
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);

		if (items == null) {
			throw new CustomException("�޸ĵ���Ʒ��Ϣ�����ڣ�");
		}

		// �м����Ʒ��Ϣ����ҵ����
		// ...
		// ����ItemsCustom
		ItemsCustom itemsCustom = null;
		// ��items������ֵ������itemsCustom
		if (items != null) {
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}

		return itemsCustom;
	}

	// �޸���Ʒ��Ϣ
	@Override
	public void UpdateItems(Integer id, ItemsCustom itemsCustom)
			throws Exception {
		// ���ҵ��У�飬ͨ����service�ӿڶԹؼ���������У��
		// У��id�Ƿ�Ϊ�գ����Ϊ���׳��쳣

		// ������Ʒ��Ϣʹ��updateByPrimaryKeyWithBLOBs����id����items���������ֶΣ��������ı������ֶ�
		// updateByPrimaryKeyWithBLOBsҪ����봫��id
		// �����򹤳���û������updateByPrimaryKeyWithBLOBs����������

		Items items = new Items();
		BeanUtils.copyProperties(itemsCustom, items);
		items.setId(id);
		itemsMapper.updateByPrimaryKey(items);
	}

}
