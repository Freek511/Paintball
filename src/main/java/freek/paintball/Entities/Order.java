package freek.paintball.Entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderID;

    @Column(name = "OrderDate")
    private String orderDate;

    @Column(name = "playtime")
    private Integer playTime;

    @Column(name = "People")
    private Integer people;

    @Column(name = "OrderPrice")
    private Integer orderPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pgID")
    private PlayGround playGround;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userID")
    private User user;

    public Order(){}

    public Order(Long orderID,
                 String orderDate,
                 Integer playTime,
                 Integer people,
                 PlayGround playGround,
                 User user) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.playTime = playTime;
        this.people = people;
        this.playGround = playGround;
        this.user = user;
        this.orderPrice = playGround.getPrice() + people * 1500;
    }
}
