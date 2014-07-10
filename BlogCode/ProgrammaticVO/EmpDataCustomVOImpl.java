package model;


import java.sql.ResultSet;

import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;

public class EmpDataCustomVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public EmpDataCustomVOImpl() {
    }

    /**
     * executeQueryForCollection - overridden for custom java data source support.
     */
    protected void executeQueryForCollection(Object qc, Object[] params,
                                             int noUserParams) {
        ProxyDataSourceObject sl = new ProxyDataSourceObject(getOrderByClause());
        sl.setDataFromService();
        setUserDataForCollection(qc, sl);
        super.executeQueryForCollection(qc, params, noUserParams);

    }

    /**
     * hasNextForCollection - overridden for custom java data source support.
     */
    protected boolean hasNextForCollection(Object qc) {
        //        boolean bRet = super.hasNextForCollection(qc);
        //        return bRet;
        if (((ProxyDataSourceObject)getUserDataForCollection(qc)).getIterator().hasNext())
            return true;
        else {
            setFetchCompleteForCollection(qc, true);
            return false;
        }

    }

    /**
     * createRowFromResultSet - overridden for custom java data source support.
     */
    protected ViewRowImpl createRowFromResultSet(Object qc,
                                                 ResultSet resultSet) {
        //        ViewRowImpl value = super.createRowFromResultSet(qc, resultSet);
        //        return value;

        ViewRowImpl row = createNewRowForCollection(qc);
        EmpData nextRow =
            (EmpData)((ProxyDataSourceObject)getUserDataForCollection(qc)).getIterator().next();
        populateAttributeForRow(row, 0, nextRow.getIDC());
        populateAttributeForRow(row, 1, nextRow.getUSRCODE());
        populateAttributeForRow(row, 2, nextRow.getEMPNAME());
        populateAttributeForRow(row, 3, nextRow.getDOB());
        populateAttributeForRow(row, 4, nextRow.getEMPCLASS());
        populateAttributeForRow(row, 5, nextRow.getEMPADDRESS());
        return row;
    }

    /**
     * getQueryHitCount - overridden for custom java data source support.
     */
    public long getQueryHitCount(ViewRowSetImpl viewRowSet) {
        return ((ProxyDataSourceObject)getUserDataForCollection(viewRowSet.getQueryCollection())).getData().size();

    }

    @Override
    protected void create() {
        super.create();
        getViewDef().setQuery(null);
        getViewDef().setSelectClause(null);
        setQuery(null);
    }
}
