package cn.itcast.ssm.po; 
/** 
 * @ClassName: ItemsQueryVo 
 * @Description: ��Ʒ��װ����
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-7-22 ����6:56:46 
 */
public class ItemsQueryVo {
	
	//��Ʒ��Ϣ
	private Items items;
	
	//Ϊ��ϵͳ�Ŀ���չ�ԣ���ԭʼ���ɵ�po������չ
	private ItemsCustom itemsCustom;

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
 