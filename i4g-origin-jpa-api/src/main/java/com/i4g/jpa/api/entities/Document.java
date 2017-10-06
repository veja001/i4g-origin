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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
public class Document implements Serializable {
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

    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @Column(name = "upload_name")
    private String uploadName;

    @Column(name = "upload_description")
    private String uploadDescription;

    @Column(name = "repository_code")
    private String repositoryCode;

    @Column
    private Boolean verified;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
