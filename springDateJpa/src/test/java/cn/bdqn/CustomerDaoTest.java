package cn.bdqn;

import cn.bdqn.dao.CustomerDao;
import cn.bdqn.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//这个类spring里面所有的东西都可以使用
@RunWith(SpringJUnit4ClassRunner.class)//声明这个类是spring的测试类
//加载配置文件 classpath:根目录
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {
    //注入dao
    @Autowired
    private CustomerDao customerDao;

    //保存客户数据到数据库
    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setCustName("Hello,KuGou");
        customerDao.save(customer);
    }
    //修改id为5的数据

    /**
     * save:同时可以更新或者插入
     * 如果传入的对象没有id值，那就执行插入的方法，如果传入的对象有id值那就自行更新
     */
    @Test
    public void testSave2(){
        //获取id为5的数据
        Customer customer = customerDao.findOne(5L);
        System.out.println("---------------------------");
        customer.setCustName("hahahahahahaha");
        //save 执行更新之前会查询数据库 如果查询的数据和更新的数据一样，就不会执行更新
        customerDao.save(customer);
    }
    //根据id删除
    @Test
    public void testDelete(){
        customerDao.delete(10L);
    }

    //根据id查询数据
    @Test
    public  void findById(){
        System.err.println(customerDao.findOne(6L));
    }

    //查询全部
    @Test
    public  void findAll(){
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer.getCustName());
        }
    }

    //使用spring-data-jpa实现延迟加载
    //需求：使用延迟加载技术实现通过id查询客户信息
    @Test
    @Transactional//事务可以防止延迟加载的时候错误
    public void getById(){
        //getOne：使用延迟加载的方式，通过Id查询数据库
        Customer customer = customerDao.getOne(2L);
        System.out.println("------------------------");
        System.err.println(customer);
    }


}
