package car2.model.master;

import car2.model.security.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Sale {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_car_id")
    private Car refCarId;

    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_status_id")
    private Lookup refStatusId;  //SALE_STATUS

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_user_id")
    private User refUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_customer_id")
    private User refCustomerId;

    private LocalDate soldDate;



}
