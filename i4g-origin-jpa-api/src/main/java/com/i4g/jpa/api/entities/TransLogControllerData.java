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
@Table(name = "trans_log_controller_data")
@Data
@NoArgsConstructor
public class TransLogControllerData implements Serializable {
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

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "request_method")
    private String requestMethod;

    @Column(name = "request_uri")
    private String requestURI;

    @Column(name = "message_timestamp")
    private String messageTimestamp;

    @Column(name = "request_json")
    private String requestJson;

    @Column(name = "response_json")
    private String responseJson;

    @Column(name = "status_id")
    private Integer statusId;

    @Column
    private String username;

    @ManyToOne
    @JoinColumn(name = "trans_log_id")
    private TransLog transLog;
}
