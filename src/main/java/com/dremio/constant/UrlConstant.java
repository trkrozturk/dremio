package com.dremio.constant;

public enum UrlConstant {
    CATALOG("api/v3/catalog"),
    LOGIN("apiv2/login"),
    SQL("api/v3/sql"),
    JOB("api/v3/job"),
    REFLECTION("api/v3/reflection");

    public final String label;

    UrlConstant(String label) {
        this.label = label;
    }
}
