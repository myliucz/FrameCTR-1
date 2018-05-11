package services.MyServlet.decide;

import java.util.HashMap;
import java.util.Map;

import services.vo.MessVo;

public class DecideSericeImpl implements DecideService{

	
	@Override
	public  Map<String,MessVo> getVo(String user) {
		// TODO Auto-generated method stub
		boolean a=this.isuser(user);
		MessVo vo=new MessVo();
		Map<String,MessVo> map=new HashMap<String,MessVo>();
		if(a==true)
		{  	
			vo.setAaa("AA");
			vo.setBbb("֤");
			vo.setCcc("CC");
			vo.setDdd("DD");
			map.put("/view/MyJsp.jsp", vo);
		}	
		else
		{   	
			vo.setAaa("DD");
			vo.setBbb("֤");
			vo.setCcc("DD");
			vo.setDdd("DD");
			map.put("/view/fail.jsp", vo);
		}
		
		return map;
	}
	public boolean isuser(String user)
	{
		boolean a=false;
		if(user.equals("zhao"))
				{
			
			a=true;
				}
		return a;
	}

}
