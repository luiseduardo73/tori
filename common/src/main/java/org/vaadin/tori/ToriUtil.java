package org.vaadin.tori;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

public final class ToriUtil {
    private ToriUtil() {
        // not instantiable
    }

    /**
     * Checks whether the given <code>object</code> is <code>null</code>.
     * 
     * @throws IllegalArgumentException
     *             if <code>object</code> is <code>null</code>.
     */
    public static void checkForNull(final Object object,
            final String errorMessage) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkForNullAndEmpty(final Collection<?> collection,
            final String nullErrorMessage, final String emptyErrorMessage)
            throws IllegalArgumentException {
        checkForNull(collection, nullErrorMessage);
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(emptyErrorMessage);
        }
    }

    public static void checkForNullAndEmpty(final String string,
            final String nullErrorMessage, final String emptyErrorMessage)
            throws IllegalArgumentException {
        checkForNull(string, nullErrorMessage);
        if (string.isEmpty()) {
            throw new IllegalArgumentException(emptyErrorMessage);
        }
    }

    /** Remove the first object in an array */
    @java.lang.SuppressWarnings("unchecked")
    @SuppressWarnings(justification = "Java doesn't support generics in this case")
    public static <T extends Object> T[] tail(final T[] array) {
        ToriUtil.checkForNull(array, "array must not be null");

        final List<T> list = new ArrayList<T>();
        for (int i = 1; i < array.length; i++) {
            list.add(array[i]);
        }

        return (T[]) list.toArray();
    }
}
