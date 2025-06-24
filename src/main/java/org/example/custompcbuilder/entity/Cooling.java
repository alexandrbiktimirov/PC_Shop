package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Cooling")
public class Cooling extends Component{
    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "supported_sockets", nullable = false)
    private String supportedSockets;

    @Column(name = "tdp_watts_rating")
    private int tdpWattsRating;

    @OneToMany(mappedBy = "cooling", fetch = FetchType.LAZY)
    private List<Build> builds;
}