package com.icommerce.product.persistence.shared;

public enum SortOperation {

    SORT_ASC, SORT_DESC;

    /**
     * Converts strings into SortOperation enum.
     *
     * @param input single char string.
     * @return SortOperation enum
     */
    public static SortOperation getSimpleOperation(String input) {
        switch (input) {
            case "+":
            case " ": // + is encoded in query strings as a space
                return SORT_ASC;
            case "-":
                return SORT_DESC;
            default:
                return null;
        }
    }
}
