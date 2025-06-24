package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gpu")
public class Gpu extends Component{

    @Column(name = "memory_size_gb", nullable = false)
    private int memorySizeGb;

    @Column(name = "tdp_watts", nullable = false)
    private int tdpWatts;

    @Column(name = "length_mm", nullable = false)
    private int lengthMm;

    @OneToMany(mappedBy = "gpu", fetch = FetchType.LAZY)
    private List<Build> builds;
}
