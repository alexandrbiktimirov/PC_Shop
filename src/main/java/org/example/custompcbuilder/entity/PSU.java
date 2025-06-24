package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PSU")
public class PSU extends Component{

    @Column(name = "wattage",nullable = false)
    private int wattage;

    @Column(name = "form_factor", nullable = false)
    private String formFactor;

    @OneToMany(mappedBy = "psu", fetch = FetchType.LAZY)
    private List<Build> builds;
}
