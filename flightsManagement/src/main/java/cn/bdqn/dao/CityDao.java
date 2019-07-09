package cn.bdqn.dao;

import cn.bdqn.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityDao extends JpaRepository<City,Long>, JpaSpecificationExecutor<City> {
}
