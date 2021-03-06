package cn.itcast.ssm.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cn.itcast.ssm.controller.validation.ValidGroup1;

public class Items {
    private Integer id;

    //校验名称在1到30字符中间
    //message是提示校验出错显示的信息
    //groups:此校验属于哪个分组，groups可以定义对个分组
    @Size(min=1,max=30,message="{items.name.length.error}",groups={ValidGroup1.class})
    private String name;

    private String detail;

    private BigDecimal price;
    
    //非空校验
    @NotNull(message="{items.createtime.length.isNULL}")
    private Date createtime;
    
    private String pic;

    public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getId() {
        return id;
    }

    public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}