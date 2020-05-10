package cn.xixfeng.olympic.Controller;


import cn.xixfeng.olympic.Service.RegionService;
import cn.xixfeng.olympic.Util.ResUtil.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/medal")
public class MedalController {
    private RegionService regionService;

    @Autowired
    public void setService(RegionService regionService){
        this.regionService = regionService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity getAll(){
        return ResponseUtil.success(regionService.GetAllRegionDescByRegionId());
    }

}
