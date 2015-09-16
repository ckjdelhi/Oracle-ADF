package com.virtusa.voda.core.faces.render;


import com.virtusa.voda.core.data.sessionLogs.SessionDayLogs;
import com.virtusa.voda.core.faces.component.SessionLogs;

import com.vodafone.common.util.ADFUtils;

import java.io.IOException;

import java.util.Collections;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import oracle.adf.view.rich.render.ClientComponent;
import oracle.adf.view.rich.render.ClientEvent;
import oracle.adf.view.rich.render.ClientMetadata;
import oracle.adf.view.rich.render.RichRenderer;

import org.apache.myfaces.trinidad.bean.FacesBean;
import org.apache.myfaces.trinidad.bean.PropertyKey;
import org.apache.myfaces.trinidad.context.RenderingContext;


public class SessionLogsRenderer extends RichRenderer {
    public SessionLogsRenderer() {
        super(SessionLogs.TYPE);
    }

    private static final String _CLIENT_COMPONENT = "VodaSessionLogs";
    private static PropertyKey _DATA_KEY = null;
    private static final String _ROOT_STYLE_KEY = "voda|SessionLogs";
    private static PropertyKey _DATA_FILTER = null, _TIME_FRAME =
        null, _TIME_SCALE = null, _TIME_START = null;
    //    private static final String _CLIENT_SELECT_EVENT_TIME_SCALE_PARAM =
    //        "timeScale";
    //    private static final String _CLIENT_SELECT_EVENT_DATA_FILTER_PARAM =
    //        "dataFilter";
    //    private static final String _CLIENT_SELECT_EVENT_TIME_FRAME_PARAM =
    //        "timeFrame";

    private static final String _CLIENT_SELECT_EVENT_TIME_SCALE_TYPE =
        "TimeScaleSelectEvent";
    private static final String _CLIENT_SELECT_EVENT_DATA_FILTER_TYPE =
        "DataFilterSelectEvent";
    private static final String _CLIENT_SELECT_EVENT_TIME_FRAME_TYPE =
        "TimeFrameSelectEvent";


