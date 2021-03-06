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
 * @description : Class User Information
 * @since : 23/05/2020 - 11:22
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "UserInformation")
@Table(name = "user_information")
public class UserInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer gender;

    @Column(unique = true)
    private String phone;

    @Column
    private Integer status;

    @OneToOne
    private Address address;

    @OneToOne
    private User user;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;
}
