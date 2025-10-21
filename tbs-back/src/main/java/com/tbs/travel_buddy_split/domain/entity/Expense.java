package com.tbs.travel_buddy_split.domain.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity @Table(name = "expenses")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Expense {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "payer_id", nullable = false)
    private User payer;

    @Column(nullable = false, length = 180) private String title;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Lob private String notes;
}
