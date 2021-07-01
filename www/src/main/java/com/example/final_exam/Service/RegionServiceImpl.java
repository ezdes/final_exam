package com.example.final_exam.Service;

import com.example.final_exam.Entity.Log;
import com.example.final_exam.Entity.Region;
import com.example.final_exam.Model.RegionInfoModel;
import com.example.final_exam.Repository.RegionRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private LogService logService;

    @Override
    public Region create(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region update(Region region, Long id) {
        return regionRepository.findById(id)
                .map(newRegion -> {
                    newRegion.setName(region.getName());
                    newRegion.setPopulation(region.getPopulation());
                    return regionRepository.save(newRegion);
                }).orElseThrow(() -> new ObjectNotFoundException(id, "region"));
    }

    public List<RegionInfoModel> regionInfo() {
        List<Region> regionList = getAll();
        List<Log> logList = logService.getAll();
        List<RegionInfoModel> regionInfoModelList = new ArrayList<>();
        int infected = 1;
        int vaccinated = 1;
        for (int i = 0; i < regionList.size(); i++) {
            RegionInfoModel regionInfoModel = new RegionInfoModel();
            regionInfoModel.setName(regionList.get(i).getName());
            regionInfoModel.setPopulation(regionList.get(i).getPopulation());
            for (int j = i + 1; j < logList.size(); j++) {
                if (regionList.get(i).getId().equals(logList.get(j).getCitizen().getRegion().getId())) {
                    if (logList.get(j).getVaccine() != null) vaccinated++;
                    if (logList.get(j).getIsInfected()) infected++;
                }
            }
            regionInfoModel.setVaccinated(vaccinated);
            regionInfoModel.setInfected(infected);
            regionInfoModel.setPercentageOfInfected((infected  + 0.0) / regionInfoModel.getPopulation() * 100);
            regionInfoModel.setPercentageOfVaccinated((vaccinated  + 0.0) / regionInfoModel.getPopulation() * 100);
            vaccinated = 0;
            infected = 0;
            regionInfoModelList.add(regionInfoModel);
        }

        return regionInfoModelList;
    }


    @Override
    public void delete(Long id) {
        regionRepository.deleteById(id);
    }

    @Override
    public Region get(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "region"));
    }

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }
}
