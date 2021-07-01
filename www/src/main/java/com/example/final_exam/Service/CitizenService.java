package com.example.final_exam.Service;

import com.example.final_exam.Entity.Citizen;
import com.example.final_exam.Model.LocalDateModel;


import java.util.List;

public interface CitizenService {
    Citizen create(Citizen citizen);
    Citizen update(Citizen citizen, Long id);
    void delete(Long id);
    Citizen get(Long id);
    List<Citizen> getAll();
    List<Citizen> getAllInfectedByDate(LocalDateModel localDateModel);
    List<Citizen> getAllVaccinatedByDate(LocalDateModel localDateModel);
}
