package com.votingforlunch.util;

import com.votingforlunch.HasId;
import com.votingforlunch.util.exception.IllegalRequestDataException;
import com.votingforlunch.util.exception.NotFoundException;
import lombok.experimental.UtilityClass;
import org.springframework.dao.DataAccessException;

import java.util.Optional;

@UtilityClass
public class ValidationUtil {

    public static <T> T checkNotFoundWithId(T object, int id) {
        checkNotFoundWithId(object != null, id);
        return object;
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }

    public static <T> T checkNotFoundWithId(Optional<T> optional, int id) {
        return checkNotFoundWithId(optional, "Not found entity with id=" + id);
    }

    public static <T> T checkNotFoundWithId(Optional<T> optional, String msg) {
        return optional.orElseThrow(() -> new NotFoundException(msg));
    }

    public static void checkNew(HasId bean) {
        if (!bean.isNew()) {
            throw new IllegalRequestDataException(bean.getClass().getSimpleName() + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(HasId bean, int id) {
        if (bean.isNew()) {
            bean.setId(id);
        } else if (bean.id() != id) {
            throw new IllegalRequestDataException(bean.getClass().getSimpleName() + " must be with id=" + id);
        }
    }

    public static void checkUniqueNameForRestaurant(boolean isFound) {
        if (isFound) {
            throw new DataAccessException("Dish name is not unique for this restaurant.") {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }
    }

}
