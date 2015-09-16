package com.virtusa.voda.core.data.sessionLogs;


import com.virtusa.voda.core.data.BaseData;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class SessionLogsData<E extends Object> extends BaseData {
    public SessionLogsData() {
        super();
        miscData = new ArrayList<E>();
    }

    private String startTime, endTime;
    private String status;
    private List<E> miscData;

    public void setStartTime(Date start) {
        this.startTime =
                new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy").format(start);
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(Date end) {
        this.endTime =
                new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy").format(end);
    }

    public String getEndTime() {
        return endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMiscData(List<E> miscData) {
        this.miscData = miscData;
    }

    public List<E> getMiscData() {
        return miscData;
    }
}
