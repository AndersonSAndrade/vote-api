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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.Instant;

/**
 * @author : andersons.andrade
 * @since : 18/11/21, quinta-feira
 **/
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_result_vote")
public class ResultVote {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_result_vote_generator")
    @SequenceGenerator(name = "db_result_vote_generator", sequenceName = "db_result_vote_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vote_id", referencedColumnName = "id")
    private Vote vote;
    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private Schedule scheduleId;
    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session sessionId;
    @Column(name = "voting")
    private Integer voting;
    private Instant createdAt;
    private Instant updatedAt;


    @PrePersist
    public void setCreatedAt() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = Instant.now();
    }
}

