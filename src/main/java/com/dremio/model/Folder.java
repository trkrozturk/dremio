package com.dremio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Folder implements BaseModel {
    private String entityType = "folder";
    private String[] path;
}
