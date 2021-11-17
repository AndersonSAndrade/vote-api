package com.ads.voteapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor @NoArgsConstructor @Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_schedule_seq")
    @SequenceGenerator(name = "db_schedule_seq", sequenceName = "vavlpmueglpnbv")
    private Long id;
    @NotNull(message = "Named is not null.")
    private String name;
    @NotNull(message = "Description is not null.")
    private String description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Schedule schedule = (Schedule) o;
        return id != null && Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
