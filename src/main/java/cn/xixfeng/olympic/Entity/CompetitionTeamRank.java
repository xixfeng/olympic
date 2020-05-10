package cn.xixfeng.olympic.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import cn.xixfeng.olympic.Consts.*;

@Entity
public class CompetitionTeamRank {

  private long id;
  private long competitionId;
  private long teamId;
  private double score;
  private Rank rank;
  private long countryRegionId;
  private long projectId;

  @Id
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCompetitionId() {
    return competitionId;
  }

  public void setCompetitionId(long competitionId) {
    this.competitionId = competitionId;
  }

  public long getTeamId() {
    return teamId;
  }

  public void setTeamId(long teamId) {
    this.teamId = teamId;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public Rank getRank() {
    return rank;
  }

  public void setRank(Rank rank) {
    this.rank = rank;
  }

  public long getCountryRegionId() {
    return countryRegionId;
  }

  public void setCountryRegionId(long countryRegionId) {
    this.countryRegionId = countryRegionId;
  }

  public long getProjectId() {
    return projectId;
  }

  public void setProjectId(long projectId) {
    this.projectId = projectId;
  }
}
