package struts.action;

import struts.bean.ActionBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface Action {

    String execute(HttpServletRequest request, HttpServletResponse response,ActionBean actionBean,Map<String,String> actionForm);
}
