package com.fintech.taskunite.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author : trinh
 * @version : 1.0.1
 * @description : Class Room
 * @since : 23/05/2020 - 12:43
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "Room")
@Table(name = "room")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @ManyToOne
    private Tasker tasker;

    @ManyToOne
    private Master master;

    @OneToOne(mappedBy = "room")
    private Task task;
}
