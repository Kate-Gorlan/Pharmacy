package pharmacy.common;

import java.math.BigDecimal;

public class TopOverdueMed {

    private long id;

    private String nameMed;

    private BigDecimal priceMed;

    private String picUri;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameMed() {
        return nameMed;
    }

    public void setNameMed(String nameMed) {
        this.nameMed = nameMed;
    }

    public BigDecimal getPriceMed() {
        return priceMed;
    }

    public void setPriceMed(BigDecimal priceMed) {
        this.priceMed = priceMed;
    }

    public String getPicUri() {
        return picUri;
    }

    public void setPicUri(String picUri) {
        this.picUri = picUri;
    }
}
