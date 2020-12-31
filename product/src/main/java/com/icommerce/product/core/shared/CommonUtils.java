package com.icommerce.product.core.shared;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.util.*;

public class CommonUtils {

	public static boolean isNullOrEmpty(String content) {
		return content == null || content.trim().length() == 0;
	}

	public static boolean isNullOrEmptyStrings(String ... values) {
		return Arrays.stream(values).allMatch(CommonUtils::isNullOrEmpty);
	}

	public static <T> boolean isNullOrEmpty(Collection<T> collection) {
		return collection == null || collection.isEmpty();
	}

	public static <T> boolean isNullOrEmpty(T[] collection) {
		return collection == null || collection.length == 0;
	}

	public static <K, V> boolean isNullOrEmpty(Map<K, V> map) {
		return map == null || map.isEmpty();
	}

	public static <T> int size(Collection<T> collection) {
		return isNullOrEmpty(collection) ? 0 : collection.size();
	}

	public static String safeTrim(String input) {
		return isNullOrEmpty(input) ? "" : input.trim();
	}

	public static <T> T tryGetValue(T data, T defaulValue) {
		return data == null ? defaulValue : data;
	}

	public static boolean toBool(Boolean val) {
		return val != null && val;
	}

	public static String safeToString(Object obj) {
		return obj != null ? obj.toString() : null;
	}

	public static void copyPropertiesIgnoreNull(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNoValuePropertyNames(src));
	}

	public static String[] getNoValuePropertyNames(Object source) {
		// assert CommonUtils.isNotNull (source): "parameter object passed can not be null"; // prohibit
		// the use of this assertion
		Assert.notNull(source, "transmission parameter object can not be null");
		final BeanWrapper beanWrapper = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();

		Set<String> noValuePropertySet = new HashSet<>();
		Arrays.stream(pds)
			.forEach(
				pd -> {
					Object propertyValue = beanWrapper.getPropertyValue(pd.getName());
					if (propertyValue == null) {
						noValuePropertySet.add(pd.getName());
					} else {
						if (Iterable.class.isAssignableFrom(propertyValue.getClass())) {
							Iterable iterable = (Iterable) propertyValue;
							Iterator iterator = iterable.iterator();
							if (!iterator.hasNext()) noValuePropertySet.add(pd.getName());
						}
						if (Map.class.isAssignableFrom(propertyValue.getClass())) {
							Map map = (Map) propertyValue;
							if (map.isEmpty()) noValuePropertySet.add(pd.getName());
						}
					}
				});
		String[] result = new String[noValuePropertySet.size()];
		return noValuePropertySet.toArray(result);
	}
}
