package com.example.CrudUsingJpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Month;
import java.time.Year;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AllocationManagement implements Serializable {

    @Id
    @Column(name = "Segment", nullable = false)
    private String segment;
    @Column(name = "Country", nullable = false)
    private String country;
    @Column(name = "Product", nullable = false)
    private String product;
    @Column(name = "Discount Band", nullable = false)
    private String discount_Band;
    @Column(name = "Units Sold", nullable = false)
    private Integer unitsSold;
    @Column(name = "Manufacturing Price", nullable = false)
	private Integer manufacturing_Price;
    @Column(name = "Sale Price", nullable = false)
    private Integer sale_Price;
    @Column(name = "Gross Sales", nullable = false)
    private Integer gross_Sales;
    @Column(name = "Discounts", nullable = false)
    private Integer discounts;
    @Column(name = "Sales", nullable = false)
    private Integer sales;
    @Column(name = "COGS", nullable = false)
    private Integer cogs;
    @Column(name = "Profit", nullable = false)
    private Integer Data;
    @Column(name = "Date", nullable = false)
    Date date;
    @Column( name = "Month Number", nullable = false)
    private Integer months_number;
    @Column( name = "Month Name", nullable = false)
    Month month_Name;
     @Column(name = "YEAR", nullable = false)
    Year year;

}
