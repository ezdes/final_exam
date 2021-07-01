package com.example.final_exam.Controller;

import com.example.final_exam.Entity.Vaccine;
import com.example.final_exam.Service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccines")
public class VaccineController {
    @Autowired
    private VaccineService vaccineService;

    @PostMapping
    public Vaccine create(@RequestBody Vaccine vaccine) {
        return vaccineService.create(vaccine);
    }

    @GetMapping("/{id}")
    public Vaccine get(@PathVariable Long id) {
        return vaccineService.get(id);
    }

    @GetMapping
    public List<Vaccine> getAll() {
        return vaccineService.getAll();
    }

    @PutMapping("/{id}")
    public Vaccine update(@RequestBody Vaccine vaccine, @PathVariable Long id) {
        return vaccineService.update(vaccine, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vaccineService.delete(id);
    }
}
