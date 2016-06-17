package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import models.Prodotto;

import javax.persistence.*;

import java.net.URI;

import java.util.*;

import javax.ejb.*;




@Stateless
@Path("/prodotti")
public class ProductContainer {
	@Context
	private UriInfo uriInfo;

    @PersistenceContext(unitName="model-unit")
    private EntityManager em;

    public ProductContainer() { }

    /* GET: Restituisce la collezione di tutti i prodotti */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Collection<Prodotto> getProducts() {
		try {
			Collection<Prodotto> products = em.createQuery("SELECT p FROM Prodotto p").getResultList();
			if (products==null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				return products;
			}
		} catch (Exception e) {
			String errorMessage = "Errore nel trovare i prodotti: " + e.getMessage();
    		throw new WebApplicationException(
				Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				                        .entity(errorMessage).type("text/plain").build());
		}
    }

    /* POST: Aggiunge un nuovo prodotto, passato con JSON o XML */
    @POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response createProduct(Prodotto p) {
		String codice = p.getCodice();
		/* fa questa ricerca per evitare che venga sollevata un'eccezione al momento del commit */
		List<Prodotto> oldProduct = em.createQuery("SELECT p FROM Prodotto p where p.codice = :value1")
				.setParameter("value1",codice).getResultList();
		if (oldProduct.isEmpty()) {
			try {
				em.persist(p);
	            return Response.created(URI.create("/" + p.getCodice())).entity(p).build();
			} catch (Exception e) {
	    		String errorMessage = "Error nel creare il prodotto " + p.toString() + ": " + e.getMessage();
	    		throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				                        .entity(errorMessage).type("text/plain").build());
			}
		} else {
    		String errorMessage = "Esiste già un prodotto con codice: " + codice;
    		throw new WebApplicationException(
				Response.status(Response.Status.INTERNAL_SERVER_ERROR)
			                        .entity(errorMessage).type("text/plain").build());
		}
    }

}