package cn.bdqn;


import cn.bdqn.dao.CityDao;
import cn.bdqn.dao.FlightDao;
import cn.bdqn.entity.City;
import cn.bdqn.entity.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//这个类spring里面所有的东西都可以使用
@RunWith(SpringJUnit4ClassRunner.class)//声明这个类是spring的测试类
//加载配置文件 classpath:根目录
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Demo {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private FlightDao flightDao;

    //添加航班信息
    @Test
    public void insert(){
        Flight flight = new Flight();
        flight.setFlightNo("237");
        flight.setDepartureCity("广州");
        flight.setDepartureTime("2019-10-10 20:20:20");
        flight.setArrivalCity("成都");
        flight.setArrivalTime("2019-10-11 02:20:20");
        flightDao.save(flight);
    }

    //查询所有城市信息
    @Test
    public void findAll(){
         List<City> list = cityDao.findAll();
        for (City city : list) {
            System.out.println(city.getCityName());
        }
    }

    //根据起飞城市ID和到达城市ID查询航班信息
    @Test
    public void findByDeparAndArrival(){
        Flight list = flightDao.findBycity("%拉%");
        Flight list2 = flightDao.findBycity2("%乌%");
        System.out.println(list);
//        System.out.println(list2);
//        if(list.equals(list2)){
//            List<Flight> list3 = flightDao.findByFlightNo(list.getFlightNo());
//            for (Flight flight : list3) {
//                System.out.println(flight);
//            }
//        }



    }
    //根据航班编号查询航班记录数
    @Test
    public void countByNo(){
        List<Flight> list = flightDao.findByFlightNo("11666");
        for (Flight flight : list) {
            System.out.println(flight);
        }
    }


}
