package cn.xixfeng.olympic.Util.ResUtil;

public class ResponseUtil {
    public static ResponseEntity success(Object data){
        return new ResponseEntity(200, null, data);
    }

    //当成功且无返回参数时使用
    public static ResponseEntity success(){
        return success(null);
    }

    //当需要指定status时候使用
    public static ResponseEntity success(Integer status,Object data,String msg){
        return new ResponseEntity(status,msg,data);
    }

    public static ResponseEntity error(Integer status, String msg){
        return new ResponseEntity(status, msg, null);
    }

    public static ResponseEntity error(Integer status, String msg, Object data){
        return new ResponseEntity(status, msg, data);
    }
}

