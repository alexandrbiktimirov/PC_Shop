package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "psu")
public class Psu extends Component{

    @Column(name = "wattage",nullable = false)
    private int wattage;

    @Column(name = "form_factor", nullable = false)
    private String formFactor;

    @OneToMany(mappedBy = "psu", fetch = FetchType.LAZY)
    private List<Build> builds;
}
