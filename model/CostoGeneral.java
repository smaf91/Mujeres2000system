package com.mujeres2000.system.model;

import javax.persistence.*;

@Entity
@Table(name = "costo_general")

public class CostoGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int costos_generales_ID;
    @Column (name = "electricidad", length = 10 )
    private int electricidad;
    @Column (name = "agua", length = 10 )
    private int agua;
    @Column (name = "gas", length = 10 )
    private int gas;
    @Column (name = "alquiler", length = 10 )
    private int alquiler;
    @Column (name = "costo_general_total", length = 10 )
    private int costo_general_total;

    @ManyToOne
    @JoinColumn(name = "usuario_ID", referencedColumnName = "usuario_ID")
    private Usuario usuario;

    //CONSTRUCTOR

    public CostoGeneral(int costos_generales_ID, int electricidad, int agua, int gas, int alquiler, int costo_general_total) {
        this.costos_generales_ID = costos_generales_ID;
        this.electricidad = electricidad;
        this.agua = agua;
        this.gas = gas;
        this.alquiler = alquiler;
        this.costo_general_total = costo_general_total;
    }

    public int getCostos_generales_ID() {
        return costos_generales_ID;
    }

    public void setCostos_generales_ID(int costos_generales_ID) {
        this.costos_generales_ID = costos_generales_ID;
    }

    public int getElectricidad() {
        return electricidad;
    }

    public void setElectricidad(int electricidad) {
        this.electricidad = electricidad;
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public int getCosto_general_total() {
        return costo_general_total;
    }

    public void setCosto_general_total(int costo_general_total) {
        this.costo_general_total = costo_general_total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}


