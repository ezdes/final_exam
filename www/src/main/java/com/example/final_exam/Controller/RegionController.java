package com.example.final_exam.Controller;

import com.example.final_exam.Entity.Region;
import com.example.final_exam.Model.RegionInfoModel;
import com.example.final_exam.Service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @PostMapping
    public Region create(@RequestBody Region region) {
        return regionService.create(region);
    }

    @GetMapping("/{id}")
    public Region get(@PathVariable Long id) {
        return regionService.get(id);
    }

    @GetMapping
    public List<Region> getAll() {
        return regionService.getAll();
    }

    @PutMapping("/{id}")
    public Region update(@RequestBody Region region, @PathVariable Long id) {
        return regionService.update(region, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        regionService.delete(id);
    }

    @GetMapping("/regionInfo")
    public List<RegionInfoModel> regionInfo() {
        return regionService.regionInfo();
    }
}
