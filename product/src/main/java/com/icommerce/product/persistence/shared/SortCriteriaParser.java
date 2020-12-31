package com.icommerce.product.persistence.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortCriteriaParser {

    private static String wordRegex = "[a-zA-Z]\\w*";
    private static String operatorRegex = "(\\+|-|\\s)";
    private static String fullRegex = "(" + wordRegex + ")" + operatorRegex + ",";
    private static final Pattern sortPattern = Pattern.compile(fullRegex);

    public List<SortCriteria> parse(String searchString) {
        List<SortCriteria> sortCriteriaList = new ArrayList<>();
        if (searchString != null) {
            Matcher matcher = sortPattern.matcher(searchString + ",");
            while (matcher.find()) {
                SortCriteria sortCriteria = new SortCriteria();
                sortCriteria.setKey(matcher.group(1));
                sortCriteria.setOperation(SortOperation.getSimpleOperation(matcher.group(2)));
                sortCriteriaList.add(sortCriteria);
            }
        }
        return sortCriteriaList;
    }
}
