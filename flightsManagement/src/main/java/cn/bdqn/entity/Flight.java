package cn.bdqn.entity;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略
    @Column(name="id") //指定和表中id字段的映射关系
    private Long id;

    @Column(name="flight_no") //指定和表中id字段的映射关系
    private String flightNo;

    @Column(name="departure_city") //指定和表中id字段的映射关系
    private String departureCity;

    @Column(name="departure_time") //指定和表中id字段的映射关系
    private String departureTime;

    @Column(name="arrival_city") //指定和表中id字段的映射关系
    private String arrivalCity;

    @Column(name="arrival_time") //指定和表中id字段的映射关系
    private String arrivalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
}
