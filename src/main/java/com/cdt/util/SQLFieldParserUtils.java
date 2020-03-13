package com.cdt.util;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: wujianmin
 * @Date: 2019/12/17 15:53
 * @Function:
 * @Version 1.0
 */
public class SQLFieldParserUtils {

    public static SQLFieldParser build(QueryOperator operator) {
        switch (operator) {
            case IN:
            case NOTIN:
                return new ListFiledParser();
            case LIKE:
                return new LikeFiledParser();
            case LLIKE:
                return new LLikeFiledParser();
            case RLIKE:
                return new RLikeFiledParser();
            default:
                return new DefaultFiledParser();
        }
    }

    public static class DefaultFiledParser implements SQLFieldParser {

        @Override
        public String parseFiled(Object field) {
            return field.toString();
        }
    }

    public static class LikeFiledParser implements SQLFieldParser {

        @Override
        public String parseFiled(Object field) {
            return "%" + field + "%";
        }
    }

    public static class LLikeFiledParser implements SQLFieldParser {

        @Override
        public String parseFiled(Object field) {
            return "%" + field;
        }
    }

    public static class RLikeFiledParser implements SQLFieldParser {

        @Override
        public String parseFiled(Object field) {
            return field + "%";
        }
    }

    public static class ListFiledParser implements SQLFieldParser {
        @Override
        public String parseFiled(Object field) {
            StringBuilder builder = new StringBuilder();
            builder.append(" ( ");
            if (field instanceof List) {
                if (CollectionUtils.isEmpty((List) field)) {
                    throw new RuntimeException("list is empty");
                }
                ((List) field).forEach(t -> builder.append(t.toString()).append(","));
                String result = builder.substring(0, builder.lastIndexOf(","));
                return result + " ) ";
            }
            throw new RuntimeException("not a list");
        }
    }

}
