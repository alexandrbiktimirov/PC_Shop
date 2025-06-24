package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Build")
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psu_id", nullable = false)
    private PSU psu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motherboard_id", nullable = false)
    private Motherboard motherboard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ram_id", nullable = false)
    private RAM ram;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private Case aCase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gpu_id", nullable = false)
    private GPU gpu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpu_id", nullable = false)
    private CPU cpu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cooling_id", nullable = false)
    private Cooling cooling;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Storage_Build",
            joinColumns = @JoinColumn(name = "build_id"),
            inverseJoinColumns = @JoinColumn(name = "storage_id")
    )
    private List<Storage> storages;
}
