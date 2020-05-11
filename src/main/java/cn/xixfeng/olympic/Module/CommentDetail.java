package cn.xixfeng.olympic.Module;

import cn.xixfeng.olympic.Entity.Comment;
import cn.xixfeng.olympic.Entity.User;

public class CommentDetail {
    private Comment comment;
    private User user;

    public CommentDetail(){};

    public CommentDetail(Comment comment,User user){
        this.comment = comment;
        this.user = user;
    };

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
