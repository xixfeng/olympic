package cn.xixfeng.olympic.Entity.Repository;

import cn.xixfeng.olympic.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    Project findByProjectId(Long projectId);
}
