package org.example.custompcbuilder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cooling")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cooling{
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
    @CollectionTable(name = "cooling_images", joinColumns = @JoinColumn(name = "cooling_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;

    @ManyToMany(mappedBy = "coolings")
    private List<Order> orders;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "supported_sockets", nullable = false)
    private String supportedSockets;

    @Column(name = "tdp_watts_rating")
    private int tdpWattsRating;

    @OneToMany(mappedBy = "cooling", fetch = FetchType.LAZY)
    private List<Build> builds;
}