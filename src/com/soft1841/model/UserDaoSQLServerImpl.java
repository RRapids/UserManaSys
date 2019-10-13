package com.soft1841.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDaoSQLServerImpl extends JDBCUtil implements userDao {
    @Override
    public boolean findUser(User user) {
        Boolean flag = false;
        String sql = "select * from users where username=? and password=?";
        Object[] params = {user.getUsername(), user.getPassword()};
        this.executeQuery(sql, params);
        List<HashMap> listUser = new ArrayList<>();
        listUser = this.executeQuery(sql, params);
        if (listUser.size() > 0) {
            flag = true;
        }
        return flag;

    }

    @Override
    public int insert(User user) {
        String sql = "insert into users(username,password,email,grade) VALUES(?,?,?,?)";
        Object[] params = {user.getUsername(), user.getPassword(), user.getEmail(), user.getGrade()};
        return this.executeUpdate(sql, params);
    }

    @Override
    public int delete(int id) {
        String sql = "delete from users where userId=?";
        Object[] params = {id};
        int n = this.executeUpdate(sql, params);
        return n;
    }

    @Override
    public int searchCount() {
        int rowCount = 0;
        int pageSize = 3;
        int pageCount;
        List<HashMap> list = new ArrayList<>();
        String sql = "select * from users";
        list = this.executeQuery(sql, null);
        rowCount = list.size();
        if (rowCount % pageSize == 0) {
            pageCount = rowCount / pageSize;
        } else {
            pageCount = rowCount / pageSize + 1;
        }
        return pageCount;
    }

    @Override
    public List<HashMap> search(int pageSize, int epageSize) {
        List<HashMap> lists = new ArrayList<>();
        String sql = "select * from users limit ?,?";
        Object[] params = {pageSize, epageSize};
        lists = this.executeQuery(sql, params);
        return lists;
    }

    @Override
    public int update(User user) {
        String sql = "update users set username=?,password=?,email=?,grade=?";
        Object[] params = {user.getUsername(), user.getPassword(), user.getEmail(), user.getGrade()};
        return this.executeUpdate(sql, params);
    }
}
