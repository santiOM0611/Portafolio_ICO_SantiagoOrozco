package Portafolio.Portafolio.dao;

import Portafolio.Portafolio.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository <Producto, Long>{

    
}
