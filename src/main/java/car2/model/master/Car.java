package car2.model.master;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue
    private UUID id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "car_type")
//    private Lookup carType; //CAR_TYPE

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tier")
//    private Lookup tier;    //TIER

    private String carType;

    private String tier;

    private String issueDate;

    private Integer distance;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "gear_system")
//    private Lookup gearSystem; //GEAR_SYSTEM

    private String gearSystem;

    private String registrationYear;

    private Integer capacity;
//    private String img;

    private String color;


}
