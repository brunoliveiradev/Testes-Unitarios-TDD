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

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void criarDependencias() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    @DisplayName("Reajuste Deveria ser 3% para Desempenho a Desenvolver")
    void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoADesejar(){
        service.reajustarSalario(funcionario, Desempenho.DESENVOLVER);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
 
    @Test
    @DisplayName("Reajuste Deveria ser 15% para Desempenho Bom")
    void reajusteDeveriaSerQuinzePorcentoQuandoDesempenhoForBom(){
        service.reajustarSalario(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    
    @Test
    @DisplayName("Reajuste deveria ser 20% para Desempenho Excelente")
    void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForExcelente(){
        service.reajustarSalario(funcionario, Desempenho.EXCELENTE);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
