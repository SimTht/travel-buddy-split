package com.tbs.travel_buddy_split.domain.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity @Table(name = "activities")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Activity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(nullable = false, length = 180) private String title;

    @Column(name = "start_at") private OffsetDateTime startAt;
    @Column(name = "end_at") private OffsetDateTime endAt;
    private String location;

    //@Lob
    @Column(columnDefinition = "text")
    private String notes;
}