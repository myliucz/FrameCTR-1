package struts.Listener;

import struts.entity.StructXmlEntity;
import struts.utils.ParseConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

public class ActionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext context = servletContextEvent.getServletContext();
        String strutsXMlPath = context.getInitParameter("struts-config");
        String tomcatpath = context.getRealPath("");

        Map<String,StructXmlEntity> map = new HashMap<String,StructXmlEntity>();
        map = ParseConfig.parse(tomcatpath+strutsXMlPath);

        context.setAttribute("struts",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
