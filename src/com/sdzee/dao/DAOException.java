package com.sdzee.dao;

/**
 * Exceptions liées à l'interaction avec la BDD: soucis de connexions, requetes
 * incorrectes, donnees absentes, bdd en défaut , etc.
 * 
 * @author ecm
 *
 */
public class DAOException extends RuntimeException {

    public DAOException( String message ) {
        super( message );
    }

    public DAOException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOException( Throwable cause ) {
        super( cause );
    }

}
