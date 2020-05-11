package cn.xixfeng.olympic.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Article {

  private long id;
  private String content;
  private java.sql.Timestamp time = new Timestamp(System.currentTimeMillis());
  private String pic;
  private long userId;


  @Id
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }
}
