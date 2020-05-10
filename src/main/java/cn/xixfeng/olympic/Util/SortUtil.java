package cn.xixfeng.olympic.Util;

import org.springframework.data.domain.Sort;

public class SortUtil {
    public static Sort basicSort(String orderType, String orderField) {
        return  Sort.by(Sort.Direction.fromString(orderType), orderField);
    }
}
