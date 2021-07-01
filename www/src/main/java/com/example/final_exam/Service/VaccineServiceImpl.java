package com.example.final_exam.Service;

import com.example.final_exam.Entity.Vaccine;
import com.example.final_exam.Repository.VaccineRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public Vaccine create(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    @Override
    public Vaccine update(Vaccine vaccine, Long id) {
        return vaccineRepository.findById(id)
                .map(newVaccine -> {
                    newVaccine.setName(vaccine.getName());
                    return vaccineRepository.save(newVaccine);
                }).orElseThrow(() -> new ObjectNotFoundException(id, "vaccine"));
    }

    @Override
    public void delete(Long id) {
        vaccineRepository.deleteById(id);
    }

    @Override
    public Vaccine get(Long id) {
        return vaccineRepository.findById(id)
        .orElseThrow(() -> new ObjectNotFoundException(id, "vaccine"));
    }

    @Override
    public List<Vaccine> getAll() {
        return vaccineRepository.findAll();
    }
}
