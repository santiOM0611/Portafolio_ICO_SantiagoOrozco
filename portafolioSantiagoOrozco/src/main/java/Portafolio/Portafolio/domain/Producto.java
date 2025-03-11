package Portafolio.Portafolio.domain;

/*
Comentario: En el paquete domain se crearán todas las entidades del proyecto que mapean las tablas de la base de datos.
Esta clase tiene multiples anotaciones importantes que implementan la interfaz Serializable. 
*/

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="producto")

public class Producto implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    //private Long idCategoria;  ya no se usa por el @manyToOne
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    Categoria categoria;


    public Producto() {
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}