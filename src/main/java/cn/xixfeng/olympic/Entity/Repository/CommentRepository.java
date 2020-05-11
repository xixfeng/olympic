package cn.xixfeng.olympic.Entity.Repository;

import cn.xixfeng.olympic.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByArticleId(long articleId);
}
