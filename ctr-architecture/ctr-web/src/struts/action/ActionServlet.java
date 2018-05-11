package struts.action;


import struts.bean.ActionBean;
import struts.bean.FullForm;
import struts.entity.StructXmlEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ActionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = this.getPath(req.getServletPath());
        Map<String,StructXmlEntity> map = (Map<String, StructXmlEntity>) this.getServletContext().getAttribute("struts");
        StructXmlEntity xmlEntity = map.get(path);
        String formClass = xmlEntity.getEntityClass();
        ActionBean actionBean = FullForm.constitute(formClass,req);
        String actionType = xmlEntity.getActionType();
        Action action = null;
        String url = "";

        try {

            Class clasz = Class.forName(actionType);
            action=(Action)clasz.newInstance();
            url = action.execute(req,resp,actionBean,xmlEntity.getActionForwards());

        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dis=req.getRequestDispatcher(url);
        dis.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public String getPath(String servletPath)
    {

        return servletPath.split("\\.")[0];
    }
}
