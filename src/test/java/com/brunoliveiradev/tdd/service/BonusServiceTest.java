package com.brunoliveiradev.tdd.service;

import com.brunoliveiradev.tdd.model.Funcionario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {

    @Test
    @DisplayName("Bonus Deveria Ser Zero Para Funcionarios Com Salarios > 10k")
    void bonusDeveriaSerZero(){
        BonusService service = new BonusService();
        Funcionario funcionario = new Funcionario("Joao", LocalDate.now(), new BigDecimal(10001));

        // Exception recebida, lambda com método a ser chamado
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(funcionario));
    }

    @Test
    @DisplayName("Bonus Deveria Ser Dez Por Cento Do Salario Para Funcionarios Com Salarios < 10k")
    void bonusDeveriaSerDezPorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Joao", LocalDate.now(), new BigDecimal(2500)));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    @DisplayName("Bonus Deveria Ser Dez Por Cento Para Salario Iguais a 10k")
    void bonusDeveriaSerDezPorCentoParaSalarioDeDezMil(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Joao", LocalDate.now(), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}