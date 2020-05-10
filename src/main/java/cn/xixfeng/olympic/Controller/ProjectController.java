package cn.xixfeng.olympic.Controller;

import cn.xixfeng.olympic.Service.ProjectService;
import cn.xixfeng.olympic.Util.ResUtil.ResponseEntity;
import cn.xixfeng.olympic.Util.ResUtil.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public void setService(ProjectService projectService){
        this.projectService = projectService;
    }


    @RequestMapping("/getAll")
    public ResponseEntity getAll(){
        return ResponseUtil.success(projectService.getAllProject());
    }

    @RequestMapping("/getDetail")
    public ResponseEntity getDetail(HttpServletRequest request){
        return ResponseUtil.success(projectService.getProjetDetail( Long.valueOf(request.getParameter("project_id"))));
    }

}
