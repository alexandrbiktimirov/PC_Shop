package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Motherboard")
public class Motherboard extends Component{

    @Column(name = "socket_type", nullable = false)
    private String socketType;

    @Column(name = "form_factor", nullable = false)
    private String formFactor;

    @Column(name = "supported_memory_type", nullable = false)
    private String supportedMemoryType;

    @OneToMany(mappedBy = "motherboard", fetch = FetchType.LAZY)
    private List<Build> builds;
}