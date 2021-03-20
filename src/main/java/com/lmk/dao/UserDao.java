package com.lmk.dao;

import com.lmk.entity.User;
import com.lmk.qo.UserNo;
import com.lmk.qo.UserQo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @auth: lmk
 * @Description:
 * @date: 2021/3/10
 */
@MapperScan
public interface UserDao {

    List<User> selectAll(UserQo userQo);

    List<User> selectNameAndPassword(UserNo userNo);

    int getCount(UserQo userQo);

    int delete(@Param("id") Integer id);

    int add(User user);

    User toUpdate(@Param("id") Integer id);


    int update(User user);
}
