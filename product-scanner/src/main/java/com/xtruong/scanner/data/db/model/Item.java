package com.xtruong.scanner.data.db.model;

/**
 * Created by truongtx on 8/12/2019
 */
public class Item {

    private Long id;

    private String email;
    private String phonenumber;

    private String barCode;
    private String method; // import | export

    private String createdAt;
    private String updatedAt;

    private int number;
    private double cost;
}
