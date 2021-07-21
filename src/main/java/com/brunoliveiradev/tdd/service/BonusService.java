package com.brunoliveiradev.tdd.service;

import com.brunoliveiradev.tdd.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));

		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionário com salário maior que R$ 10.000,00 não pode receber bônus!");
		}

		return valor.setScale(2, RoundingMode.HALF_UP);
	}
}