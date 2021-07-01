package com.example.final_exam.Service;

import com.example.final_exam.Entity.Vaccine;

import java.util.List;

public interface VaccineService {
    Vaccine create(Vaccine vaccine);
    Vaccine update(Vaccine vaccine, Long id);
    void delete(Long id);
    Vaccine get(Long id);
    List<Vaccine> getAll();
}
