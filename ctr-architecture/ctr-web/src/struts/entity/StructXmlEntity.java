package struts.entity;

import java.util.HashMap;
import java.util.Map;

public class StructXmlEntity {

    private String entityName;

    private String entityClass;

    private String actionName;

    private String actionType;

    private String path;

    private Map<String,String> actionForwards = new HashMap<String,String>();

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Map<String, String> getActionForwards() {
        return actionForwards;
    }

    public void setActionForwards(Map<String, String> actionForwards) {
        this.actionForwards = actionForwards;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
