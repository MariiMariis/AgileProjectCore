package com.agile.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Currency;

public class ProjectFinancials {

    private final BigDecimal budget;
    private final Currency currency;
    private final LocalDateTime approvedAt;

    public ProjectFinancials(BigDecimal budget, String currencyCode) {
        if (budget.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Orçamento não pode ser negativo");
        }
        // Garante precisão monetária (2 casas decimais)
        this.budget = budget.setScale(2, RoundingMode.HALF_EVEN);
        this.currency = Currency.getInstance(currencyCode);
        this.approvedAt = LocalDateTime.now();
    }

    public BigDecimal getBudget() { return budget; }
    public String getCurrencyCode() { return currency.getCurrencyCode(); }
    public LocalDateTime getApprovedAt() { return approvedAt; }
}