package modelo.sensores;

import modelo.Actuador;
import modelo.DispositivoInteligente;
import modelo.Regla;
import modelo.Sensor;

public class ReglaTemperaturaAlta implements Regla {
private DispositivoInteligente d;

	public void ejecutar() {
		Sensor medidorTemperatura = new Temperatura();
		Actuador prenderAire = new ActuadorEncenderAire();
		
		float temperaturaActual = medidorTemperatura.tomarMedicion();
		if(temperaturaActual > 24.0) {
			prenderAire.ejecutarAccion(d);
		}
		
	}
}