package org.example.custompcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "\"case\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Case{
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
    @CollectionTable(name = "case_images", joinColumns = @JoinColumn(name = "case_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToMany(mappedBy = "cases")
    private List<Order> orders;

    @Column(name = "form_factor_support", nullable = false)
    private String formFactorSupport;

    @Column(name = "max_gpu_length_mm", nullable = false)
    private int maxGpuLengthMm;

    @OneToMany(mappedBy = "pcCase", fetch = FetchType.LAZY)
    private List<Build> builds;
}