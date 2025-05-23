package com.example.EventsApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    String first_name;

    @Column
    String last_name;

    @Column
    LocalDate birth_date;

    @Column
    String emailAddress;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    String password;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "customer_event",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"),
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {"customer_id", "event_id"})
    )
    Set<Event> events = new HashSet<>();
}
