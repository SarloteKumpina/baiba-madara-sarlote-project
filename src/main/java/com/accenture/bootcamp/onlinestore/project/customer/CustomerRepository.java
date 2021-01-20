package com.accenture.bootcamp.onlinestore.project.customer;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import static com.accenture.bootcamp.onlinestore.project.orders.OrderTableSql.CREATE_CUSTOMER;
@Mapper
public interface CustomerRepository {

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(CREATE_CUSTOMER)
    void insert(Customer customer);
}
