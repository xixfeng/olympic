package cn.xixfeng.olympic.Service;

import cn.xixfeng.olympic.Entity.Region;
import cn.xixfeng.olympic.Entity.Repository.RegionRepository;
import cn.xixfeng.olympic.Util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private RegionRepository regionRepository;

    @Autowired
    public void setRepository(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> GetAllRegionDescByRegionId(){
        return regionRepository.findAll(SortUtil.basicSort("desc","regionId"));
    }
}
