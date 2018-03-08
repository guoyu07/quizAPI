package com.group15.core;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntityModel {
    // This is a abstract class that shares common functionality for the entity models
    // As each entity will be using the same method of ID and needs a parameter-less
    // constructor for JPA. Therefore this object we never to init on its own so = abstract.


    // JPA index's these by using a id, the database will be responsible for incrementing
    // i have made this final as it is automatically generated and we do not want anyone to change these.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    // This is for the Http headers ETAG - entity tag
    // This checks to say hey do you have this data already or do it need to send it
    // It saves us from loading in data we don't need to
    @Version
    private Long version;

    protected BaseEntityModel() {
        id = null;
    }
}
