package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cpu")
public class Cpu extends Component {
    @Column(name = "socket_type", nullable = false)
    private String socketType;

    @Column(name = "core_count", nullable = false)
    private int coreCount;

    @Column(name = "thread_count", nullable = false)
    private int threadCount;

    @Column(name = "tdp_watts", nullable = false)
    private int tdpWatts;

    @OneToMany(mappedBy = "cpu", fetch = FetchType.LAZY)
    private List<Build> builds;
}
