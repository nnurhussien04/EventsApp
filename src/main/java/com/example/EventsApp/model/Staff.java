package com.example.EventsApp.model;

import com.example.EventsApp.EventsAppApplication;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff {
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

    @Column
    String role;

    @JsonIgnore
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    List<Event> events;

}
