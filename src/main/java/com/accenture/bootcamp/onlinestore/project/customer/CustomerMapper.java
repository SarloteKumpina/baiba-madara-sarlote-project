package com.accenture.bootcamp.onlinestore.project.customer;
import com.accenture.bootcamp.onlinestore.project.checkot.CheckoutForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import static com.accenture.bootcamp.onlinestore.project.orders.OrderTableSql.CREATE_CUSTOMER;

@Mapper
public interface CustomerMapper {

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(CREATE_CUSTOMER)
    void createCustomer(Customer customer);
}
