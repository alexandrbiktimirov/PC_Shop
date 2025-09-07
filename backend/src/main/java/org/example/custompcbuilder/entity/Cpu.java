package org.example.custompcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cpu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ElementCollection
    @CollectionTable(name = "cpu_images", joinColumns = @JoinColumn(name = "cpu_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToMany(mappedBy = "cpus")
    private List<Order> orders;

    @Column(name = "socket_type", nullable = false)
    private String socketType;

    @Column(name = "core_count", nullable = false)
    private int coreCount;

    @Column(name = "thread_count", nullable = false)
    private int threadCount;

    @Column(name = "tdp_watts", nullable = false)
    private int tdpWatts;
}
