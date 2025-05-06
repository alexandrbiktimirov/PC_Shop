package org.example.custompcbuilder.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Cooling {
    // Fields taken from https://pcpartpicker.com/product/hYxRsY/thermalright-peerless-assassin-120-se-6617-cfm-cpu-cooler-pa120-se-d3
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "model")
    public String model;

    @Column(name = "manufacturer")
    public String manufacturer;

    @Column(name = "part_number")
    public String partNumber;

    @Column(name = "fan_rpm")
    public String fanRpm;

    @Column(name = "noise_level")
    public String noiseLevel;

    @Column(name = "color")
    public String color;

    @Column(name = "height_mm")
    @Nullable
    public Integer heightMm;

    @Column(name = "cpu_socket")
    public String cpuSocket;

    @Column(name = "water_cooled")
    public Boolean waterCooled;

    @Column(name = "fanless")
    public Boolean fanless;

    public Cooling(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getFanRpm() {
        return fanRpm;
    }

    public void setFanRpm(String fanRpm) {
        this.fanRpm = fanRpm;
    }

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Nullable
    public Integer getHeightMm() {
        return heightMm;
    }

    public void setHeightMm(@Nullable Integer heightMm) {
        this.heightMm = heightMm;
    }

    public String getCpuSocket() {
        return cpuSocket;
    }

    public void setCpuSocket(String cpuSocket) {
        this.cpuSocket = cpuSocket;
    }

    public Boolean getWaterCooled() {
        return waterCooled;
    }

    public void setWaterCooled(Boolean waterCooled) {
        this.waterCooled = waterCooled;
    }

    public Boolean getFanless() {
        return fanless;
    }

    public void setFanless(Boolean fanless) {
        this.fanless = fanless;
    }
}
