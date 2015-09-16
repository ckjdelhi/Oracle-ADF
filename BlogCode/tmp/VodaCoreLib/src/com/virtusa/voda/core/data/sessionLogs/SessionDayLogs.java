package com.virtusa.voda.core.data.sessionLogs;

import com.virtusa.voda.core.data.BaseData;

import java.util.List;

public class SessionDayLogs extends BaseData {
    public SessionDayLogs() {
        super();
    }
    private String label;
    private List<SessionLogsData> statusList;

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setStatusList(List<SessionLogsData> statusList) {
        this.statusList = statusList;
    }

    public List<SessionLogsData> getStatusList() {
        return statusList;
    }
}
