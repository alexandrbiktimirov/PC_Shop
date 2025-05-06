package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Cases")
public class Case {
    // Fields taken from https://pcpartpicker.com/product/fc88TW/montech-xr-atx-mid-tower-case-xr-b
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "manufacturer")
    public String manufacturer;

    @Column(name = "part_number")
    public String partNumber;

    @Column(name = "case_type")
    public String caseType;

    @Column(name = "color")
    public String color;

    @Column(name = "power_supply")
    public String powerSupply;

    @Column(name = "side_panel")
    public String sidePanel;

    @Column(name = "power_supply_shroud")
    public Boolean powerSupplyShroud;

    @Column(name = "front_usb_c")
    public Boolean frontUsbC;

    @Column(name = "front_usb_a")
    public Boolean frontUsbA;

    @Column(name = "supports_atx")
    public Boolean supportsAtx;

    @Column(name = "supports_micro_atx")
    public Boolean supportsMicroAtx;

    @Column(name = "supports_mini_itx")
    public Boolean supportsMiniItx;

    @Column(name = "max_gpu_length_mm")
    public Integer maxGpuLengthMm;

    @Column(name = "max_gpu_length_inch")
    public Double maxGpuLengthInch;

    @Column(name = "internal_3_5_bays")
    public Integer internal3_5Bays;

    @Column(name = "internal_2_5_bays")
    public Integer internal2_5Bays;

    @Column(name = "expansion_slots")
    public Integer expansionSlots;

    @Column(name = "dimension_mm")
    public String dimensionMm;

    @Column(name = "dimension_inch")
    public String dimensionInch;

    @Column(name = "volume_liters")
    public Double volumeLiters;

    @Column(name = "volume_cubic_feet")
    public Double volumeCubicFeet;

    public Case() {
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

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getSidePanel() {
        return sidePanel;
    }

    public void setSidePanel(String sidePanel) {
        this.sidePanel = sidePanel;
    }

    public Boolean getPowerSupplyShroud() {
        return powerSupplyShroud;
    }

    public void setPowerSupplyShroud(Boolean powerSupplyShroud) {
        this.powerSupplyShroud = powerSupplyShroud;
    }

    public Boolean getFrontUsbC() {
        return frontUsbC;
    }

    public void setFrontUsbC(Boolean frontUsbC) {
        this.frontUsbC = frontUsbC;
    }

    public Boolean getFrontUsbA() {
        return frontUsbA;
    }

    public void setFrontUsbA(Boolean frontUsbA) {
        this.frontUsbA = frontUsbA;
    }

    public Boolean getSupportsAtx() {
        return supportsAtx;
    }

    public void setSupportsAtx(Boolean supportsAtx) {
        this.supportsAtx = supportsAtx;
    }

    public Boolean getSupportsMicroAtx() {
        return supportsMicroAtx;
    }

    public void setSupportsMicroAtx(Boolean supportsMicroAtx) {
        this.supportsMicroAtx = supportsMicroAtx;
    }

    public Boolean getSupportsMiniItx() {
        return supportsMiniItx;
    }

    public void setSupportsMiniItx(Boolean supportsMiniItx) {
        this.supportsMiniItx = supportsMiniItx;
    }

    public Integer getMaxGpuLengthMm() {
        return maxGpuLengthMm;
    }

    public void setMaxGpuLengthMm(Integer maxGpuLengthMm) {
        this.maxGpuLengthMm = maxGpuLengthMm;
    }

    public Double getMaxGpuLengthInch() {
        return maxGpuLengthInch;
    }

    public void setMaxGpuLengthInch(Double maxGpuLengthInch) {
        this.maxGpuLengthInch = maxGpuLengthInch;
    }

    public Integer getInternal3_5Bays() {
        return internal3_5Bays;
    }

    public void setInternal3_5Bays(Integer internal3_5Bays) {
        this.internal3_5Bays = internal3_5Bays;
    }

    public Integer getInternal2_5Bays() {
        return internal2_5Bays;
    }

    public void setInternal2_5Bays(Integer internal2_5Bays) {
        this.internal2_5Bays = internal2_5Bays;
    }

    public Integer getExpansionSlots() {
        return expansionSlots;
    }

    public void setExpansionSlots(Integer expansionSlots) {
        this.expansionSlots = expansionSlots;
    }

    public String getDimensionMm() {
        return dimensionMm;
    }

    public void setDimensionMm(String dimensionMm) {
        this.dimensionMm = dimensionMm;
    }

    public String getDimensionInch() {
        return dimensionInch;
    }

    public void setDimensionInch(String dimensionInch) {
        this.dimensionInch = dimensionInch;
    }

    public Double getVolumeLiters() {
        return volumeLiters;
    }

    public void setVolumeLiters(Double volumeLiters) {
        this.volumeLiters = volumeLiters;
    }

    public Double getVolumeCubicFeet() {
        return volumeCubicFeet;
    }

    public void setVolumeCubicFeet(Double volumeCubicFeet) {
        this.volumeCubicFeet = volumeCubicFeet;
    }
}