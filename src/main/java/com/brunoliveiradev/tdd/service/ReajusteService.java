package com.brunoliveiradev.tdd.service;

import com.brunoliveiradev.tdd.model.Desempenho;
import com.brunoliveiradev.tdd.model.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void reajustarSalario(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal percentualReajuste = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentualReajuste);

        funcionario.ajusteSalarial(reajuste);
    }
}
