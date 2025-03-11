package Portafolio.Portafolio.dao;

/*
Comentario: En el paquete Dao se crearán todas las clases de acceso a datos del proyecto. 
La interface hereda de JpaRepository y recibe objetos de tipo Producto, que tiene como clave un elemento tipo Long. 
*/

import Portafolio.Portafolio.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository <Producto, Long>{

    
}
