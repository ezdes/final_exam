package com.example.final_exam.Service;

import com.example.final_exam.Entity.Log;
import com.example.final_exam.Repository.LogRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private LogRepository logRepository;

    @Override
    public Log create(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Log update(Log log, Long id) {
        return logRepository.findById(id)
                .map(newLog -> {
                    newLog.setCitizen(log.getCitizen());
                    newLog.setVaccine(log.getVaccine());
                    newLog.setIsInfected(log.getIsInfected());
                    return logRepository.save(newLog);
                }).orElseThrow(() -> new ObjectNotFoundException(id, "log"));
    }

    @Override
    public void delete(Long id) {
        logRepository.deleteById(id);
    }

    @Override
    public Log get(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "log"));
    }

    @Override
    public List<Log> getAll() {
        return logRepository.findAll();
    }
}
