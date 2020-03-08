package com.sainath.lang;

import java.util.Objects;

public class Company {
    private int companyId;
    private String companyName;
    private String companyLocation;

    public Company(int companyId, String companyName, String companyLocation) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyLocation = companyLocation;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return companyId == company.companyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId);
    }
}
