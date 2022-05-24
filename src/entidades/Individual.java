package entidades;

public class Individual extends Contribuinte {
	
	private Double gastosComSaude;
	
	public Individual () {
	}

	public Individual(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public double taxa() {
		double impostoBasico;
		if (getRendaAnual() < 20000.0) {
			impostoBasico = getRendaAnual () * 0.15;
		}
		else {
			impostoBasico = getRendaAnual() * 0.25;
		}
		impostoBasico -= (getGastosComSaude() * 0.5);
		if (impostoBasico < 0.0) {
			return 0.0;
		}
		else {
			return impostoBasico;
		}
	}

}