    protected void encodeAll(FacesContext context, RenderingContext arc,
                             UIComponent component, ClientComponent client,
                             FacesBean bean) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        {
            writer.startElement("div", component);
            renderId(context, component);
            renderStyleClass(context, arc, "sessionLogs-container");
            {
                writer.startElement("hidden", component);
                writer.writeAttribute("id",
                                      getClientId(context, component) + "_hiddenMainObj",
                                      null);
                writer.writeAttribute("value", "null", null);
                writer.endElement("hidden");
            }
            {
                writer.startElement("div", component);
                //renderId(context, component);
                renderStyleClass(context, arc, "controls-container");
                {
                    writer.startElement("div", component);
                    //renderId(context, component);
                    renderStyleClass(context, arc, "control-status");
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        {
                            writer.startElement("p", component);
                            //renderId(context, component);
                            writer.writeText("View graph by event status",
                                             null);
                            writer.endElement("p");
                        }
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc,
                                         "button all selected dataFilter");
                        writer.writeAttribute("value", "all", null);
                        writer.writeText("All", null);
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc,
                                         "button active dataFilter");
                        writer.writeAttribute("value", "active", null);
                        writer.writeText("Active", null);
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc,
                                         "button terminated dataFilter");
                        writer.writeAttribute("value", "terminated", null);
                        writer.writeText("Terminated", null);
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc,
                                         "button denied dataFilter");
                        writer.writeAttribute("value", "denied", null);
                        writer.writeText("Rejected/Denied", null);
                        writer.endElement("div");
                    }
                    writer.endElement("div");
                }
                {
                    writer.startElement("div", component);
                    //renderId(context, component);
                    renderStyleClass(context, arc, "control-time");
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "control-time");
                        {
                            writer.startElement("p", component);
                            //renderId(context, component);
                            writer.writeText("View graph by time", null);
                            writer.endElement("p");
                        }
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc,
                                         "button selected hours timeScale");
                        writer.writeAttribute("value", "hours", null);
                        writer.writeText("Hours", null);
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc,
                                         "button minutes timeScale");
                        writer.writeAttribute("value", "minutes", null);
                        writer.writeText("Minutes", null);
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc,
                                         "button seconds timeScale");
                        writer.writeAttribute("value", "seconds", null);
                        writer.writeText("Seconds", null);
                        writer.endElement("div");
                    }
                    writer.endElement("div");
                }
                writer.endElement("div");
            }
            {
                writer.startElement("div", component);
                //renderId(context, component);
                renderStyleClass(context, arc, "graph-table");
                {
                    writer.startElement("p", component);
                    //renderId(context, component);
                    writer.writeText("Time in ", null);
                    {
                        writer.startElement("span", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "units");
                        writer.writeText("hours", null);
                        writer.endElement("span");
                    }
                    writer.endElement("p");
                }
                {
                    writer.startElement("div", component);
                    //renderId(context, component);
                    renderStyleClass(context, arc, "chrt-Container");
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "hoursHeader timeUnit");
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "minsHeader timeUnit");
                        {
                            writer.startElement("ul", component);
                            //renderId(context, component);
                            //                            renderStyleClass(context, arc, "minsHeader timeUnit");
                            writer.endElement("ul");
                        }
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "secsHeader timeUnit");
                        {
                            writer.startElement("ul", component);
                            //renderId(context, component);
                            //                            renderStyleClass(context, arc, "minsHeader timeUnit");
                            writer.endElement("ul");
                        }
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "chrt");
                        {
                            writer.startElement("div", component);
                            //renderId(context, component);
                            renderStyleClass(context, arc, "graphheader");
                            {
                                writer.startElement("div", component);
                                //renderId(context, component);
                                renderStyleClass(context, arc, "header-inner");
                                writer.endElement("div");
                            }
                            writer.endElement("div");
                        }
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "secsScroller");
                        writer.endElement("div");
                    }
                    writer.endElement("div");

                }
                {
                    writer.startElement("div", component);
                    //renderId(context, component);
                    renderStyleClass(context, arc, "scroller-container");
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "wrapper");
                        {
                            writer.startElement("div", component);
                            //renderId(context, component);
                            renderStyleClass(context, arc,
                                             "button left timeFrame");
                            writer.writeText("<", null);
                            writer.endElement("div");
                        }
                        {
                            writer.startElement("div", component);
                            //renderId(context, component);
                            renderStyleClass(context, arc,
                                             "button right timeFrame");
                            writer.writeText(">", null);
                            writer.endElement("div");
                        }
                        {
                            writer.startElement("div", component);
                            //renderId(context, component);
                            renderStyleClass(context, arc,
                                             "minsHeader-scroller scroller");
                            {
                                writer.startElement("div", component);
                                //renderId(context, component);
                                renderStyleClass(context, arc, "handle");
                                writer.endElement("div");
                            }
                            writer.endElement("div");
                        }
                        {
                            writer.startElement("div", component);
                            //renderId(context, component);
                            renderStyleClass(context, arc,
                                             "secsHeader-scroller scroller");
                            {
                                writer.startElement("div", component);
                                //renderId(context, component);
                                renderStyleClass(context, arc, "handle");
                                writer.endElement("div");
                            }
                            writer.endElement("div");
                        }
                        writer.endElement("div");
                    }
                    writer.endElement("div");
                }
                {
                    writer.startElement("p", component);
                    //renderId(context, component);
                    writer.writeText("Select hours range", null);
                    writer.endElement("p");
                }
                writer.endElement("div");
            }
            {
                writer.startElement("div", component);
                //renderId(context, component);
                renderStyleClass(context, arc, "legend-container");
                {
                    writer.startElement("div", component);
                    //renderId(context, component);
                    renderStyleClass(context, arc, "legend");
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "active");
                        writer.writeText("Active Session", null);
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "terminated");
                        writer.writeText("Terminated Session", null);
                        writer.endElement("div");
                    }
                    {
                        writer.startElement("div", component);
                        //renderId(context, component);
                        renderStyleClass(context, arc, "denied");
                        writer.writeText("Rejected/Denied Session", null);
                        writer.endElement("div");
                    }
                    writer.endElement("div");
                }
                writer.endElement("div");
            }
            writer.endElement("div");
        }
        int i = (Integer)bean.getProperty(_TIME_START);
        {
            {
                ClientEvent clientEvent =
                    this.getClientEvent(context, getClientId(context,
                                                             component),
                                        _CLIENT_SELECT_EVENT_TIME_FRAME_TYPE);
                if (clientEvent != null &&
                    clientEvent.getParameters().get("_timeFrame") != null) {
                    bean.setProperty(_TIME_FRAME,
                                     clientEvent.getParameters().get("_timeFrame"));

                    if (bean.getProperty(_TIME_FRAME) != null) {
                        try {
                            if (i >= 0 &&
                                (Boolean)bean.getProperty(_TIME_FRAME)) {
                                i--;
                            } else if (i < 25) {
                                i++;
                            }
                            bean.setProperty(_TIME_START, i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            {
                ClientEvent clientEvent =
                    this.getClientEvent(context, getClientId(context,
                                                             component),
                                        _CLIENT_SELECT_EVENT_TIME_SCALE_TYPE);
                if (clientEvent != null &&
                    clientEvent.getParameters().get("_timeScale") != null) {
                    bean.setProperty(_TIME_SCALE,
                                     clientEvent.getParameters().get("_timeScale"));
                }
            }
            {
                ClientEvent clientEvent =
                    this.getClientEvent(context, getClientId(context,
                                                             component),
                                        _CLIENT_SELECT_EVENT_DATA_FILTER_TYPE);
                if (clientEvent != null &&
                    clientEvent.getParameters().get("_dataFilter") != null) {
                    bean.setProperty(_DATA_FILTER,
                                     clientEvent.getParameters().get("_dataFilter"));
                }
            }

            String jsScript =
                "$('#" + getClientId(context, component) + "').graphComp(" +
                _getData(bean) + ",{timeUnit:'" +
                (String)bean.getProperty(_TIME_SCALE) + "',eventStatus:'" +
                (String)bean.getProperty(_DATA_FILTER) + "',setSliderHours:" +
                bean.getProperty(_TIME_START) + "});";
            System.out.println(jsScript);
            ADFUtils.runJsScript(jsScript);
        }
    }

    protected String getClientConstructor() {
        return _CLIENT_COMPONENT;
    }

    private String _getData(FacesBean bean) {
        if (_DATA_KEY == null) {
            _DATA_KEY = SessionLogs.TYPE.findKey("data");
        }

        List<SessionDayLogs> dataList =
            (List<SessionDayLogs>)bean.getProperty(_DATA_KEY);
        if (dataList == null) {
            dataList = Collections.emptyList();
        }

        //        return "{\"sessionLogs\": " + dataList + "}";
        return "{ \"obj1\": [{ \"label\": \"01/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 01 00:00:00  2014\", \"endTime\": \"Wed Jan 01 02:47:44  2014\", \"status\": \"denied\", \"taskId\": \"Active_Session_1\", \"taskType\": \"Connected\", \"label\": \"01/01/2014\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"01/01/2014 00:00:00  2014\", \"endTime\": \"01/01/2014 02:47:44  2014\", \"label\": \"ascasc\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 01 02:47:44  2014\", \"endTime\": \"Wed Jan 01 05:47:44  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_1\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"01/01/2014 00:00:00  2014\", \"endTime\": \"01/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 01 05:47:44  2014\", \"endTime\": \"Wed Jan 01 23:59:59  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_1\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"01/01/2014 00:00:00  2014\", \"endTime\": \"01/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"02/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 02 00:00:00  2014\", \"endTime\": \"Wed Jan 02 21:30:15  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_2\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"02/01/2014 00:00:00  2014\", \"endTime\": \"02/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 02 21:30:15  2014\", \"endTime\": \"Wed Jan 02 22:00:00  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_2\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"02/01/2014 00:00:00  2014\", \"endTime\": \"02/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 02 22:00:00  2014\", \"endTime\": \"Wed Jan 02 23:59:59  2014\", \"status\": \"denied\", \"taskId\": \"Active_Session_2\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"02/01/2014 00:00:00  2014\", \"endTime\": \"02/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"--------------\", \"statusList\": [{ \"startTime\": \"Wed Jan 03 00:00:00  2014\", \"endTime\": \"Wed Jan 03 05:00:00  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_3\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"03/01/2014 00:00:00  2014\", \"endTime\": \"03/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 03 05:00:00  2014\", \"endTime\": \"Wed Jan 03 08:12:33  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_2\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"03/01/2014 00:00:00  2014\", \"endTime\": \"03/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 03 08:12:33  2014\", \"endTime\": \"Wed Jan 03 23:59:59  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_3\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"03/01/2014 00:00:00  2014\", \"endTime\": \"03/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"04/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 04 00:00:00  2014\", \"endTime\": \"Wed Jan 04 20:00:00  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_4\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"04/01/2014 00:00:00  2014\", \"endTime\": \"04/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 04 20:00:00  2014\", \"endTime\": \"Wed Jan 04 23:59:59  2014\", \"status\": \"denied\", \"taskId\": \"Active_Session_4\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"04/01/2014 00:00:00  2014\", \"endTime\": \"04/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"05/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 05 00:00:00  2014\", \"endTime\": \"Wed Jan 05 23:59:59  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_5\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"05/01/2014 00:00:00  2014\", \"endTime\": \"05/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"06/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 06 00:00:00  2014\", \"endTime\": \"Wed Jan 06 00:30:00  2014\", \"status\": \"denied\", \"taskId\": \"Active_Session_6\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"06/01/2014 00:00:00  2014\", \"endTime\": \"06/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 06 00:30:00  2014\", \"endTime\": \"Wed Jan 06 16:00:00  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_6\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"06/01/2014 00:00:00  2014\", \"endTime\": \"06/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 06 16:00:00  2014\", \"endTime\": \"Wed Jan 06 23:59:59  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_6\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"06/01/2014 00:00:00  2014\", \"endTime\": \"06/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"07/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 07 00:00:00  2014\", \"endTime\": \"Wed Jan 07 20:00:00  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_7\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"07/01/2014 00:00:00  2014\", \"endTime\": \"07/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 07 20:00:00  2014\", \"endTime\": \"Wed Jan 07 23:59:59 2014\", \"status\": \"active\", \"taskId\": \"Active_Session_7\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"07/01/2014 00:00:00  2014\", \"endTime\": \"07/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"08/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 08 00:00:00  2014\", \"endTime\": \"Wed Jan 08 02:47:44  2014\", \"status\": \"denied\", \"taskId\": \"Active_Session_1\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"08/01/2014 00:00:00  2014\", \"endTime\": \"08/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 08 02:47:44  2014\", \"endTime\": \"Wed Jan 08 05:47:44  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_1\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"08/01/2014 00:00:00  2014\", \"endTime\": \"08/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 08 05:47:44  2014\", \"endTime\": \"Wed Jan 08 23:59:59  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_1\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"08/01/2014 00:00:00  2014\", \"endTime\": \"08/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"09/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 09 00:00:00  2014\", \"endTime\": \"Wed Jan 09 21:30:15  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_2\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"09/01/2014 00:00:00  2014\", \"endTime\": \"09/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 09 21:30:15  2014\", \"endTime\": \"Wed Jan 09 22:00:00  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_2\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"09/01/2014 00:00:00  2014\", \"endTime\": \"09/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 09 22:00:00  2014\", \"endTime\": \"Wed Jan 09 23:59:59  2014\", \"status\": \"denied\", \"taskId\": \"Active_Session_2\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"09/01/2014 00:00:00  2014\", \"endTime\": \"09/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"10/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 10 00:00:00  2014\", \"endTime\": \"Wed Jan 10 05:00:00  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_3\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"10/01/2014 00:00:00  2014\", \"endTime\": \"10/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 10 05:00:00  2014\", \"endTime\": \"Wed Jan 10 08:12:33  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_2\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"10/01/2014 00:00:00  2014\", \"endTime\": \"10/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 10 08:12:33  2014\", \"endTime\": \"Wed Jan 10 23:59:59  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_3\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"10/01/2014 00:00:00  2014\", \"endTime\": \"10/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"--------------\", \"statusList\": [{ \"startTime\": \"Wed Jan 11 00:00:00  2014\", \"endTime\": \"Wed Jan 11 20:00:00  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_4\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"11/01/2014 00:00:00  2014\", \"endTime\": \"11/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 11 20:00:00  2014\", \"endTime\": \"Wed Jan 11 23:59:59  2014\", \"status\": \"denied\", \"taskId\": \"Active_Session_4\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"11/01/2014 00:00:00  2014\", \"endTime\": \"11/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"12/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 12 00:00:00  2014\", \"endTime\": \"Wed Jan 12 23:59:59  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_5\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"12/01/2014 00:00:00  2014\", \"endTime\": \"12/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"13/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 13 00:00:00  2014\", \"endTime\": \"Wed Jan 13 00:30:00  2014\", \"status\": \"denied\", \"taskId\": \"Active_Session_6\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"13/01/2014 00:00:00  2014\", \"endTime\": \"13/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 13 00:30:00  2014\", \"endTime\": \"Wed Jan 13 16:00:00  2014\", \"status\": \"active\", \"taskId\": \"Active_Session_6\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"13/01/2014 00:00:00  2014\", \"endTime\": \"13/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 13 16:00:00  2014\", \"endTime\": \"Wed Jan 13 23:59:59  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_6\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"13/01/2014 00:00:00  2014\", \"endTime\": \"13/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }, { \"label\": \"14/01/2014\", \"statusList\": [{ \"startTime\": \"Wed Jan 14 00:00:00  2014\", \"endTime\": \"Wed Jan 14 20:00:00  2014\", \"status\": \"terminated\", \"taskId\": \"Active_Session_7\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"14/01/2014 00:00:00  2014\", \"endTime\": \"14/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }, { \"startTime\": \"Wed Jan 14 20:00:00  2014\", \"endTime\": \"Wed Jan 14 23:59:59 2014\", \"status\": \"active\", \"taskId\": \"Active_Session_7\", \"taskType\": \"Connected\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null, \"miscData\": { \"startTime\": \"14/01/2014 00:00:00  2014\", \"endTime\": \"14/01/2014 02:47:44  2014\", \"label\": \"null\", \"realm\": \"Vodafone\", \"remark\": \"Bogus\", \"username\": \"Test\", \"timeStamp\": null } }] }] }";
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
        _DATA_KEY = type.findKey("data");
        metadata.addSecureProperty(_DATA_KEY);
        _DATA_FILTER = type.findKey("dataFilter");
        metadata.addSecureProperty(_DATA_FILTER);
        _TIME_FRAME = type.findKey("timeFrame");
        metadata.addSecureProperty(_TIME_FRAME);
        _TIME_SCALE = type.findKey("timeScale");
        metadata.addSecureProperty(_TIME_SCALE);
        _TIME_START = type.findKey("timeStart");
        metadata.addSecureProperty(_TIME_START);

    }


    @Override
    public void decodeInternal(FacesContext facesContext,
                               UIComponent uIComponent, String string) {
        super.decodeInternal(facesContext, uIComponent, string);

    }

}
