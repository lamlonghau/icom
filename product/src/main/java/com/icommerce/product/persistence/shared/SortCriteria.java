package com.icommerce.product.persistence.shared;

public class SortCriteria {

    private String key;
    private SortOperation operation;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SortOperation getOperation() {
        return operation;
    }

    public void setOperation(SortOperation operation) {
        this.operation = operation;
    }
}
