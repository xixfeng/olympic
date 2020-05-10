package cn.xixfeng.olympic.Controller;

import cn.xixfeng.olympic.Consts.WxInfo;
import cn.xixfeng.olympic.Entity.User;
import cn.xixfeng.olympic.Service.WxService;
import cn.xixfeng.olympic.Util.HttpUtil.RequestUtil;
import cn.xixfeng.olympic.Util.ResUtil.ResponseEntity;
import cn.xixfeng.olympic.Util.ResUtil.ResponseUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/wx_info")
public class WxInfoController {
    private WxService wxService;
    private static Logger log = LoggerFactory.getLogger(WxInfoController.class);

    @Autowired
    public void setService(WxService wxService){
        this.wxService = wxService;
    }

    @RequestMapping("/get_openId")
    public ResponseEntity getOpenId(HttpServletRequest request){
        String jsCode = request.getParameter("js_code");
        Map<String,String> data = new HashMap<>();

        String requestUrl = WxInfo.JsCode2SessionUrl.replace("APPID", WxInfo.AppId).replace("SECRET", WxInfo.AppSecret).replace("JSCODE", jsCode);
        try {
            log.info("申请openid和session_key,对应URL:" + requestUrl);

            JSONObject jsonObject = RequestUtil.httpsRequest(requestUrl, "GET", null);
            String openId = jsonObject.getString("openid");
            data.put("open_id",openId);
            return ResponseUtil.success(data);
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            return ResponseUtil.error(400, "获取账户信息失败，请关闭小程序后再次打开");
        }
    }

    @RequestMapping("/set_user_info")
    public ResponseEntity setUserInfo(HttpServletRequest request){
        String userName = request.getParameter("user_name");
        String avatar = request.getParameter("avatar");
        String openIdStr = request.getParameter("open_id");
        long openId = Long.valueOf(openIdStr);

        User user = new User(openId,avatar,userName,null,null);
        wxService.setUserInfo(user);

        return ResponseUtil.success();
    }
}
