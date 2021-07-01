package com.example.final_exam.Controller;

import com.example.final_exam.Entity.Citizen;
import com.example.final_exam.Model.LocalDateModel;
import com.example.final_exam.Service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizens")
public class CitizenController {
    @Autowired
    private CitizenService citizenService;

    @PostMapping
    public Citizen create(@RequestBody Citizen citizen) {
        return citizenService.create(citizen);
    }

    @GetMapping("/{id}")
    public Citizen get(@PathVariable Long id) {
        return citizenService.get(id);
    }

    @GetMapping
    public List<Citizen> getAll() {
        return citizenService.getAll();
    }

    @PutMapping("/{id}")
    public Citizen update(@RequestBody Citizen citizen, @PathVariable Long id) {
        return citizenService.update(citizen, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        citizenService.delete(id);
    }

    @GetMapping("/infected")
    public List<Citizen> getInfected(@RequestBody LocalDateModel localDateModel) {
        return citizenService.getAllInfectedByDate(localDateModel);
    }
    @GetMapping("/vaccinated")
    public List<Citizen> getVaccinated(@RequestBody LocalDateModel localDateModel) {
        return citizenService.getAllVaccinatedByDate(localDateModel);
    }
}



