package com.icommerce.product.persistence.shared;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SearchGenericSpecification<T> implements Specification<T> {

	private static final long serialVersionUID = 1L;
	private SearchCriteria criteria;

	public SearchGenericSpecification(final SearchCriteria criteria) {
		this.criteria = criteria;
	}

	public SearchCriteria getCriteria() {
		return criteria;
	}

	@Override
	public Predicate toPredicate(final Root<T> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {

		switch (criteria.getOperation()) {
		case EQUALITY:
			return builder.equal(root.get(criteria.getKey()), criteria.getValue());
		case NEGATION:
			return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
		case GREATER_THAN:
			return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case LESS_THAN:
			return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case LIKE:
			return builder.like(builder.lower(root.get(criteria.getKey())), criteria.getValue().toString().toLowerCase());
		case STARTS_WITH:
			return builder.like(builder.lower(root.get(criteria.getKey())), criteria.getValue().toString().toLowerCase() + "%");
		case ENDS_WITH:
			return builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase());
		case CONTAINS:
			return builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%");
		default:
			return null;
		}
	}

}
