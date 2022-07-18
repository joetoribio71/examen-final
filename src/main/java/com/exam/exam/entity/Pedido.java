
package com.exam.exam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
@Entity
public class Pedido implements Serializable {
 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpedido")
    @Id
    private int idpedido;
    @Column(unique=true)
    private String cliente; 
    private String fecha;
    private String reparto;
    private String producto;
    private int cantidad;
    private int precio;
   
}
