// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.pojo;

import java.math.BigDecimal;

public class Teach
{
    Integer id;
    String tname;
    String ttel;
    String taddress;
    Integer cid;
    String cname;
    BigDecimal cprice;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getTname() {
        return this.tname;
    }
    
    public void setTname(final String tname) {
        this.tname = tname;
    }
    
    public String getTtel() {
        return this.ttel;
    }
    
    public void setTtel(final String ttel) {
        this.ttel = ttel;
    }
    
    public String getTaddress() {
        return this.taddress;
    }
    
    public void setTaddress(final String taddress) {
        this.taddress = taddress;
    }
    
    public Integer getCid() {
        return this.cid;
    }
    
    public void setCid(final Integer cid) {
        this.cid = cid;
    }

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public BigDecimal getCprice() {
		return cprice;
	}

	public void setCprice(BigDecimal cprice) {
		this.cprice = cprice;
	}	
    
}
