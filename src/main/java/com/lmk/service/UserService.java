package com.lmk.service;

import com.lmk.dao.UserDao;
import com.lmk.entity.User;
import com.lmk.qo.UserNo;
import com.lmk.qo.UserQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @auth: lmk
 * @Description:
 * @date: 2021/3/10
 */
//事务只针对修改操作（添加，修改，删除）,查询没有事务
//@Transactional只能加到service层，不能加到dao和controller
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //查询所有的用户信息
    public List<User> selectAll(UserQo userQo) {
        return userDao.selectAll(userQo);
    }

    public int getCount(UserQo userQo){
        return userDao.getCount(userQo);
    }

    //删除
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        userDao.delete(id);
    }

    //添加
    @Transactional(rollbackFor = Exception.class)
    public void add(User user) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = sdf.format(date);
        user.setCreateTime(formatDate);
        userDao.add(user);
//        int i=1/0;
    }

    //修改
    @Transactional(rollbackFor = Exception.class)
    public User toUpdate(Integer id) {
        return userDao.toUpdate(id);
    }

    //修改
    @Transactional(rollbackFor = Exception.class)
    public void update(User user) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = sdf.format(date);
        user.setCreateTime(formatDate);
        userDao.update(user);
    }

    //查询账户和密码
    @Transactional(rollbackFor = Exception.class)
    public List<User> selectNameAndPassword(UserNo userNo) {

//        List<User> user=userDao.selectNameAndPassword(userNo);
//        if (user==null || user.size()!=1){
//            return false;
//        }else {
//            return true;
//        }
        return userDao.selectNameAndPassword(userNo);
    }

}
