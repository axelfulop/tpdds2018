package modelo;

import modelo.TuplaDouble;
import modelo.repositorios.RepositorioClientes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "transformadores")
public class Transformador {
	@Id @GeneratedValue
	private int id;
    public ZonaGeografica zonaGeografica;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) @JoinColumn(name = "transformador_id")
    public List<Cliente> clientes = new ArrayList<Cliente>();
    @Transient
    public TuplaDouble ubicacion;

    public double energiaQueEstaConsumiendo() {
        return clientes.stream().mapToDouble(c -> c.getConsumoInstantaneo()).sum();
    }

    public ZonaGeografica getZonaGeografica() {
        return zonaGeografica;
    }

    public void setZonaGeografica(ZonaGeografica zonaGeografica) {
        this.zonaGeografica = zonaGeografica;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void obtenerClientes() {

        RepositorioClientes.getClientes().forEach(cliente -> {
            if (obtenerDistancia(cliente.getUbicacion(), this.ubicacion) <= zonaGeografica.getRadioAbarcativo()) {
                clientes.add(cliente);
            }
        });
    }

    private double obtenerDistancia(TuplaDouble t1, TuplaDouble t2) {
        return Math.sqrt(Math.pow(t1.getX() - t2.getX(), 2) + Math.pow(t1.getY() - t2.getY(), 2));
    }

    public TuplaDouble getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(TuplaDouble ubicacion) {
        this.ubicacion = ubicacion;
    }
}


