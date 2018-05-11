package services.MyServlet.decide;

import java.util.Map;

import services.vo.MessVo;

public interface DecideService {

	
		
		Map<String,MessVo> getVo(String user);
	
}
