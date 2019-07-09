package cn.bdqn.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 用于JPA的工具包
 */
public class JPAUtil {
    private static EntityManagerFactory factory;
    static {
        //加载配置文件
        factory = Persistence.createEntityManagerFactory("myJpa");

    }
    //获取实体类对象
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
