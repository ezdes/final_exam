package com.example.final_exam.Controller;

import com.example.final_exam.Entity.Log;
import com.example.final_exam.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping
    public Log create(@RequestBody Log log) {
        return logService.create(log);
    }

    @GetMapping("/{id}")
    public Log get(@PathVariable Long id) {
        return logService.get(id);
    }

    @GetMapping
    public List<Log> getAll() {
        return logService.getAll();
    }

    @PutMapping("/{id}")
    public Log update(@RequestBody Log log, @PathVariable Long id) {
        return logService.update(log, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        logService.delete(id);
    }

}
