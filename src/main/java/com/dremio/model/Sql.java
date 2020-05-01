package com.dremio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sql implements BaseModel {
    private String sql;
}
