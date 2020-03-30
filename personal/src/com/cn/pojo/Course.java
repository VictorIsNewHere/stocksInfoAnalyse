// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.pojo;

import java.math.BigDecimal;

public class Course
{
    Integer id;
    String cname;
    BigDecimal price;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getCname() {
        return this.cname;
    }
    
    public void setCname(final String cname) {
        this.cname = cname;
    }

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}   
    
}
