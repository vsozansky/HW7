package com.ithillel.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_account", allocationSize = 1)
public class AccountEntity extends CommonEntity {

    @Column(name = "name")
    @Convert(converter = CryptoConverter.class)
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "account")
    //@JoinTable(name = "client_account", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
    //@JoinColumn(name = "account_id")
    private List<ClientEntity> clients = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClientEntity> getClients() {
        return clients;
    }

    public void setClients(List<ClientEntity> clients) {
        this.clients = clients;
    }
}
