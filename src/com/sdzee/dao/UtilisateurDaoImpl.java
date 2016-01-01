package com.sdzee.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sdzee.entities.Utilisateur;

/**
 * Implémentation de l'interface UtilisateurDao.
 * 
 * @author ecm
 *
 */
@Stateless
public class UtilisateurDaoImpl implements UtilisateurDao {
    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email =:email";
    private static final String EMAIL                 = "email";

    @PersistenceContext( unitName = "bdd_sdzee_PU" )
    private EntityManager       em;

    @Override
    public void creer( Utilisateur utilisateur ) throws DAOException {
        try {
            em.persist( utilisateur );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    @Override
    public Utilisateur trouver( String email ) throws DAOException {
        Utilisateur utilisateur = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( EMAIL, email );
        try {
            utilisateur = (Utilisateur) requete.getSingleResult();
        } catch ( NoResultException e ) {
        	//throw new DAOException("NoResultException at UtilisateurDaoImpl.trouver ", e );
        	System.out.println("NoResultException at UtilisateurDaoImpl.trouver ");
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return utilisateur;
    }
}
