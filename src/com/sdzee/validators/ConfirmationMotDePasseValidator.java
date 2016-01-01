package com.sdzee.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator( value = "confirmationMotDePasseValidator" )
public class ConfirmationMotDePasseValidator implements Validator {

    private static final String CHAMP_MOT_DE_PASSE       = "composantMotDePasse";
    private static final String MOTS_DE_PASSE_DIFFERENTS = "Le mot de passe et la confirmation doivent �tre identiques.";

    @Override
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
        /*
         * R�cup�ration de l'attribut mot de passe parmi la liste des attributs
         * du composant confirmation
         */
        UIInput composantMotDePasse = (UIInput) component.getAttributes().get( CHAMP_MOT_DE_PASSE );
        /*
         * R�cup�ration de la valeur du champ, c'est-�-dire le mot de passe
         * saisi
         */
        String motDePasse = (String) composantMotDePasse.getValue();
        /* R�cup�ration de la valeur du champ confirmation */
        String confirmation = (String) value;

        if ( confirmation != null && !confirmation.equals( motDePasse ) ) {
            /*
             * Envoi d'une exception contenant une erreur de validation JSF
             * initialis�e avec le message destin� � l'utilisateur, si les mots
             * de passe sont diff�rents
             */
            throw new ValidatorException(
                    new FacesMessage( FacesMessage.SEVERITY_ERROR, MOTS_DE_PASSE_DIFFERENTS, null ) );
        }
    }
}