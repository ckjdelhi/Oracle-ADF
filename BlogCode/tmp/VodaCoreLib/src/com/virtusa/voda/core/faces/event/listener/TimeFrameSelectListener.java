package com.virtusa.voda.core.faces.event.listener;

import com.virtusa.voda.core.faces.event.TimeFrameSelectEvent;

import javax.faces.event.FacesListener;
import javax.faces.event.AbortProcessingException;

public interface TimeFrameSelectListener extends FacesListener {
    public void processTimeFrameSelect(TimeFrameSelectEvent event) throws AbortProcessingException;
}
