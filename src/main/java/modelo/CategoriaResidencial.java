package modelo;

import java.time.LocalDate;

public class CategoriaResidencial {
	private Double limiteInferior;
	private Double limiteSuperior;
	private Double cargoFijo;
	private Double cargoVariable;
	
	public CategoriaResidencial(Double limInf, Double limSup, Double cFijo, Double cVariable) {
		limiteInferior = limInf;
		limiteSuperior = limSup;
		cargoFijo = cFijo;
		cargoVariable = cVariable;
	}
	
	public Double getLimiteSuperior() {
		return limiteSuperior;
	}
	
	public Double getLimiteInferior() {
		return limiteInferior;
	}
	
	public Double getCargoVariable() {
		return this.cargoVariable;
	}
	
	public Double getCargoFijo() {
		return this.cargoFijo;
	}
	
	public boolean pertenece(Cliente unCliente) {
		return unCliente.getConsumoMensual(LocalDate.now().getMonthValue()) > limiteInferior &&
			   unCliente.getConsumoMensual(LocalDate.now().getMonthValue()) <= limiteSuperior;
	}
	
	public boolean esIgual(CategoriaResidencial otraCategoria) { // para los tests del categorizador
		return this.limiteInferior == otraCategoria.getLimiteInferior() &&
			   this.limiteSuperior == otraCategoria.getLimiteSuperior() &&
			   this.cargoFijo == otraCategoria.getCargoFijo() &&
			   this.cargoVariable == otraCategoria.getCargoVariable();
	}
}