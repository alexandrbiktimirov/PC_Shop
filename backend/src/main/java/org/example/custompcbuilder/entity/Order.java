package org.example.custompcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "\"order\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "date_of_delivery")
    private LocalDateTime dateOfDelivery;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_cpu",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "cpu_id")
    )
    private List<Cpu> cpus;

    @ManyToMany
    @JoinTable(
            name = "order_gpu",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "gpu_id")
    )
    private List<Gpu> gpus;

    @ManyToMany
    @JoinTable(
            name = "order_ram",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "ram_id")
    )
    private List<Ram> rams;

    @ManyToMany
    @JoinTable(
            name = "order_storage",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "storage_id")
    )
    private List<Storage> storages;

    @ManyToMany
    @JoinTable(
            name = "order_motherboard",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "motherboard_id")
    )
    private List<Motherboard> motherboards;

    @ManyToMany
    @JoinTable(
            name = "order_cooling",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "cooling_id")
    )
    private List<Cooling> coolings;

    @ManyToMany
    @JoinTable(
            name = "order_psu",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "psu_id")
    )
    private List<Psu> psus;

    @ManyToMany
    @JoinTable(
            name = "order_case",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "case_id")
    )
    private List<Case> cases;
}
