package com.virtusa.voda.core.faces.component;

import java.util.List;

import javax.el.ValueExpression;

import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.FacesEvent;

import org.apache.myfaces.trinidad.bean.FacesBean;
import org.apache.myfaces.trinidad.bean.PropertyKey;
import org.apache.myfaces.trinidad.component.UIXObject;


public class Slider<E extends Object> extends UIXObject {

    public Slider() {
        super(RENDERER_TYPE);
        setBooleanProperty(CLIENT_COMPONENT_KEY, Boolean.TRUE);
    }

    static public final FacesBean.Type TYPE =
        new FacesBean.Type(UIXObject.TYPE);

    static public final PropertyKey VISIBLE_KEY =
        TYPE.registerKey("visible", Boolean.class, Boolean.TRUE);

    static public final PropertyKey VAR_KEY =
        TYPE.registerKey("var", ValueExpression.class);

    static public final PropertyKey PARTIAL_TRIGGERS_KEY =
        TYPE.registerKey("partialTriggers", String[].class);

    static public final PropertyKey CLIENT_COMPONENT_KEY =
        TYPE.registerKey("clientComponent", Boolean.class);

    static public final PropertyKey DATA_LIST_KEY =
        TYPE.registerKey("dataList", List.class);

    static public final String RENDERER_TYPE = "com.virtusa.voda.core.Slider";

    static public final String COMPONENT_TYPE = "com.virtusa.voda.core.Slider";

    public static final String DATA_SHEET_FACET = "dataSheet";

    public final UIComponent getDataSheet() {
        return getFacet("dataSheet");
    }

    public final void setDataSheet(UIComponent dataSheetFacet) {
        getFacets().put("dataSheet", dataSheetFacet);
    }

    public void setVar(ValueExpression var) {
        setProperty(VAR_KEY, var);
    }

    public ValueExpression getVar() {
        return (ValueExpression)getProperty(VAR_KEY);
    }

    public void setPartialTriggers(String[] newpartialTriggers) {
        setProperty(PARTIAL_TRIGGERS_KEY, newpartialTriggers);
    }

    public String[] getPartialTriggers() {
        return (String[])getProperty(PARTIAL_TRIGGERS_KEY);
    }

    @Override
    protected FacesBean.Type getBeanType() {
        return TYPE;
    }

    @Override
    public void broadcast(FacesEvent facesEvent) throws AbortProcessingException {
        super.broadcast(facesEvent);
    }

    public void setVisible(boolean newvisible) {
        setBooleanProperty(VISIBLE_KEY, newvisible);
    }

    public boolean isVisible() {
        return getBooleanProperty(VISIBLE_KEY, Boolean.TRUE);
    }

    public void setDataList(List<E> newtags) {
        setProperty(DATA_LIST_KEY, newtags);
    }

    public List<E> getDataList() {
        return (List<E>)getProperty(DATA_LIST_KEY);
    }

    static {
        // register the new TYPE by family and rendererType
        TYPE.lockAndRegister(UIXObject.COMPONENT_FAMILY, RENDERER_TYPE);
    }

}
