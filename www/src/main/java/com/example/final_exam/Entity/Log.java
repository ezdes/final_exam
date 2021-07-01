package com.example.final_exam.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "log")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Log extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "citizen", nullable = false)
    Citizen citizen;
    @ManyToOne
    @JoinColumn(name = "vaccine")
    Vaccine vaccine;
    @Column(name = "is_infected", nullable = false)
    Boolean isInfected;
}
