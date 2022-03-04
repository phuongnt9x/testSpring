package com.example.testspring.model;

import javax.persistence.*;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Entity
@Table
public class Promotion implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private Date startTime;
    @NotEmpty
    private Date endTime;
    @NotEmpty
    private int discountRate;
    @NotEmpty
    private String detail;

    public Promotion() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Promotion(String title, Date startTime, Date endTime, int discountRate, String detail) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discountRate = discountRate;
        this.detail = detail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Promotion.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Promotion promotion = (Promotion) target;
        Date currentTime=new Date();
        Date startTime = promotion.getStartTime();
        ValidationUtils.rejectIfEmpty(errors, "startTime", "number.empty");
        if (startTime>currentTime){
            errors.rejectValue("startTime", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }

    }
}
