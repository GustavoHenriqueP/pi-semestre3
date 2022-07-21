package model;

/**
 * Classe modelo para o objeto Faculdade
 * @author Grupo 1
 */
public class Faculdade {
	
	private int codFaculdade, numeroFaculdade;
	private String nomeFaculdade, enderecoFaculdade, bairroFaculdade, cidadeFaculdade, cepFaculdade;
	
	public Faculdade() {}
	
	public Faculdade(int codFaculdade, String nomeFaculdade, String enderecoFaculdade, int numeroFaculdade,
			String bairroFaculdade, String cidadeFaculdade, String cepFaculdade) {
		this.codFaculdade = codFaculdade;
		this.nomeFaculdade = nomeFaculdade;
		this.enderecoFaculdade = enderecoFaculdade;
		this.numeroFaculdade = numeroFaculdade;
		this.bairroFaculdade = bairroFaculdade;
		this.cidadeFaculdade = cidadeFaculdade;
		this.cepFaculdade = cepFaculdade;
	}

	public int getCodFaculdade() {
		return codFaculdade;
	}
	public void setCodFaculdade(int codFaculdade) {
		this.codFaculdade = codFaculdade;
	}
	public String getNomeFaculdade() {
		return nomeFaculdade;
	}
	public void setNomeFaculdade(String nomeFaculdade) {
		this.nomeFaculdade = nomeFaculdade;
	}
	public int getNumeroFaculdade() {
		return numeroFaculdade;
	}

	public void setNumeroFaculdade(int numeroFaculdade) {
		this.numeroFaculdade = numeroFaculdade;
	}

	public String getBairroFaculdade() {
		return bairroFaculdade;
	}

	public void setBairroFaculdade(String bairroFaculdade) {
		this.bairroFaculdade = bairroFaculdade;
	}

	public String getCidadeFaculdade() {
		return cidadeFaculdade;
	}

	public void setCidadeFaculdade(String cidadeFaculdade) {
		this.cidadeFaculdade = cidadeFaculdade;
	}

	public String getCepFaculdade() {
		return cepFaculdade;
	}

	public void setCepFaculdade(String cepFaculdade) {
		this.cepFaculdade = cepFaculdade;
	}

	public String getEnderecoFaculdade() {
		return enderecoFaculdade;
	}
	public void setEnderecoFaculdade(String enderecoFaculdade) {
		this.enderecoFaculdade = enderecoFaculdade;
	}

	@Override
	public String toString() {
		return "CODFACULDADE = " + codFaculdade + ", NOMEFACULDADE = " + nomeFaculdade + ", ENDERECOFACULDADE = " + enderecoFaculdade
				+ ", NUMEROFACULDADE = " + numeroFaculdade +  ", BAIRROFACULDADE = " + bairroFaculdade
				+ ", CIDADEFACULDADE = " + cidadeFaculdade + ", CEPFACULDADE = " + cepFaculdade;
	}
}
