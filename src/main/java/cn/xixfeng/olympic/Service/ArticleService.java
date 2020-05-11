package cn.xixfeng.olympic.Service;

import cn.xixfeng.olympic.Entity.Article;
import cn.xixfeng.olympic.Entity.Comment;
import cn.xixfeng.olympic.Entity.Repository.*;
import cn.xixfeng.olympic.Entity.User;
import cn.xixfeng.olympic.Module.ArticleDetail;
import cn.xixfeng.olympic.Module.CommentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService {
    private UserRepository userRepository;
    private ArticleRepository articleRepository;
    private CommentRepository commentRepository;

    @Autowired
    public void setRepository(UserRepository userRepository, ArticleRepository articleRepository,
                              CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public void uploadArticle(Article article){
        articleRepository.save(article);
    }

    public List<ArticleDetail> getAllArticle(Pageable page){
        //level1
        List<Article> articles = articleRepository.findAll(page).getContent();

        //level2
        Set<Long> userIds = new HashSet<>();
        for(Article article : articles){
            userIds.add(article.getUserId());
        }

        //转变为map
        List<User> users = userRepository.findAllById(userIds);
        Map<Long,User> userMap = new HashMap<>();
        for(User user : users){
            userMap.put(user.getWxUid(),user);
        }

        //pack
        List<ArticleDetail> articleDetails = new LinkedList<>();
        for(Article article : articles){
            articleDetails.add(new ArticleDetail(article,userMap.get(article.getUserId()),null));
        }

        return articleDetails;
    }

    public ArticleDetail getArticleDetail(long articleId){
        //level1
        Article article = articleRepository.findById(articleId);

        //level2
        User user = userRepository.findByWxUid(article.getUserId());

        //leve3
        List<CommentDetail> commentDetails = getCommentDetails(articleId);

        return new ArticleDetail(article,user,commentDetails);
    }

    public List<CommentDetail> getCommentDetails(long articleId){
        //level1
        List<Comment> comments = commentRepository.findAllByArticleId(articleId);

        //level2
        Set<Long> userIds = new HashSet<>();
        for(Comment comment  : comments){
            userIds.add(comment.getUserId());
        }

        List<User> users = userRepository.findAllById(userIds);
        Map<Long,User> userMap = new HashMap<>();
        for(User user : users){
            userMap.put(user.getWxUid(),user);
        }

        //pack
        List<CommentDetail> commentDetails = new LinkedList<>();
        for(Comment comment : comments){
            commentDetails.add(new CommentDetail(comment,userMap.get(comment.getUserId())));
        }
        return commentDetails;
    }


}
