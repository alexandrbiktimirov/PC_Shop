package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Thread")
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Message> messages;
}
