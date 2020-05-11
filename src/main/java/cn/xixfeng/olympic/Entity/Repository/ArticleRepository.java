package cn.xixfeng.olympic.Entity.Repository;

import cn.xixfeng.olympic.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Article findById (long articleId);
}
