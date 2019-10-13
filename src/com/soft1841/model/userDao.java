package com.soft1841.model;

import java.util.HashMap;
import java.util.List;

public interface userDao {
    public  boolean findUser(User user);
    public int insert(User user);
    public int delete(int id);
    public int searchCount();//计算一共有多少页
    public List<HashMap> search(int pageSize,int epageSize);
    public int update(User user);

}
