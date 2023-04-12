package org.lesya.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rent", schema = "public")
public class Rent implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "termination_car_rental")
    private LocalDate terminationCarRental;

    @Column(name = "car_id")
    private Integer carId;

    @Enumerated(EnumType.STRING)
    @Column(name = "request_status")
    private RequestStatus requestStatus;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String passport;
    @Column(name = "driving_experience")
    private Integer drivingExperience;

    @Column(name = "mess")
    private String message;
}
