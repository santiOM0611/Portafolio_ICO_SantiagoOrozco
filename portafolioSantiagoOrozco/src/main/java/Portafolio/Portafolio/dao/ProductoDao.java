package Portafolio.Portafolio.dao;

/*
Comentario: En el paquete Dao se crearán todas las clases de acceso a datos del proyecto. 
La interface hereda de JpaRepository y recibe objetos de tipo Producto, que tiene como clave un elemento tipo Long. 
*/

import Portafolio.Portafolio.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao extends JpaRepository<Producto, Long> {
    
    //Ejemplo de método utilizando Métodos de Query
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value = "SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery = true,
            value = "SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Consulta ampliada de la Práctica #4  
    public List<Producto> findByDescripcion (String descripcion); 
}
