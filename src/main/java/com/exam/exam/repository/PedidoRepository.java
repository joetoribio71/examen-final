
package com.exam.exam.repository;

import com.exam.exam.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
