package com.virtusa.voda.core.faces.resource;

import java.util.ListResourceBundle;

public class VodaSimpleDesktopBundle extends ListResourceBundle {
    public VodaSimpleDesktopBundle() {
        super();
    }

    protected Object[][] getContents() {
        System.out.println("getContents");
        return new Object[0][0];
    }
}
