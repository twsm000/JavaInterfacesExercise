package model.entities;

import java.util.Date;

public class Contract {
    private Integer number;
    private Date date;
    private Double totalValue;

    public Contract() {
    }

    public Contract(Integer number, Date date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    public Double getTotalValue() {
        return totalValue;
    }
}
