package bussiness;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.MyServlet.decide.DecideSericeImpl;
import services.MyServlet.decide.DecideService;
import services.vo.MessVo;
import struts.action.Action;
import struts.bean.ActionBean;

public class BussAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, ActionBean form,
			Map<String, String> actionForm) {
		// TODO Auto-generated method stub
		String url="";
		DecideService service=new DecideSericeImpl();
		Map<String,MessVo> map=service.getVo(request.getParameter("name"));

		Set<String> set=map.keySet(); 

		for(Iterator<String> it=set.iterator();it.hasNext();)
		{
			url=it.next();
			request.setAttribute("messa", map.get(url));
		}
		return url;
	}

	
	
}
