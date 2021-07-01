package com.example.final_exam.Service;

import com.example.final_exam.Entity.Region;
import com.example.final_exam.Model.RegionInfoModel;

import java.util.List;

public interface RegionService {
    Region create(Region region);
    Region update(Region region, Long id);
    void delete(Long id);
    Region get(Long id);
    List<Region> getAll();
    List<RegionInfoModel> regionInfo();
}
