package com.finantial.manager.transaction.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TRANSACTIONS")
@Getter
@NoArgsConstructor
public class Transaction {

    @Id
    private UUID id;
    @Setter
    @Column(nullable = false, length = 100)
    private String description;
    @Setter
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Recurrence recurrence;
    @Setter
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;
    @Setter
    @Column(nullable = false)
    private short installments;
    @Setter
    @Column(name = "category_id", nullable = false)
    private UUID categoryId;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Transaction(final String description, final Recurrence recurrence, final BigDecimal amount, final short installments, final UUID categoryId) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.recurrence = recurrence;
        this.amount = amount;
        this.installments = installments;
        this.categoryId = categoryId;
    }
}
