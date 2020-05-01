package com.dremio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Source implements BaseModel {
    private String entityType;
    private String type;
    private String name;
    private SourceConfig config;

}
