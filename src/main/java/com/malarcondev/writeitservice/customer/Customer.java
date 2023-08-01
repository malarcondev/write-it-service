package com.malarcondev.writeitservice.customer;

import com.malarcondev.writeitservice.core.ApplicationUser;
import com.malarcondev.writeitservice.notes.Notes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "UUID"
    )
    @Column(nullable = false, updatable = false)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;
    private int age;
    private String address;

    @OneToMany(mappedBy ="customer")
    private Set<Notes> notes;

    public Customer(ApplicationUser applicationUser) {
        this.user = applicationUser;
    }
}
