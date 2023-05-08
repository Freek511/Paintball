package freek.paintball.Entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class PlayGround {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pdID")
    private Long pgID;

    @Column(name="name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "area")
    private Integer area;

    @Column(name = "maxPeople")
    private Integer maxPeople;

    @OneToMany(mappedBy = "playground")
    private List<Order> orderList;

    public PlayGround(){}

}
