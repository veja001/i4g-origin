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
@Table(name = "language_keywords")
@Data
@NoArgsConstructor
public class LanguageKeyword implements Serializable {
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
    @JoinColumn(name = "operation_type_id")
    private OperationType operationType;

    @Column(name = "keyword_name")
    private String keywordName;

    @Column(name = "keyword_value")
    private String keywordValue;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
