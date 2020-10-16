package webshop.carparts;

import java.math.BigDecimal;

public class StoreUser {
    private String userId;
    private String companyName;
    private String companyVat;
    private BigDecimal registrationNumber;
    private String companyAddress;
    private String contactName;
    private String email;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyVat() {
        return companyVat;
    }

    public void setCompanyVat(String companyVat) {
        this.companyVat = companyVat;
    }

    public BigDecimal getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(BigDecimal registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
