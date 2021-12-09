package com.wb.negocio;

import java.util.Comparator;

import com.wb.modelo.Cliente;

public class ComparadorValorConsumo implements Comparator<Cliente> {

    public int compare(Cliente o1, Cliente o2) {
        o1.setConsumoTotal();
        o2.setConsumoTotal();
        return o1.getConsumoTotal().compareTo(o2.getConsumoTotal());
    }
}
