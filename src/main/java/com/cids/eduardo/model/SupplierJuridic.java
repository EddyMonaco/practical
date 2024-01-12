package com.cids.eduardo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("JURIDIC_TYPE")
public class SupplierJuridic extends Supplier{

    private int cnpj;

    public SupplierJuridic(){

    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
}
