package com.lmk.qo;

/**
 * @auth: lmk
 * @Description:
 * @date: 2021/3/11
 */
public class UserQo extends Page{
    private String name;
    private String age;
    private String sex;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
