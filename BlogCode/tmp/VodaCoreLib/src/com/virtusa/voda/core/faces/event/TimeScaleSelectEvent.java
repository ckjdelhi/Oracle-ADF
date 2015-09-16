package com.virtusa.voda.core.faces.event;

import javax.faces.component.UIComponent;
import javax.faces.event.FacesEvent;
import javax.faces.event.FacesListener;

public class TimeScaleSelectEvent extends FacesEvent {

    public boolean isAppropriateListener(FacesListener facesListener) {
        return false;
    }
    private String timeScale;

    public void processListener(FacesListener facesListener) {
    }

    public TimeScaleSelectEvent(UIComponent source, String timeScale) {
        super(source);
        this.timeScale=timeScale;
    }

    public String getTimeScale() {
        return timeScale;
    }
}
