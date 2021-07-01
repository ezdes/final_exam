package com.example.final_exam.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
@Entity
@Table(name = "citizen")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Citizen extends BaseEntity{
    @Column(name = "name", nullable = false)
    String name;
    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    Region region;
}
