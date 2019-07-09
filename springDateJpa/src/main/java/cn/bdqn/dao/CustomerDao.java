package cn.bdqn.dao;

import cn.bdqn.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//JpaRepository:代表增删改查的基本操作，里面封装都是最基本的方法
//JpaSpecificationExecutor:代表的是复杂的查询，比如分页
public interface CustomerDao
        extends JpaRepository<Customer,Long> ,
        JpaSpecificationExecutor<Customer> {

    //@Query 使用jpql的方式查询。
    @Query(value="from Customer")
    public List<Customer> findAll();

    //@Query 使用jpql的方式查询。?1代表参数的占位符，其中1对应方法中的参数索引
    @Query(value="from Customer where custName = ?1")
    public List<Customer> findByName(String custName);

    //@Query 使用jpql的方式查询。?1代表参数的占位符，其中1对应方法中的参数索引
    @Query(value="from Customer where custName like ?1 and custAddress like ?2")
    public List<Customer> findByNameAndAddress(String custName,String custAddress);

    @Query(value="update Customer set custName = ?1 where custId = ?2")
    @Modifying //操作标识为修改查询
    @Transactional
    public void updateCustomer(String custName,Long custId);


}

