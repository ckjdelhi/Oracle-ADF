package com.virtusa.voda.core.faces.render;


import com.virtusa.voda.core.faces.component.Slider;

import com.vodafone.common.util.ADFUtils;

import java.io.IOException;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import oracle.adf.view.rich.render.ClientComponent;
import oracle.adf.view.rich.render.ClientMetadata;
import oracle.adf.view.rich.render.RichRenderer;

import org.apache.myfaces.trinidad.bean.FacesBean;
import org.apache.myfaces.trinidad.bean.PropertyKey;
import org.apache.myfaces.trinidad.context.RenderingContext;


public class SliderRenderer<E extends Object> extends RichRenderer {
    private static final Logger _LOG =
        Logger.getLogger(SliderRenderer.class.getName());
    private static final String _CLIENT_COMPONENT = "VodaSlider";
    private static PropertyKey _DATA_LIST_KEY = null;
    private static PropertyKey _VAR_KEY = null;
    private static PropertyKey _VAR_STATUS_KEY = null;
    private static final String _ROOT_STYLE_KEY = "voda|slider";
    private static final String _SLIDER_CONTENT_STYLE_KEY =
        "voda|slider::content";
    private static final String _SLIDER_CONTENT_PANE_STYLE_KEY =
        "voda|slider::content::pane";

    public SliderRenderer() {
        super(Slider.TYPE);
    }

    protected void encodeAll(FacesContext context, RenderingContext arc,
                             UIComponent component, ClientComponent client,
                             FacesBean bean) throws IOException {

        ResponseWriter writer = context.getResponseWriter();

        {
            writer.startElement("div", component);
            renderId(context, component);
            {
                writer.startElement("div", component);
                renderId(context, component);
                renderStyleClass(context, arc, "container mt20");
                {
                    writer.startElement("div", component);
                    renderId(context, component);
                    renderStyleClass(context, arc, "slider span12 mb20");
                    {
                        writer.startElement("div", component);
                        renderStyleClass(context, arc, "slider-prev sp");
                        {
                            writer.startElement("span", component);
                            renderStyleClass(context, arc, "back-btn");
                            writer.endElement("span");
                        }
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        renderStyleClass(context, arc, "slider-next sn");
                        {
                            writer.startElement("span", component);
                            renderStyleClass(context, arc, "forward-btn");
                            writer.endElement("span");
                        }
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        renderStyleClass(context, arc, "sliderPanel");
                        {
                            writer.startElement("div", component);
                            renderStyleClass(context, arc, "containerBox");
                            _renderTags(context, component, arc, bean);
                            writer.endElement("div");
                        }
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        renderStyleClass(context, arc, "bottom-carousel mb20");
                        {
                            writer.startElement("ul", component);
                            renderStyleClass(context, arc, "round");
                            writer.endElement("ul");
                        }
                        {
//                            writer.startElement("span", component);
//                            renderStyleClass(context, arc, "lolz");
                            {
                                writer.startElement("a", component);
                                writer.writeAttribute("href",
                                                      "javascript:void(0)",
                                                      "javascript:void(0)");
                                renderStyleClass(context, arc, "bt-left");
                                writer.writeText("<", null);
                                writer.endElement("a");
                            }
                            {
                                writer.startElement("a", component);
                                writer.writeAttribute("href",
                                                      "javascript:void(0)",
                                                      "javascript:void(0)");
                                renderStyleClass(context, arc, "bt-right");
                                writer.writeText(">", null);
                                writer.endElement("a");
                            }
//                            writer.endElement("span");
                        }

                        writer.endElement("div");
                    }
                    writer.endElement("div");
                }
                {
                    writer.startElement("div", component);
                    renderStyleClass(context, arc, "sumvaluesre");
                    {
                        writer.startElement("span", component);
                        renderStyleClass(context, arc, "sumvaluesre");
                        writer.endElement("span");
                    }
                    writer.endElement("div");
                }
                writer.endElement("div");
            }
            writer.endElement("div");
        }
        {
            ADFUtils.runJsScript("$(document).ready(function(){sliderComp('" +
                                 getClientId(context, component) + "',3);});");
        }
    }

    private List<E> _getDataList(FacesBean bean) {
        if (_DATA_LIST_KEY == null) {
            _DATA_LIST_KEY = Slider.TYPE.findKey("dataList");
        }
        List<E> dataList = (List<E>)bean.getProperty(_DATA_LIST_KEY);
        if (dataList == null) {
            dataList = Collections.emptyList();
        }

        return dataList;
    }

    private void _renderTags(FacesContext context, UIComponent component,
                             RenderingContext arc,
                             FacesBean bean) throws IOException {
        List<E> dataList = _getDataList(bean);

        if (dataList.isEmpty()) {
            return; // no work to do
        }

        ResponseWriter writer = context.getResponseWriter();

        for (E entry : dataList) {
            {
                writer.startElement("div", component);
                renderStyleClass(context, arc, "contentItem");

                UIComponent sheetData = getFacet(component, "dataSheet");
                if (sheetData != null) {
                    String var = (String)bean.getProperty(_VAR_KEY);
                    sheetData.getAttributes().put(var, entry);
                    writer.writeAttribute("_adfIdAD", sheetData.getId(), null);
                    ADFUtils.setEL("#{" + var + "}", entry);
                    encodeChild(context, sheetData);
                }
                writer.endElement("div");
            }
        }
        {
            writer.startElement("div", component);
            renderStyleClass(context, arc, "clear_fix");
            writer.endElement("div");
        }

    }

    protected String getClientConstructor() {
        return _CLIENT_COMPONENT;
    }

    @Override
    protected ClientComponent.Type getDefaultClientComponentType() {
        return ClientComponent.Type.CREATE_WITH_REQUIRED_ATTRS;
    }

    @Override
    protected String getDefaultStyleClass(FacesContext context,
                                          RenderingContext arc,
                                          FacesBean bean) {
        return this._ROOT_STYLE_KEY;
    }

    @Override
    protected void findTypeConstants(FacesBean.Type type,
                                     ClientMetadata metadata) {
        super.findTypeConstants(type, metadata);

        _DATA_LIST_KEY = type.findKey("dataList");
        metadata.addSecureProperty(_DATA_LIST_KEY);

        _VAR_KEY = type.findKey("var");
    }


}
