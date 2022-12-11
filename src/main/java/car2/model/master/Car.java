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

    @Lob
    private String img;

    private String color;

    private double price;

    private String status;

    private String customerName;

    private String customerPhone;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getGearSystem() {
        return gearSystem;
    }

    public void setGearSystem(String gearSystem) {
        this.gearSystem = gearSystem;
    }

    public String getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
