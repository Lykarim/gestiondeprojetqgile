package sn.ept.git.seminaire.cicd.utils;

import lombok.experimental.UtilityClass;
import sn.ept.git.seminaire.cicd.exceptions.ItemExistsException;
import sn.ept.git.seminaire.cicd.exceptions.ItemNotFoundException;
import java.util.Optional;

/**
 * @author ISENE
 */
@UtilityClass
public final class ExceptionUtils {


    public static  void presentOrThrow(Optional<?> optional, String template, String ... params){
        if(optional.isEmpty()){
            throw new ItemNotFoundException(
                    ItemNotFoundException.format(template, params)
            );
        }
    }

    public static  void absentOrThrow(Optional<?> optional, String template, String ... params){
        if(optional.isPresent()){
            throw new ItemExistsException(
                    ItemExistsException.format(template, params)
            );
        }
    }


    public static  void throwNotFound(String template, String ... params){
            throw new ItemNotFoundException(
                    ItemNotFoundException.format(template, params)
            );
    }

}