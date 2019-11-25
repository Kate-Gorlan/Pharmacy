package pharmacy.common;

public class ClientMed {

    private String date;
    private String medicamentName;
    private long id;
    private String client;
    private String clientPhone;

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getMedicamentName() {
        return medicamentName;
    }
    public void setMedicamentName(String medicamentName) {
        this.medicamentName = medicamentName;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public String getClientPhone() {
        return clientPhone;
    }
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }
}
