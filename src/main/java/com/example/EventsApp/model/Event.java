package com.example.EventsApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.ldap.LdapName;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="event")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    String name;

    @Column
    String description;

    @Column
    String date;

    @Column
    String time;

    @Column
    String location;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="staff_id")
    Staff staff;

    @ManyToMany(mappedBy = "events")
    private Set<User> attendees = new HashSet<>();



}
