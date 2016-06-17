package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/*
 * la URI per l'accesso al servizio sara':
 * context root (al deploy) / base uri (definita qui) / resource uri (definita con @Path)
 */
@ApplicationPath("/")
public class ShopApplication extends Application {}
