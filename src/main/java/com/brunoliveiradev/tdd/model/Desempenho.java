package com.brunoliveiradev.tdd.model;

import java.math.BigDecimal;

public enum Desempenho {

    DESENVOLVER{
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    },
    EXCELENTE {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.2");
        }
    };

    public abstract BigDecimal percentualReajuste();
}
