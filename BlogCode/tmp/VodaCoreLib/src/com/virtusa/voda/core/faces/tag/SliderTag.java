package com.virtusa.voda.core.faces.tag;

import com.virtusa.voda.core.faces.component.Slider;

import javax.el.ValueExpression;

import org.apache.myfaces.trinidad.bean.FacesBean;
import org.apache.myfaces.trinidad.webapp.UIXComponentELTag;


public class SliderTag extends UIXComponentELTag {

    private ValueExpression _partialTriggers = null;
    private ValueExpression _visible = null;
    private ValueExpression _dataList = null;

    private ValueExpression _var = null;
    //    private ValueExpression _varStatus = null;

    static public final String COMPONENT_TYPE = "com.virtusa.voda.core.Slider";
    static public final String RENDERER_TYPE = "com.virtusa.voda.core.Slider";

    public SliderTag() {
        super();
    }

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

    public void setDataList(ValueExpression _dataList) {
        this._dataList = _dataList;
    }

    public ValueExpression getDataList() {
        return _dataList;
    }

    @Override
    protected void setProperties(FacesBean facesBean) {
        super.setProperties(facesBean);
        setStringArrayProperty(facesBean, Slider.PARTIAL_TRIGGERS_KEY,
                               _partialTriggers);
        setProperty(facesBean, Slider.VISIBLE_KEY, _visible);
        setProperty(facesBean, Slider.DATA_LIST_KEY, _dataList);
        setProperty(facesBean, Slider.VAR_KEY, _var);
        //        setProperty(facesBean, Slider.VAR_STATUS_KEY, _varStatus);
    }

    public void setVar(ValueExpression _var) {
        this._var = _var;
    }

    public ValueExpression getVar() {
        return _var;
    }

}
