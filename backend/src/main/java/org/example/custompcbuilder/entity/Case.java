package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"case\"")
public class Case extends Component{
    @Column(name = "form_factor_support", nullable = false)
    private String formFactorSupport;

    @Column(name = "max_gpu_length_mm", nullable = false)
    private int maxGpuLengthMm;

    @OneToMany(mappedBy = "aCase", fetch = FetchType.LAZY)
    private List<Build> builds;
}