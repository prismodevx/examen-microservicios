package com.mendoza.denunciaservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@Table(name = "denuncias")
@EntityListeners(AuditingEntityListener.class)
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 8)
    private String dni;

    @Column(name = "fechas")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(length = 100)
    private String titulo;

    @Column(length = 200)
    private String direccion;

    @Column(nullable = true, length = 255)
    private String descripcion;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
}
