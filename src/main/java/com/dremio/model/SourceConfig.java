package com.dremio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SourceConfig implements BaseModel {
    private String username;
    private String password;
    private String hostname;
    private String port;
    private String authenticationType;
    private Integer fetchSize;
    private String databaseName;
}
