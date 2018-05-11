package struts.bean;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

public class FullForm {

    public FullForm()
    {

    }

    public static ActionBean constitute(String formPath, HttpServletRequest request) {

        ActionBean actionBean = null;

        try {

            Class clasz = Class.forName(formPath);
            actionBean = (ActionBean) clasz.newInstance();
            Field[] fields = clasz.getDeclaredFields();

            for (Field field : fields) {

                field.setAccessible(true);
                field.set(actionBean, request.getParameter(field.getName()));
                field.setAccessible(false);

            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return actionBean;
    }

}
