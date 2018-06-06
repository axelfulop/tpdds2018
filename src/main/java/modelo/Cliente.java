package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Cliente {
	private String nombre;
	private String apellido;
	private TipoIdentificacion tipoIdentificacion;
	private int numeroIdentificacion;
	private int telefono;
	private String domicilio;
	private LocalDate fechaAltaServicio;
	private CategoriaResidencial categoria;
	private String nombreUsuario;
	private String contrasena;
	private int puntos;
	private List<DispositivoEstandar> dispositivosEstandares = new ArrayList<DispositivoEstandar>();
	private List<DispositivoInteligente> dispositivosInteligentes = new ArrayList<DispositivoInteligente>();
	private Double consumoTotal;

	public Cliente() {
	}

	public Cliente(String nombre, String apellido, TipoIdentificacion tipoId, Integer numId, Integer tel, String dom,
			String nombreUsuario, String contrasena, int puntaje) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoIdentificacion = tipoId;
		this.numeroIdentificacion = numId;
		this.telefono = tel;
		this.domicilio = dom;
		this.fechaAltaServicio = LocalDate.now();
		this.categoria = new CategoriaResidencial("r1", 0.0, 150.0, 18.76, 0.644);
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntos = puntaje;
	}

	public void agregarDispositivoInteligente(DispositivoInteligente d) {
		this.dispositivosInteligentes.add(d);
		puntos += 15;
	}
	
	public void agregarDispositivoEstandar(DispositivoEstandar d) {
		this.dispositivosEstandares.add(d);
	}
	
	private int cantidadDeDispositivosEnEstado(Estado estado) {
		return (int) this.dispositivosInteligentes.stream().filter(d -> d.getEstado() == estado).count();
	}

	public int cantidadDeDispositivosEncendidos() {
		return this.cantidadDeDispositivosEnEstado(Estado.ENCENDIDO);
	}

	public int cantidadDeDispositivosApagados() {
		return this.cantidadDeDispositivosEnEstado(Estado.APAGADO);
	}

	public int cantidadDeDispositivosEnAhorroDeEnergia() {
		return this.cantidadDeDispositivosEnEstado(Estado.AHORROENERGIA);
	}
	
	public boolean algunDispositivoEncendido() {
		return this.cantidadDeDispositivosEncendidos() > 0;
	}

	public int cantidadDeDispositivos() {
		return this.dispositivosEstandares.size() + this.dispositivosInteligentes.size();
	}

	public Double getConsumoMensual() {
		consumoTotal = (double) 0;
		this.dispositivosEstandares.forEach(d -> consumoTotal += d.getConsumoMensual());
		//this.dispositivosInteligentes.forEach(d -> consumoTotal += d.get);
		return consumoTotal;
	}

	public Double getFacturaMensual(Integer mes) {
		return categoria.getCargoFijo() + categoria.getCargoVariable() * this.getConsumoMensual();
	}

	
	//GETTERS AND SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(int numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaAltaServicio() {
		return fechaAltaServicio;
	}

	public void setFechaAltaServicio(LocalDate fechaAltaServicio) {
		this.fechaAltaServicio = fechaAltaServicio;
	}

	public CategoriaResidencial getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaResidencial categoria) {
		this.categoria = categoria;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public List<DispositivoEstandar> getDispositivosEstandares() {
		return dispositivosEstandares;
	}

	public void setDispositivosEstandares(List<DispositivoEstandar> dispositivosEstandares) {
		this.dispositivosEstandares = dispositivosEstandares;
	}

	public List<DispositivoInteligente> getDispositivosInteligentes() {
		return dispositivosInteligentes;
	}

	public void setDispositivosInteligentes(List<DispositivoInteligente> dispositivosInteligentes) {
		this.dispositivosInteligentes = dispositivosInteligentes;
	}

	public Double getConsumoTotal() {
		return consumoTotal;
	}

	public void setConsumoTotal(Double consumoTotal) {
		this.consumoTotal = consumoTotal;
	}

}