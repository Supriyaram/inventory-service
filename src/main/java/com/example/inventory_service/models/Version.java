package com.example.inventory_service.models;

public class Version {
    private String version;
    private String service;

    public Version(String version, String service) {
        this.version = version;
        this.service = service;
    }

    public Version(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
