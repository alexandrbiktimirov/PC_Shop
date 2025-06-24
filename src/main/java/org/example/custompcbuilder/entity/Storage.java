package org.example.custompcbuilder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Storage")
public class Storage extends Component{

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "form_factor", nullable = false)
    private String formFactor;

    @Column(name = "capacity_gb", nullable = false)
    private int capacityGb;
}
