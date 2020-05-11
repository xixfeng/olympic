package cn.xixfeng.olympic.Controller;

import cn.xixfeng.olympic.Consts.Common;
import cn.xixfeng.olympic.Service.ArticleService;
import cn.xixfeng.olympic.Service.RegionService;
import cn.xixfeng.olympic.Util.ResUtil.ResponseEntity;
import cn.xixfeng.olympic.Util.ResUtil.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public void setService(ArticleService articleService){
        this.articleService = articleService;
    }

    @RequestMapping("/getAll")
    public ResponseEntity getAll(HttpServletRequest request){
        String pageStr = request.getParameter("page");
        int page = Integer.valueOf(pageStr);
        Pageable pageable = PageRequest.of(page, Common.PageSize, Sort.Direction.DESC, "time");
        return ResponseUtil.success(articleService.getAllArticle(pageable));
    }

    @RequestMapping("/getDetail")
    public ResponseEntity getDetail(HttpServletRequest request){
        return ResponseUtil.success(articleService.getArticleDetail( Long.valueOf(request.getParameter("article_id"))));
    }

}
