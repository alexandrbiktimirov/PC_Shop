package org.example.custompcbuilder.entity;

import jakarta.persistence.*;

@Entity
public class MotherBoard {
    // Fields taken from https://pcbuilder.net/component-details/motherboard/gigabyte-b450-aorus-elite/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    // General
    @Column(name = "name")
    public String name;

    @Column(name = "model")
    public String model;

    @Column(name = "brand")
    public String brand;

    @Column(name = "socket_type")
    public String socketType;

    @Column(name = "chipset")
    public String chipset;

    @Column(name = "form_factor")
    public String formFactor;

    // Memory support

    @Column(name = "memory_type")
    public String memoryType;

    @Column(name = "ram_quantity")
    public String ramQuantity;

    @Column(name = "max_memory_support")
    public String maxMemorySupport;

    @Column(name = "memory_pin")
    public String memoryPin;

    // Storage expansion
    @Column(name = "sata")
    public String sata;

    @Column(name = "m2")
    public String m2;

    @Column(name = "raid_support")
    public String raidSupport;

    // I/O slots

    @Column(name = "usb")
    public String usb;

    @Column(name = "pcie_slots")
    public String pcieSlots;

    @Column(name = "liquid_cooling")
    public String liquidCooling;

    @Column(name = "air_cooling")
    public String powerConnector;

    @Column(name = "display_port")
    public String displayPort;

    @Column(name = "audio")
    public String audio;

    @Column(name = "ethernet")
    public String ethernet;

    // Wireless

    @Column(name = "wireless_networking")
    public String wirelessNetworking;

    public MotherBoard() {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSocketType() {
        return socketType;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getRamQuantity() {
        return ramQuantity;
    }

    public void setRamQuantity(String ramQuantity) {
        this.ramQuantity = ramQuantity;
    }

    public String getMaxMemorySupport() {
        return maxMemorySupport;
    }

    public void setMaxMemorySupport(String maxMemorySupport) {
        this.maxMemorySupport = maxMemorySupport;
    }

    public String getMemoryPin() {
        return memoryPin;
    }

    public void setMemoryPin(String memoryPin) {
        this.memoryPin = memoryPin;
    }

    public String getSata() {
        return sata;
    }

    public void setSata(String sata) {
        this.sata = sata;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getRaidSupport() {
        return raidSupport;
    }

    public void setRaidSupport(String raidSupport) {
        this.raidSupport = raidSupport;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    public String getPcieSlots() {
        return pcieSlots;
    }

    public void setPcieSlots(String pcieSlots) {
        this.pcieSlots = pcieSlots;
    }

    public String getLiquidCooling() {
        return liquidCooling;
    }

    public void setLiquidCooling(String liquidCooling) {
        this.liquidCooling = liquidCooling;
    }

    public String getPowerConnector() {
        return powerConnector;
    }

    public void setPowerConnector(String powerConnector) {
        this.powerConnector = powerConnector;
    }

    public String getDisplayPort() {
        return displayPort;
    }

    public void setDisplayPort(String displayPort) {
        this.displayPort = displayPort;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getEthernet() {
        return ethernet;
    }

    public void setEthernet(String ethernet) {
        this.ethernet = ethernet;
    }

    public String getWirelessNetworking() {
        return wirelessNetworking;
    }

    public void setWirelessNetworking(String wirelessNetworking) {
        this.wirelessNetworking = wirelessNetworking;
    }
}