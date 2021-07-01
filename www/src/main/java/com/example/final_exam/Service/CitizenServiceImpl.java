package com.example.final_exam.Service;

import com.example.final_exam.Entity.Citizen;
import com.example.final_exam.Entity.Log;
import com.example.final_exam.Model.LocalDateModel;
import com.example.final_exam.Repository.CitizenRepository;
import com.example.final_exam.Sort.CitizenComparator;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private LogService logService;

    @Override
    public Citizen create(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public Citizen update(Citizen citizen, Long id) {
        return citizenRepository.findById(id)
                .map(newCitizen -> {
                    newCitizen.setName(citizen.getName());
                    newCitizen.setRegion(citizen.getRegion());
                    return citizenRepository.save(newCitizen);
                }).orElseThrow(() -> new ObjectNotFoundException(id, "citizen"));
    }


    @Override
    public List<Citizen> getAllInfectedByDate(LocalDateModel localDateModel) {
        List<Log> logList = logService.getAll();
        List<Citizen> citizenList = new ArrayList<>();
        for (Log log : logList) {
            if (log.getCreatedDate().isEqual(localDateModel.getLocalDate()) && log.getIsInfected())
                citizenList.add(log.getCitizen());
        }
        citizenList.sort(new CitizenComparator());
        return citizenList;
    }

    @Override
    public List<Citizen> getAllVaccinatedByDate(LocalDateModel localDateModel) {
        List<Log> logList = logService.getAll();
        List<Citizen> citizenList = new ArrayList<>();
        for (Log log : logList) {
            if (log.getCreatedDate().isEqual(localDateModel.getLocalDate()) && log.getVaccine() != null)
                citizenList.add(log.getCitizen());
        }
        citizenList.sort(new CitizenComparator());
        return citizenList;
    }

    @Override
    public void delete(Long id) {
        citizenRepository.deleteById(id);
    }

    @Override
    public Citizen get(Long id) {
        return citizenRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "citizen"));
    }

    @Override
    public List<Citizen> getAll() {
        return citizenRepository.findAll();
    }
}
