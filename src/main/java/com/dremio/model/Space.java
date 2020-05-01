package com.dremio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Space implements BaseModel {
    private String entityType = "space";
    private String name;
}
