package org.lesya.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car", schema = "public")
public class Car implements BaseEntity<Integer>{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "car_year")
    private Integer carYear;
    private String color;
    private String image;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;
    @Column(name = "rental_price")
    private Integer rentalPrice;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
       private RentalStatus status;
    }

