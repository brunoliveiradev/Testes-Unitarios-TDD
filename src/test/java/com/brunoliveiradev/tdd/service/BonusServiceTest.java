package com.brunoliveiradev.tdd.service;

import com.brunoliveiradev.tdd.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    public void criarService(){
        this.service = new BonusService();
    }

    @Test
    @DisplayName("Bonus Deveria Ser Zero Para Funcionários Com Salários > 10k")
    void bonusDeveriaSerZero(){
        Funcionario funcionario = new Funcionario("Funcionário", LocalDate.now(), new BigDecimal(10001));
        // Exception recebida, lambda com método a ser chamado
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(funcionario));
    }

    @Test
    @DisplayName("Bonus Deveria Ser Dez Por Cento Do Salario Para Funcionários Com Salários < 10k")
    void bonusDeveriaSerDezPorCentoDoSalario(){
        Funcionario funcionario = new Funcionario("funcionário", LocalDate.now(), new BigDecimal(2500));
        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    @DisplayName("Bonus Deveria Ser Dez Por Cento Para Salario Iguais a 10k")
    void bonusDeveriaSerDezPorCentoParaSalarioDeDezMil(){
        Funcionario funcionario = new Funcionario("funcionário", LocalDate.now(), new BigDecimal(10000));
        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}