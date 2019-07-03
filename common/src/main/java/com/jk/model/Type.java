package com.jk.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Type implements Serializable {
    private Integer  typeId;
    private String   typeName;
}
