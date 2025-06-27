package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ram")
public class Ram extends Component{

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "total_capacity_size", nullable = false)
    private int totalCapacitySize;

    @Column(name = "speed_mhz", nullable = false)
    private int speedMhz;

    @OneToMany(mappedBy = "ram", fetch = FetchType.LAZY)
    private List<Build> builds;
}