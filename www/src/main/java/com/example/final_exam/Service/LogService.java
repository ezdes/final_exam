package com.example.final_exam.Service;

import com.example.final_exam.Entity.Log;

import java.util.List;

public interface LogService {
    Log create(Log log);
    Log update(Log log, Long id);
    void delete(Long id);
    Log get(Long id);
    List<Log> getAll();
}
