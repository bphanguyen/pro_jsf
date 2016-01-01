package com.sdzee.dao;

import javax.ejb.Local;

import com.sdzee.entities.Utilisateur;

/**
 * Interface DAO : UtilisateurDao.
 * 
 * @author ecm
 *
 */
@Local
public interface UtilisateurDao {
    void creer( Utilisateur utilisteur ) throws DAOException;

    Utilisateur trouver( String email ) throws DAOException;

}
