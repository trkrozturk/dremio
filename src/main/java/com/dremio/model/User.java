package com.dremio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements BaseModel {
    private String userName;
    private String password;
}
