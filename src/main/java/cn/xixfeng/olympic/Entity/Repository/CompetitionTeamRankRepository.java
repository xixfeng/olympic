package cn.xixfeng.olympic.Entity.Repository;

import cn.xixfeng.olympic.Entity.CompetitionTeamRank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionTeamRankRepository extends JpaRepository<CompetitionTeamRank,Long> {
    List<CompetitionTeamRank> findAllByProjectId(Long projectId);
}
