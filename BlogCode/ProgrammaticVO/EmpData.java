
public class EmpData {
    public EmpData() {
        super();
    }
    private String IDC;
    private String USR_CODE;
    private String EMP_NAME;
    private String DOB;
    private String EMP_CLASS;
    private String EMP_ADDRESS;

    public void setIDC(String IDC) {
        this.IDC = IDC;
    }

    public String getIDC() {
        return IDC;
    }

    public void setUSR_CODE(String USR_CODE) {
        this.USR_CODE = USR_CODE;
    }

    public String getUSR_CODE() {
        return USR_CODE;
    }

    public void setEMP_NAME(String EMP_NAME) {
        this.EMP_NAME = EMP_NAME;
    }

    public String getEMP_NAME() {
        return EMP_NAME;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDOB() {
        return DOB;
    }

    public void setEMP_CLASS(String EMP_CLASS) {
        this.EMP_CLASS = EMP_CLASS;
    }

    public String getEMP_CLASS() {
        return EMP_CLASS;
    }

    public void setEMP_ADDRESS(String EMP_ADDRESS) {
        this.EMP_ADDRESS = EMP_ADDRESS;
    }

    public String getEMP_ADDRESS() {
        return EMP_ADDRESS;
    }

    @Override
    public String toString() {
        return getIDC() + " : " + getUSR_CODE();
    }
}
