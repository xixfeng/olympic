package cn.xixfeng.olympic.Module;

import cn.xixfeng.olympic.Entity.Article;
import cn.xixfeng.olympic.Entity.Comment;
import cn.xixfeng.olympic.Entity.User;

import java.util.List;

public class ArticleDetail {
    private Article article;
    private User user;
    private List<CommentDetail> commentDetails;

    public ArticleDetail(){}

    public ArticleDetail (Article article,User user,List<CommentDetail> commentDetails){
        this.article = article;
        this.user = user;
        this.commentDetails = commentDetails;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CommentDetail> getCommentDetails() {
        return commentDetails;
    }

    public void setCommentDetails(List<CommentDetail> commentDetails) {
        this.commentDetails = commentDetails;
    }
}
