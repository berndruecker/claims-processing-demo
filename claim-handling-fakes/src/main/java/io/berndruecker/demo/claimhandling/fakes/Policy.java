package io.berndruecker.demo.claimhandling.fakes;

import java.util.Date;

public class Policy {
    private String id;
    private String customerId;
    private String coverageType;
    private Date startDate;
    private String muchMoreInformation;

    public String getId() {
        return id;
    }

    public Policy setId(String id) {
        this.id = id;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Policy setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public Policy setCoverageType(String coverageType) {
        this.coverageType = coverageType;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Policy setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getMuchMoreInformation() {
        return muchMoreInformation;
    }

    public Policy setMuchMoreInformation(String muchMoreInformation) {
        this.muchMoreInformation = muchMoreInformation;
        return this;
    }

}
