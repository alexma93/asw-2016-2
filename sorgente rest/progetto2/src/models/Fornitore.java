package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQuery(name = "findAllFornitori", query = "SELECT f FROM Fornitore f")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Fornitore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlAttribute
	private Long id;
	
	@Column
	@XmlElement
	private String nome;
	
	@Column
	@XmlElement
	private String iva;
	@Column
	@XmlElement
	private String telefono;
	@Column
	@XmlElement
	private String email;
	
//	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//	private Indirizzo indirizzo;
//	
	@ManyToMany(mappedBy = "fornitori",cascade = CascadeType.ALL)
	private List<Prodotto> prodotti;
	
	public String getIva() {
		return iva;
	}
	
	public void setIva(String iva) {
		this.iva = iva;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
//	public Indirizzo getIndirizzo() {
//		return indirizzo;
//	}
//	
//	public void setIndirizzo(Indirizzo indirizzo) {
//		this.indirizzo = indirizzo;
//	}
//
//
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iva == null) ? 0 : iva.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornitore other = (Fornitore) obj;
		if (iva == null) {
			if (other.iva != null)
				return false;
		} else if (!iva.equals(other.iva))
			return false;
		return true;
	}

}
