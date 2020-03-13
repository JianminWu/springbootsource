////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//package com.resolver.util;
//
//import java.io.Serializable;
//import java.util.List;
//import org.springframework.data.domain.Sort;
//
//public class CustomSort extends Sort implements Serializable {
//    private static final String orderProperty = "merchantId";
//
//    public CustomSort() {
//        super(new Order[]{new CustomSort.CustomSortOrder("merchantId")});
//    }
//
//    public CustomSort(String... orderProperty) {
//        super(orderProperty);
//    }
//
//    public CustomSort(Direction direction, String... properties) {
//        super(direction, properties);
//    }
//
//    public CustomSort(List<CustomSort.CustomSortOrder> list) {
//        super((Order[])list.toArray(new CustomSort.CustomSortOrder[list.size()]));
//    }
//
//    public static class CustomSortOrder extends Order implements Serializable {
//        public CustomSortOrder(Direction direction, String property) {
//            super(direction, property);
//        }
//
//        public CustomSortOrder() {
//            super("merchantId");
//        }
//
//        public CustomSortOrder(String property) {
//            super(property);
//        }
//    }
//}
