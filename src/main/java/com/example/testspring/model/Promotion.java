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
        Date endTime = promotion.getEndTime();
        int discountRate=promotion.getDiscountRate();
        ValidationUtils.rejectIfEmpty(errors, "startTime", "startTime.empty");
        ValidationUtils.rejectIfEmpty(errors, "endTime", "endTime.empty");
        ValidationUtils.rejectIfEmpty(errors, "discountRate", "discountRate.empty");
        ValidationUtils.rejectIfEmpty(errors, "title", "title.empty");
        if (discountRate<10000){
            errors.rejectValue("discountRate", "discountRate.matches");
        }
        if (startTime.compareTo(currentTime)<0){
            errors.rejectValue("startTime", "startTime.wrong");
        }
        if (endTime.compareTo(startTime)<=0){
            errors.rejectValue("endTime", "endTime.wrong");
        }

    }
}
