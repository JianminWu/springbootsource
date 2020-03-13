package com.cdt.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.data.domain.Sort;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: wujianmin
 * @Date: 2019/12/17 10:16
 * @Function:
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryRequest {

    private Query query;

    private List<Sort> sorts = Lists.newArrayList();

    private PageInfo pageInfo;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Query {
        private List<QueryFiled> must = Lists.newArrayList();

        private List<QueryFiled> or = Lists.newArrayList();

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class QueryFiled {
        private QueryOperator operator;

        private String filed;

        private Object value;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sort {
        private String name;

        private Direction direction;
    }

    public static enum Direction {
        ASC, DESC;

        public boolean isAscending() {
            return this.equals(ASC);
        }

        public boolean isDescending() {
            return this.equals(DESC);
        }

        public static Direction fromString(String value) {

            try {
                return Direction.valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format(
                        "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
            }
        }

        public static Optional<Direction> fromOptionalString(String value) {
            try {
                return Optional.of(fromString(value));
            } catch (IllegalArgumentException e) {
                return Optional.empty();
            }
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PageInfo {
        private Integer size;

        private Integer page;
    }
}
