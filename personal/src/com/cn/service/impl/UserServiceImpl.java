// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.service.impl;

import com.cn.pojo.Teach;
import com.cn.pojo.Admin;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.cn.pojo.User;
import javax.annotation.Resource;
import com.cn.dao.IUserDao;
import org.springframework.stereotype.Service;
import com.cn.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService
{
    @Resource
    private IUserDao userDao;
    @Resource
    private IUserService userService;
    SimpleDateFormat df;
    
    public UserServiceImpl() {
        this.df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    @Override
    public User userLogin(final String account, final String pwd) {
        return this.userDao.userLogin(account, pwd);
    }
    
    @Override
    public List<Map<String, Object>> findUserByAccount(final String account) {
        return this.userDao.findUserByAccount(account);
    }
    
    @Override
    public List<Map<String, Object>> findClass() {
        return this.userDao.findClass();
    }
    
    @Override
    public List<Map<String, Object>> findSeTeach(final Integer id) {
        return this.userDao.findSeTeach(id);
    }
    
    @Override
    public void chooseTeach(final Integer id, final Integer cid, final Integer uid) {
        this.userDao.chooseTeach(id, cid, uid);
    }
    
    @Override
    public Admin adminLogin(final String name, final String pwd) {
        return this.userDao.adminLogin(name, pwd);
    }
    
    @Override
    public void setTime(String name,final String format) {
        this.userDao.setTime(name,format);
    }
    
    @Override
    public List<Map<String, Object>> countUser() {
        return this.userDao.countUser();
    }
    
    @Override
    public List<Map<String, Object>> countTeach() {
        return this.userDao.countTeach();
    }
    
    @Override
    public List<User> getSex() {
        return this.userDao.getSex();
    }
    
    @Override
    public List<Map<String, Object>> findUser() {
        return this.userDao.findUser();
    }
    
    @Override
    public List<Map<String, Object>> teachTable(String tname) {
        return this.userDao.teachTable(tname);
    }
    
    @Override
    public List<Map<String, Object>> apparatusTable() {
        return this.userDao.apparatusTable();
    }
    
    //查询股票涨跌情况
    @Override
    public List<Map<String, Object>> stocksituation() {
    	return this.userDao.stocksituation();
    }
    
    @Override
    public List<Map<String, Object>> countApparatus() {
        return this.userDao.countApparatus();
    }
    
    @Override
    public List<User> findAccount(final String account) {
        return this.userDao.findAccount(account);
    }
    
    @Override
    public void registerUser(final User user) {
        this.userDao.registerUser(user);
    }
    
    @Override
    public void delUser(final Integer id) {
        this.userDao.delUser(id);
    }
    
    @Override
    public void addTeachInfo(final Teach teach) {
        this.userDao.addTeachInfo(teach);
    }
    
    @Override
    public void delTeach(final Integer id) {
        this.userDao.delTeach(id);
    }
    
    @Override
    public void upTeach(final Integer id, final String tname, final Integer cid, final String ttel, final String taddress) {
        this.userDao.upTeach(id, tname, cid, ttel, taddress);
    }
    
    @Override
    public void chooseClass(final String username, final Integer cid) {
        this.userDao.chooseClass(username, cid);
    }
    
    @Override
    public void updateUserInfo(final Integer id, final String account, final Integer sex, final Integer age, final String name, final String pwd, final String tel, final String address) {
        this.userDao.updateUserInfo(id, account, sex, age, name, pwd, tel, address);
    }
    
    //添加股票
    @Override
    public void addStockInfo(final String aname,final String stockcode,final String rise,final String fall) {
        this.userDao.addStockInfo(aname,stockcode,rise,fall,this.df.format(new Date()));
    }
    
    //删除股票信息
    @Override
    public void delStock(final Integer id) {
        this.userDao.delStock(id);
    }
    
    //更改股票信息
    @Override
    public void updateStockInfo(final Integer id, final String name, final String stockcode, final Integer rise, final Integer fall, final Integer result) {
        this.userDao.updateStockInfo(id, name, stockcode, rise, fall, result, this.df.format(new Date()));
    }
}
