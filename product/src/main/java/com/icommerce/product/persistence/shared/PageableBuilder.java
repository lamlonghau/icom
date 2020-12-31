package com.icommerce.product.persistence.shared;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PageableBuilder {

    public static Pageable build(String sortString, Integer pageSize, Integer pageIndex) {
        final SortCriteriaParser sortCriteriaParser = new SortCriteriaParser();
        final List<Sort> sortList = generateSortList(sortCriteriaParser.parse(sortString));
        final Sort sort = andSort(sortList).orElse(Sort.unsorted());
        return PageRequest.of(pageIndex, pageSize, sort);
    }

    private static  <T, V extends Sort> Optional<Sort> andSort(List<V> criteria) {

        final Iterator<V> itr = criteria.iterator();
        if (itr.hasNext()) {
            Sort sort = (itr.next());
            while (itr.hasNext()) {
                sort = sort.and(itr.next());
            }
            return Optional.of(sort);
        }
        return Optional.empty();
    }

    private static List<Sort> generateSortList(List<SortCriteria> criteria) {
        return criteria.stream().map((criterion) -> {
            switch (criterion.getOperation()) {
                case SORT_ASC:
                    return Sort.by(Sort.Order.asc(criterion.getKey()));
                case SORT_DESC:
                    return Sort.by(Sort.Order.desc(criterion.getKey()));
                default:
                    return null;
            }
        }).collect(Collectors.toList());
    }
}
