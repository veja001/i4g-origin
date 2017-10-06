package com.i4g.jpa.api.entities;

import com.i4g.jpa.api.entities.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "profiles")
@Data
@NoArgsConstructor
public class Profile implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "id_number")
    private String idNumber;

    @ManyToOne
    @JoinColumn(name = "mobile_id")
    private Contact mobile;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
