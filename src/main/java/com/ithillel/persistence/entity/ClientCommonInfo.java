package com.ithillel.persistence.entity;

import javax.persistence.*;

@Embeddable
public class ClientCommonInfo {

    @Column(name = "client_type")
    @Enumerated(value = EnumType.STRING)
    private ClientType clientType;

    @Column(name = "desc")
    @Convert(converter = CryptoConverter.class)
    private String addintionInfo;

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getDescription() {
        return addintionInfo;
    }

    public void setDescription(String description) {
        this.addintionInfo = description;
    }
}
