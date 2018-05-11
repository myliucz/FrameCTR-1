package struts.utils;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import struts.entity.StructXmlEntity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseConfig {

    public ParseConfig(){

    }

    public static Map<String,StructXmlEntity> parse(String strPath){

        Map<String,StructXmlEntity> map = new HashMap<String,StructXmlEntity>();

        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document doc = saxBuilder.build(new File(strPath));
            Element root = doc.getRootElement();

            Element action = root.getChild("action-mapping");
            List<Element> elementList = action.getChildren();

            for(Element element : elementList) {
                StructXmlEntity xmlEntity = new StructXmlEntity();
                String action_name = element.getAttributeValue("name");
                xmlEntity.setActionName(action_name);
                Element action_entity = root.getChild("action-entity");

                List<Element> entities = action_entity.getChildren();
                for (Element entity : entities) {
                    if (action_name.equals(entity.getAttributeValue("name"))) {
                        String clasz = entity.getAttributeValue("class");
                        xmlEntity.setEntityClass(clasz);
                        break;
                    }
                }

                String path = element.getAttributeValue("path");
                String type = element.getAttributeValue("type");

                xmlEntity.setPath(path);
                xmlEntity.setActionType(type);

                List<Element> forwars = element.getChildren();
                Map<String, String> mForwards = new HashMap<String, String>();
                for (Element forward : forwars)
                {
                    String forward_name = forward.getAttributeValue("name");
                    String forward_value = forward.getAttributeValue("value");
                    mForwards.put(forward_name,forward_value);
                }

                xmlEntity.setActionForwards(mForwards);
                map.put(path,xmlEntity);


            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
