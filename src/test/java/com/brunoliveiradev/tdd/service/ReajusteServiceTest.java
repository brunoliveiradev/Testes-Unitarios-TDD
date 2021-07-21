package com.brunoliveiradev.tdd.service;

import com.brunoliveiradev.tdd.model.Desempenho;
import com.brunoliveiradev.tdd.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {

    @Test
    @DisplayName("Reajuste Deveria ser 3% para Desempenho a Desenvolver")
    void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoADesejar(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));

        service.reajustarSalario(funcionario, Desempenho.DESENVOLVER);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
 
    @Test
    @DisplayName("Reajuste Deveria ser 15% para Desempenho Bom")
    void reajusteDeveriaSerQuinzePorcentoQuandoDesempenhoForBom(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));

        service.reajustarSalario(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    
    @Test
    @DisplayName("Reajuste deveria ser 20% para Desempenho Excelente")
    void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForExcelente(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));

        service.reajustarSalario(funcionario, Desempenho.EXCELENTE);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
