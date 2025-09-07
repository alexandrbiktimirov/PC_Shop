package org.example.custompcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ram")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ram{

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
    @CollectionTable(name = "ram_images", joinColumns = @JoinColumn(name = "ram_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToMany(mappedBy = "rams")
    private List<Order> orders;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "total_capacity_size", nullable = false)
    private int totalCapacitySize;

    @Column(name = "speed_mhz", nullable = false)
    private int speedMhz;
}