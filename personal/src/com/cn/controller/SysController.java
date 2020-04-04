// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.controller;

import com.cn.pojo.Teach;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import com.cn.pojo.User;
import java.util.Map;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import javax.servlet.http.HttpSession;
import com.cn.pojo.Admin;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import com.cn.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/sys" })
public class SysController
{
    @Resource
    private IUserService userService;
    SimpleDateFormat df;
    
    public SysController() {
        this.df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    @ResponseBody
    @RequestMapping({ "/loginAdmin" })
    public String toIndex(Admin admin, final HttpSession session) {
    	String name=admin.getName();
        admin = this.userService.adminLogin(admin.getName(), admin.getPwd());
        if (admin != null) {
            session.setAttribute("lastLoginTime", (Object)admin.getLastlogintime());
            session.setAttribute("account", (Object)"123");
            this.userService.setTime(name, this.df.format(new Date()));
            return "true";
        }
        return "false";
    }
    
    @RequestMapping({ "/userTable" })
    public String userTable(final HttpSession session) {
        final List<Map<String, Object>> findUserList = this.userService.findUser();
        session.setAttribute("findUserList", (Object)findUserList);
        return "sys/userTable";
    }
    
    @RequestMapping({ "/teachTable" })
    public String teachTable(Teach teach,final HttpSession session) {
        final List<Map<String, Object>> findUserList = this.userService.teachTable(teach.getTname());
        session.setAttribute("findTeachList", (Object)findUserList);
        session.setAttribute("tname", teach.getTname());
        return "sys/teachTable";
    }
    
    @RequestMapping({ "/exit" })
    public String exit(final HttpSession session) {
        session.invalidate();
        return "login";
    }
    
    @ResponseBody
    @RequestMapping({ "/getSex" })
    public List<User> getSex() {
        final List<User> list = this.userService.getSex();
        return list;
    }
    
    @ResponseBody
    @RequestMapping({ "/delUser" })
    public String delUser(final Integer id) {
        this.userService.delUser(id);
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/delTeach" })
    public String delTeach(final Integer id) {
        if (id != 12) {
            this.userService.delTeach(id);
        }
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/loginForwardAdmin" })
    public String loginForwardAdmin() {
        return "true";
    }
    
    @RequestMapping({ "/upUser" })
    public String upUser(final Integer id, final String account, final Integer sex, final Integer age, final String name, final String pwd, final String tel, final String address, final HttpSession session) {
        String str = null;
        String str2 = null;
        str = new String(name);
        str2 = new String(address);
        final List<Object> list = new ArrayList<Object>();
        list.add(id);
        list.add(account);
        list.add(sex);
        list.add(age);
        list.add(str);
        list.add(pwd);
        list.add(tel);
        list.add(str2);
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
        session.setAttribute("upList", (Object)list);
        return "sys/upUser";
    }
    
    @RequestMapping({ "/upTeach" })
    public String upTeach(final Integer id, final String tname, final Integer cid, final String ttel, final String taddress, final HttpSession session) {
        final List<Object> list = new ArrayList<Object>();
        list.add(id);
        list.add(tname);
        list.add(cid);
        list.add(ttel);
        list.add(taddress);
        session.setAttribute("upTeachList", (Object)list);
        return "sys/upTeach";
    }
    
    @ResponseBody
    @RequestMapping({ "/registerUser" })
    public String registerUser(final User user) {
        final List<User> id = this.userService.findAccount(user.getAccount());
        if (id.size() != 0) {
            return "false";
        }
        user.setUclass(1);
        user.setUteach(12);
        this.userService.registerUser(user);
        return "true";
    }
    
    @RequestMapping({ "/addUser" })
    public String addUser() {
        return "sys/addUser";
    }
    
    @RequestMapping({ "/addTeach" })
    public String addTeach() {
        return "sys/addTeach";
    }
    
    @ResponseBody
    @RequestMapping(value = { "/upTeachInfo" }, method = { RequestMethod.POST })
    public String upTeach(final Integer id, final String tname, final Integer cid, final String ttel, final String taddress) {
        this.userService.upTeach(id, tname, cid, ttel, taddress);
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/addTeachInfo" })
    public String addTeachInfo(final Teach teach) {
        this.userService.addTeachInfo(teach);
        return "true";
    }
    
    @RequestMapping({ "/JumpUserSearch" })
    public String jumpUserSearch() {
        return "true";
    }
    
    //添加股票
    @ResponseBody
    @RequestMapping({ "/addStockInfo" })
    public String addStockInfo(final String aname,final String stockcode,final String rise,final String fall) {
        this.userService.addStockInfo(aname,stockcode,rise,fall);
        return "true";
    }
    
    //不查询信息，直接跳转到添加股票界面
	@RequestMapping({ "/addStock" })
	public String addStock() {
	    return "sys/addStock";
	}
	
    //删除股票信息
    @ResponseBody
    @RequestMapping({ "/delStock" })
    public String delStock(final Integer id) {
        this.userService.delStock(id);
        return "true";
    }
    
    //股票涨跌情况查询
    @RequestMapping({ "/stocksituation" })
    public String stocksituation(final HttpSession session) {
        final List<Map<String, Object>> finStockList = this.userService.stocksituation();
        session.setAttribute("findStockList", (Object)finStockList);
        return "sys/stocksituation";
    }
    
    //登陆成功
	@RequestMapping({ "/ForwardAdmin" })
	public String loginForward(final HttpSession session) {
		final List<Map<String, Object>> countApparatusList = this.userService.countApparatus();
		session.setAttribute("countApparatus", (Object) countApparatusList);
		return "sys/main";
	}
	
	//跳转到修改股票信息窗口
	@RequestMapping({ "/upStock" })
	public String upStock(final Integer id, final String name, final String stockcode, final Integer rise, final Integer fall, final HttpSession session) {
	    final List<Object> list = new ArrayList<Object>();
	    list.add(id);
	    list.add(name);
	    list.add(stockcode);
	    list.add(rise);
	    list.add(fall);
	    for (int i = 0; i < list.size(); ++i) {
	        System.out.println(list.get(i));
	    }
	    session.setAttribute("upList", (Object)list);
	    return "sys/upStock";
	}
    
	//修改股票信息
    @ResponseBody
    @RequestMapping({ "/upStockInfo" })
    public String upStockInfo(final Integer id, final String name, final String stockcode, final Integer rise, final Integer fall, final Integer result) {
        this.userService.updateStockInfo(id, name, stockcode, rise, fall, result);
        return "true";
    }
}
