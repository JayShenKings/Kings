package cn.bdqn.dao;

import cn.bdqn.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FlightDao extends JpaRepository<Flight,Long>, JpaSpecificationExecutor<Flight>    {

    //@Query 使用jpql的方式查询。
    @Query(value = "from Flight where flightNo = ?1")
    public List<Flight> findByFlightNo(String flightNo);

    //@Query 使用jpql的方式查询。
    @Query(value = "select flight_no from flight as f,city as c where f.departure_city = c.id and c.city_name like ?1",nativeQuery=true)
    public Flight findBycity(String departureCity);
    //@Query 使用jpql的方式查询。
    @Query(value = "select flight_no from flight as f,city as c where f.arrival_city = c.id and c.city_name like ?2",nativeQuery=true)
    public Flight findBycity2(String arrivalCity);
}
