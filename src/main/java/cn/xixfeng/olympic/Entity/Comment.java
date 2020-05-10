package cn.xixfeng.olympic.Entity;

import javax.persistence.*;


@Entity
public class Comment {

  private long id;
  private long articleId;
  private String content;
  private long userId;
  private String pic;
  private java.sql.Timestamp time;


  @Id
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getArticleId() {
    return articleId;
  }

  public void setArticleId(long articleId) {
    this.articleId = articleId;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }

}
