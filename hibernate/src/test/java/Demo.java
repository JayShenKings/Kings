import cn.bdqn.pojo.Customer;
import cn.bdqn.utils.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class Demo {

    //使用工具类保存一条数据
    @org.junit.Test
    public void demo() {
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();
        //把数据保存到数据库中
        Customer customer = new Customer();
        customer.setCustName("237");
        //保存操作
        em.persist(customer);
        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }

    //使用工具类删除一条数据
    @Test
    public void del() {
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();
        //把数据保存到数据库中
        Customer customer = em.find(Customer.class,2L);
        //保存操作
        em.remove(customer);
        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }

    //使用工具类修改一条数据
    @Test
    public void update() {
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();
        //把数据保存到数据库中
        Customer customer = new Customer();
        customer.setCustName("237-123");
        customer.setCustId(2L);
        //保存操作
        em.merge(customer);
        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }

    //立即加载
    @Test
    public void findId(){
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();

        //em.find(  查询后返回什么条件，查询条件);
        Customer customer = em.find(Customer.class,1L);

        //提交事务
        tx.commit();
        System.err.println(customer);
        //释放资源
        em.close();
    }

    //缓存问题
    @Test
    public void findId2(){
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();

        //em.find(  查询后返回什么条件，查询条件);
        Customer customer = em.find(Customer.class,1L);
        Customer customer2 = em.find(Customer.class,1L);
        //提交事务
        tx.commit();
        System.err.println(customer==customer2);
        System.err.println(customer);
        //释放资源
        em.close();
    }

    //延迟加载
    @Test
    public void findId3(){
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();

        //em.find(  查询后返回什么条件，查询条件);
        Customer customer = em.getReference(Customer.class,1L);
        //提交事务
        tx.commit();
        System.err.println("+++++++++++++++++++++++++++");
        System.err.println(customer);
        //释放资源
        em.close();
    }
    //查询全部
    @Test
    public void findAll(){
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();
        //创建query对象
        String jpql = " from  Customer";
        Query query = em.createQuery(jpql);
        //查询并得到返回结果
        List list = query.getResultList();//得到集合返回类型
        for (Object o : list) {
            System.err.println(o);
        }
        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }
    //分页查询
    @Test
    public void findPaged(){
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();
        //创建query对象
        String jpql = "from Customer ";
        Query query = em.createQuery(jpql);
        //起始索引
        query.setFirstResult(0);
        //每页显示条数
        query.setMaxResults(2);
        //查询并得到返回结果
        List list = query.getResultList();//得到集合返回类型
        for (Object o : list) {
            System.err.println(o);
        }
        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }
    //条件查询
    @Test
    public void findByName() {
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();
        //创建query对象
        String jpql = "from Customer where custName like ?";
        Query query = em.createQuery(jpql);
        ////对占位符赋值，从1开始
        query.setParameter(1,"%2%");
        //查询并得到返回结果
        List list = query.getResultList();//得到集合返回类型
        for (Object o : list) {
            System.err.println(o);
        }
        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }
    //排序查询
    @Test
    public void testOrder(){
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();
        //创建query对象
        String jpql = "from Customer order by custId desc";
        Query query = em.createQuery(jpql);
        //查询并得到返回结果
        List list = query.getResultList();
        for (Object o : list) {
            System.err.println(o);
        }
        //提交事务
        tx.commit();
        //释放资源
        em.close();
    }
    //统计查询
    @Test
        public void count(){
        //获取实体管理类对象
        EntityManager em = JPAUtil.getEntityManager();
        //获取事务
        EntityTransaction tx = em.getTransaction();
        //开启事务
        tx.begin();
        //创建query对象
        String jpql = "select count(custId) from Customer";
        Query query = em.createQuery(jpql);
        //查询并得到返回结果
        Object object = query.getSingleResult();
        System.err.println(object);
        //提交事务
        tx.commit();
        //释放资源
        em.close();

    }
}
