package com.i4g.jpa.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
public class Company implements Serializable {
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

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CompanyType type;

    @ManyToOne
    @JoinColumn(name = "default_language_id")
    private Language defaultLanguage;

    @Column(name = "contact_person_first_name")
    private String contactPersonFirstName;

    @Column(name = "conact_person_surname")
    private String contactPersonSurname;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column
    private String website;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @ManyToMany
    @JoinColumn(name = "land_line_code")
    private List<Contact> contacts;

    @Column
    private String location;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
