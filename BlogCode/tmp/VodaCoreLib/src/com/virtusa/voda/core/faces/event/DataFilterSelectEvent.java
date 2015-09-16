package com.virtusa.voda.core.faces.event;

import javax.faces.component.UIComponent;
import javax.faces.event.FacesEvent;
import javax.faces.event.FacesListener;

public class DataFilterSelectEvent extends FacesEvent {
    public DataFilterSelectEvent(UIComponent source, String dataFilter) {
        super(source);
        this.dataFilter = dataFilter;
    }
    private String dataFilter;

    public boolean isAppropriateListener(FacesListener facesListener) {
        return false;
    }

    public void processListener(FacesListener facesListener) {
    }

    public String getDataFilter() {
        return dataFilter;
    }
}
