package com.ads.voteapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor @NoArgsConstructor @Entity
@Table(name = "db_session")
public class Session {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_session_generator")
    @SequenceGenerator(name = "db_session_generator", sequenceName = "db_session_seq", allocationSize = 1)
    private Long id;
    private Integer status;
    @Column(name = "start_session")
    private Instant startSession;
    @Column(name = "end_session")
    private Instant endSession;
    private Instant createdAt;
    private Instant updatedAt;

    @OneToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private Schedule schedule;

    @OneToMany(mappedBy = "session")
    @ToString.Exclude
    private List<Vote> votes;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = Instant.now();
        this.startSession = Instant.now();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = Instant.now();
    }
}
