package cn.xixfeng.olympic.Module;

import cn.xixfeng.olympic.Entity.Project;
import cn.xixfeng.olympic.Entity.Region;

import java.util.List;

public class ProjectDetail extends Project{
    public List<Region> rank;

    public ProjectDetail(Project project, List<Region> regions){
        this.setDesc(project.getDesc());
        this.setName(project.getName());
        this.setProjectId(project.getProjectId());
        this.setImageUrl(project.getImageUrl());
        this.setRule(project.getRule());
        this.setTechnicalTerm(project.getTechnicalTerm());
        this.rank = regions;
    }
}
