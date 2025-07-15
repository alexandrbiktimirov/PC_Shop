package org.example.custompcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "psu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Psu{

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
    @CollectionTable(name = "psu_images", joinColumns = @JoinColumn(name = "psu_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToMany(mappedBy = "psus")
    private List<Order> orders;

    @Column(name = "wattage",nullable = false)
    private int wattage;

    @Column(name = "form_factor", nullable = false)
    private String formFactor;

    @OneToMany(mappedBy = "psu", fetch = FetchType.LAZY)
    private List<Build> builds;
}
