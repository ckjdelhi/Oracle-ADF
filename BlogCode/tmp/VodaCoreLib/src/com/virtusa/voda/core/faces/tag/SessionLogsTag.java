package com.virtusa.voda.core.faces.tag;


import com.virtusa.voda.core.faces.component.SessionLogs;

import javax.el.ValueExpression;

import org.apache.myfaces.trinidad.bean.FacesBean;
import org.apache.myfaces.trinidad.webapp.UIXComponentELTag;


public class SessionLogsTag extends UIXComponentELTag {
    public SessionLogsTag() {
        super(); 
    }
    private ValueExpression _partialTriggers = null;
    private ValueExpression _visible = null;
    private ValueExpression _data = null;
    static public final String COMPONENT_TYPE =
        "com.virtusa.voda.core.SessionLogs";
    static public final String RENDERER_TYPE =
        "com.virtusa.voda.core.SessionLogs";


    public String getComponentType() {
        return COMPONENT_TYPE;
    }

    public String getRendererType() {
        return RENDERER_TYPE;
    }

    public void setPartialTriggers(ValueExpression _partialTriggers) {
        this._partialTriggers = _partialTriggers;
    }

    public ValueExpression getPartialTriggers() {
        return _partialTriggers;
    }

    public void setVisible(ValueExpression _visible) {
        this._visible = _visible;
    }

    public ValueExpression getVisible() {
        return _visible;
    }

    public void setData(ValueExpression _dataList) {
        this._data = _dataList;
    }

    public ValueExpression getData() {
        return _data;
    }

    @Override
    protected void setProperties(FacesBean facesBean) {
        super.setProperties(facesBean);
        setStringArrayProperty(facesBean, SessionLogs.PARTIAL_TRIGGERS_KEY,
                               _partialTriggers);
        setProperty(facesBean, SessionLogs.VISIBLE_KEY, _visible);
        setProperty(facesBean, SessionLogs.DATA_KEY, _data);
    }
}
