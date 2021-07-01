package com.example.final_exam.Model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegionInfoModel {
    String name;
    Integer population;
    Integer infected;
    Integer vaccinated;
    Double percentageOfInfected;
    Double percentageOfVaccinated;
}
