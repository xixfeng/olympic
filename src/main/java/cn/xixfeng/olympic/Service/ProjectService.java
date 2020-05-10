package cn.xixfeng.olympic.Service;

import cn.xixfeng.olympic.Entity.CompetitionTeamRank;
import cn.xixfeng.olympic.Entity.Project;
import cn.xixfeng.olympic.Entity.Region;
import cn.xixfeng.olympic.Entity.Repository.CompetitionTeamRankRepository;
import cn.xixfeng.olympic.Entity.Repository.ProjectRepository;
import cn.xixfeng.olympic.Entity.Repository.RegionRepository;
import cn.xixfeng.olympic.Module.ProjectDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    private CompetitionTeamRankRepository competitionTeamRankRepository;
    private RegionRepository regionRepository;

    @Autowired
    public void setRepository(ProjectRepository projectRepository, CompetitionTeamRankRepository competitionTeamRankRepository,
                              RegionRepository regionRepository) {
        this.projectRepository = projectRepository;
        this.competitionTeamRankRepository = competitionTeamRankRepository;
        this.regionRepository = regionRepository;
    }

    public List<Project> getAllProject(){
        List<Project> projects = projectRepository.findAll();
        for(Project project : projects){
            project.setRule("");
            project.setTechnicalTerm("");
        }
        return projects;
    }

    public ProjectDetail getProjetDetail(long projectId){
        Map<Long, Region> regions = new HashMap<>();
        Set<Long> regionIdSet = new HashSet<>();

        //level1
        Project project = projectRepository.findByProjectId(projectId);

        //level2
        List<CompetitionTeamRank> competitionTeamRanks = competitionTeamRankRepository.findAllByProjectId(projectId);
        //pack regionMedalInfo
        for(CompetitionTeamRank competitionTeamRank : competitionTeamRanks){
            Region region = regions.get(competitionTeamRank.getCountryRegionId());
            if(region == null){
                region = new Region();
                region.setRegionId(competitionTeamRank.getCountryRegionId());
                regions.put(competitionTeamRank.getCountryRegionId(),region);
            }

            switch (competitionTeamRank.getRank()){
                case goldMedal:
                    region.setGoldMedal(region.getGoldMedal()+1);
                    break;
                case bronzeMedal:
                    region.setBronzeMedal(region.getBronzeMedal()+1);
                    break;
                case silverMedal:
                    region.setSilverMedal(region.getSilverMedal()+1);
                    break;
            }

            regionIdSet.add(competitionTeamRank.getCountryRegionId());
        }


        //level3
        List<Region> regionsInfos = regionRepository.findAllById(regionIdSet);
        //pack region Info
        for(Region regionInfo : regionsInfos){
            Region region = regions.get(regionInfo.getRegionId());
            region.setName(regionInfo.getName());
            region.setNationalFlag(regionInfo.getNationalFlag());
        }

        //pack all
        List<Region> regionList = new ArrayList<>(regionsInfos.size());
        for(Map.Entry<Long,Region> entry : regions.entrySet()){
            regionList.add(entry.getValue());
        }
        Collections.sort(regionList);
        return new ProjectDetail(project,regionList);
    }
}
