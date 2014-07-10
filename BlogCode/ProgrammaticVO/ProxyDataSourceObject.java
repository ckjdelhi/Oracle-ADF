
import EmpData;//Custom Bean Class

import java.util.Iterator;
import java.util.List;

public class ProxyDataSourceObject extends oracle.jbo.server.ViewObjectImpl {

    public ProxyDataSourceObject() {
        super();
    }

    public ProxyDataSourceObject(String pOrderByClause) {
        super();
    }
    private String orderByClause;
    private List<EmpData> data;
    private Iterator iterator;


    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setData(List<EmpData> data) {
        this.data = data;
    }

    public List<EmpData> getData() {
        return data;
    }

    public Iterator getIterator() {
        if (iterator == null)
            iterator = data.iterator();
        return iterator;
    }

    public void setDataFromService() {
        //Custom Logic to populate the Data List
    }
   
}
