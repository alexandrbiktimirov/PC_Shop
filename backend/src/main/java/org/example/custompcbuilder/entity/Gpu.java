package org.example.custompcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "gpu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gpu{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "model_name", nullable = false)
    protected String modelName;

    @Column(name = "brand", nullable = false)
    protected String brand;

    @Column(name = "price", nullable = false)
    protected BigDecimal price;

    @Column(name = "quantity", nullable = false)
    protected int quantity;

    @ElementCollection
    @CollectionTable(name = "gpu_images", joinColumns = @JoinColumn(name = "gpu_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToMany(mappedBy = "gpus")
    private List<Order> orders;

    @Column(name = "memory_size_gb", nullable = false)
    private int memorySizeGb;

    @Column(name = "tdp_watts", nullable = false)
    private int tdpWatts;

    @Column(name = "length_mm", nullable = false)
    private int lengthMm;

    @OneToMany(mappedBy = "gpu", fetch = FetchType.LAZY)
    private List<Build> builds;
}
