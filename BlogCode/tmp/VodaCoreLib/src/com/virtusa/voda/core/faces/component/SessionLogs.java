package com.virtusa.voda.core.faces.component;

import com.virtusa.voda.core.data.sessionLogs.SessionDayLogs;
import com.virtusa.voda.core.data.sessionLogs.SessionLogsData;

import java.util.List;

import javax.el.ValueExpression;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.FacesEvent;

import org.apache.myfaces.trinidad.bean.FacesBean;
import org.apache.myfaces.trinidad.bean.PropertyKey;
import org.apache.myfaces.trinidad.component.UIXObject;

public class SessionLogs extends UIXObject {

    public SessionLogs() {
        super(RENDERER_TYPE);
        setBooleanProperty(CLIENT_COMPONENT_KEY, Boolean.TRUE);
        setTimeStart(0);
        setDataFilter("all");
        setTimeScale("hours");
    }

    static public final FacesBean.Type TYPE =
        new FacesBean.Type(UIXObject.TYPE);

    static public final PropertyKey VISIBLE_KEY =
        TYPE.registerKey("visible", Boolean.class, Boolean.TRUE);
    static public final PropertyKey PARTIAL_TRIGGERS_KEY =
        TYPE.registerKey("partialTriggers", String[].class);
    static public final PropertyKey CLIENT_COMPONENT_KEY =
        TYPE.registerKey("clientComponent", Boolean.class);
    static public final PropertyKey DATA_KEY =
        TYPE.registerKey("data", List.class);

    static public final PropertyKey DATA_FILTER =
        TYPE.registerKey("dataFilter", String.class);
    static public final PropertyKey TIME_SCALE =
        TYPE.registerKey("timeScale", String.class);
    static public final PropertyKey TIME_FRAME =
        TYPE.registerKey("timeFrame", Boolean.class);
    static public final PropertyKey TIME_START =
        TYPE.registerKey("timeStart", Integer.class);

    static public final String RENDERER_TYPE =
        "com.virtusa.voda.core.SessionLogs";

    static public final String COMPONENT_TYPE =
        "com.virtusa.voda.core.SessionLogs";

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
        System.out.println("Shit");
        super.broadcast(facesEvent);
    }

    public void setVisible(boolean newvisible) {
        setBooleanProperty(VISIBLE_KEY, newvisible);
    }

    public boolean isVisible() {
        return getBooleanProperty(VISIBLE_KEY, Boolean.TRUE);
    }

    public void setDataList(List<SessionDayLogs> newtags) {
        setProperty(DATA_KEY, newtags);
    }

    public List<SessionDayLogs> getData() {
        return (List<SessionDayLogs>)getProperty(DATA_KEY);
    }

    static {
        TYPE.lockAndRegister(UIXObject.COMPONENT_FAMILY, RENDERER_TYPE);
    }


    public void setTimeFrame(String timeFrame) {
        setProperty(TIME_FRAME, timeFrame);
    }

    public String getTimeFrame() {
        return (String)getProperty(TIME_FRAME);
    }

    public void setTimeScale(String timeScale) {
        setProperty(TIME_SCALE, timeScale);
    }

    public String getTimeScale() {
        return (String)getProperty(TIME_SCALE);
    }

    public void setDataFilter(String dataFilter) {
        setProperty(DATA_FILTER, dataFilter);
    }

    public String getDataFilter() {
        return (String)getProperty(DATA_FILTER);
    }

    public void setTimeStart(Integer dataFilter) {
        setProperty(TIME_START, dataFilter);
    }

    public Integer getTimeStart() {
        return (Integer)getProperty(TIME_START);
    }
}
