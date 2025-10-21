package com.tbs.travel_buddy_split.domain.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity @Table(name = "accommodations")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Accommodation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(nullable = false, length = 180) private String name;
    // @Lob
    @Column(columnDefinition = "text")
    private String address;

    @Column(name = "check_in") private OffsetDateTime checkIn;
    @Column(name = "check_out") private OffsetDateTime checkOut;

    // @Lob
    @Column(columnDefinition = "text")
    private String notes;
}
