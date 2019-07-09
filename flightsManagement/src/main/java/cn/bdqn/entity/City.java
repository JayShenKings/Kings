package cn.bdqn.entity;

        import javax.persistence.*;

@Entity//声明实体类
@Table(name="city") //建立实体类和表的映射关系
public class City {

    @Id//声明当前私有属性为主键
    @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略
    @Column(name="id") //指定和表中id字段的映射关系
    private Long id;

    @Column(name="city_name") //指定和表中city_name字段的映射关系
    private String cityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
