package com.example.datebase.demo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
public interface OrderService {
    void insertOne(DataSource dataSource, String sql);
    List<Map<String, Object>> query(DataSource dataSource, String sql);
}