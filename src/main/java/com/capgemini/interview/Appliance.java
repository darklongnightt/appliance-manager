package com.capgemini.interview;

// import java.time.format.DateTimeFormatter;  
// import java.time.LocalDateTime; 
import java.util.UUID;

public class Appliance {
    private String id;
    private String serialNum;
    private String brand;
    private String model;
    private String status;
    private String dateBought;
    // private DateTimeFormatter dtf;

    public Appliance(String serialNum, String brand, String model, String status, String dateBought) {
        // this.dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        this.id = UUID.randomUUID().toString();
        this.serialNum = serialNum;
        this.brand = brand;
        this.model = model;
        this.status = status;
        this.dateBought = dateBought; 
    }

    /* Get unique identifier consisting of <serialNum,brand,model> */
    public String getIdentifier() {
        return String.format("%s,%s,%s", this.serialNum, this.brand, this.model);
    }

    /* Getter methods */
    public String getId() {
        return this.id;
    }

    public String getSerialNum() {
        return this.serialNum;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public String getStatus() {
        return this.status;
    }

    public String getDateBought() {
        return this.dateBought;
    }

    /* Setter methods */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateBought(String dateBought) {
        this.dateBought = dateBought;
    }

    /* Set all fields */
    public void update(Appliance newAppliance) {
        this.serialNum = newAppliance.serialNum;
        this.brand = newAppliance.brand;
        this.model = newAppliance.model;
        this.status = newAppliance.status;
        this.dateBought = newAppliance.dateBought;
    }
}