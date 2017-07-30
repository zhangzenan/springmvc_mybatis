package cn.itcast.ssm.po; 

import java.util.List;

/** 
 * @ClassName: ItemsQueryVo 
 * @Description: 商品包装对象
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-7-22 下午6:56:46 
 */
public class ItemsQueryVo {
	
	//商品信息
	private Items items;
	
	//为了系统的可扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;
	
	//批量商品信息
	private List<ItemsCustom> itemsList;

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

}
 