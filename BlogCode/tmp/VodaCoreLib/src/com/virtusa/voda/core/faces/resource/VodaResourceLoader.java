package com.virtusa.voda.core.faces.resource;

import java.io.IOException;

import java.net.URL;

import org.apache.myfaces.trinidad.resource.ClassLoaderResourceLoader;
import org.apache.myfaces.trinidad.resource.RegexResourceLoader;

public class VodaResourceLoader extends RegexResourceLoader {
    public VodaResourceLoader() {
        super();
        register("(/.*\\.(jpg|gif|png|jpeg))",
                 new ClassLoaderResourceLoader("META-INF"));
    }

    @Override
    protected URL findResource(String string) throws IOException {
        return super.findResource(string);
    }
}
