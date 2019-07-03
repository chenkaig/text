package com.jk.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Author implements Serializable {
    private Integer  authorId;
    private String   author;
}
