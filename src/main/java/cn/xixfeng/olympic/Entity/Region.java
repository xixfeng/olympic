package cn.xixfeng.olympic.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region implements Comparable{

  private long regionId;
  private long fatherRegionId;
  private long goldMedal;
  private long silverMedal;
  private long bronzeMedal;
  private String name;
  private String nationalFlag;

  @Id
  public long getRegionId() {
    return regionId;
  }

  public void setRegionId(long regionId) {
    this.regionId = regionId;
  }

  public long getFatherRegionId() {
    return fatherRegionId;
  }

  public void setFatherRegionId(long fatherRegionId) {
    this.fatherRegionId = fatherRegionId;
  }

  public long getGoldMedal() {
    return goldMedal;
  }

  public void setGoldMedal(long goldMedal) {
    this.goldMedal = goldMedal;
  }

  public long getSilverMedal() {
    return silverMedal;
  }

  public void setSilverMedal(long silverMedal) {
    this.silverMedal = silverMedal;
  }

  public long getBronzeMedal() {
    return bronzeMedal;
  }

  public void setBronzeMedal(long bronzeMedal) {
    this.bronzeMedal = bronzeMedal;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNationalFlag() {
    return nationalFlag;
  }

  public void setNationalFlag(String nationalFlag) {
    this.nationalFlag = nationalFlag;
  }

  @Override
  public int compareTo(Object o) {
    Region region = (Region)o;

    return this.getGoldMedal() > region.getGoldMedal()? -1 : this.getGoldMedal() < region.getGoldMedal()? 1 : 0;
  }
}
