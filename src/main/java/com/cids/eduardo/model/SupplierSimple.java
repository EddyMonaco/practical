package com.cids.eduardo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SIMPLE_TYPE")
public class SupplierSimple extends Supplier{

    private int cpf;

    public SupplierSimple() {
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
