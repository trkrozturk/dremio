package com.dremio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dataset implements BaseModel {
    private String entityType = "dataset";
    private String[] path;
    private String type;
    private String sql;
    private String[] sqlContext;
}
