package com.virtusa.voda.core.faces.event;

import javax.faces.component.UIComponent;
import javax.faces.event.FacesEvent;
import javax.faces.event.FacesListener;


public class TimeFrameSelectEvent extends FacesEvent {
    public boolean isAppropriateListener(FacesListener facesListener) {
        return false;
    }
    private String timeFrame;

    public void processListener(FacesListener facesListener) {
    }

    public TimeFrameSelectEvent(UIComponent source, String timeFrame) {
        super(source);
        this.timeFrame = timeFrame;
    }

    public String getTimeFrame() {
        return timeFrame;
    }
}
