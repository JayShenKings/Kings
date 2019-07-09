package cn.bdqn;

import cn.bdqn.dao.CustomerDao;
import cn.bdqn.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {

    @Autowired
    private CustomerDao dao;

    @Test
    public void findAll(){
        List<Customer> list = dao.findAll();
        for (Customer customer : list) {
            System.err.println(customer);
        }
    }

    @Test
    public void findByName(){
        List<Customer> list = dao.findByName("123");
        for (Customer customer : list) {
            System.err.println(customer);
        }
    }

    @Test
    public void findByNameAndAddress(){
        List<Customer> list = dao.findByNameAndAddress("%2%","%2%");
        for (Customer customer : list) {
            System.err.println(customer);
        }
    }

    @Test
    //update(没什么人用)
    public void update(){
        dao.updateCustomer("123",2L);
    }


}
