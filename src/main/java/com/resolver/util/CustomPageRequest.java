////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//package com.resolver;
//
//import java.io.Serializable;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort.Direction;
//
//public class CustomPageRequest implements Pageable, Serializable {
//    private int page;
//    private int size;
//    private CustomSort sort;
//
//    public CustomPageRequest() {
//        this.page = 0;
//        this.size = 1;
//        this.sort = null;
//    }
//
//    public CustomPageRequest(int page, int size) {
//        this(page, size, (CustomSort)null);
//    }
//
//    public CustomPageRequest(int page, int size, Direction direction, String... properties) {
//        this(page, size, new CustomSort(direction, properties));
//    }
//
//    public CustomPageRequest(int page, int size, CustomSort sort) {
//        if (page < 0) {
//            throw new IllegalArgumentException("Page index must not be less than zero!");
//        } else if (size < 1) {
//            throw new IllegalArgumentException("Page size must not be less than one!");
//        } else {
//            this.page = page;
//            this.size = size;
//            this.sort = sort;
//        }
//    }
//
//    public CustomSort getSort() {
//        return this.sort;
//    }
//
//    public Pageable next() {
//        return new CustomPageRequest(this.getPageNumber() + 1, this.getPageSize(), this.getSort());
//    }
//
//    public CustomPageRequest previous() {
//        return this.getPageNumber() == 0 ? this : new CustomPageRequest(this.getPageNumber() - 1, this.getPageSize(), this.getSort());
//    }
//
//    public Pageable first() {
//        return new CustomPageRequest(0, this.getPageSize(), this.getSort());
//    }
//
//    public boolean equals(final Object obj) {
//        if (this == obj) {
//            return true;
//        } else if (!(obj instanceof CustomPageRequest)) {
//            return false;
//        } else {
//            CustomPageRequest that = (CustomPageRequest)obj;
//            boolean sortEqual = this.sort == null ? that.sort == null : this.sort.equals(that.sort);
//            return super.equals(that) && sortEqual;
//        }
//    }
//
//    public int hashCode() {
//        int prime = true;
//        int result = 1;
//        int result = 31 * result + this.page;
//        result = 31 * result + this.size;
//        return 31 * result + (null == this.sort ? 0 : this.sort.hashCode());
//    }
//
//    public String toString() {
//        return String.format("Page request [number: %d, size %d, sort: %s]", this.getPageNumber(), this.getPageSize(), this.sort == null ? null : this.sort.toString());
//    }
//
//    public int getPageSize() {
//        return this.size;
//    }
//
//    public int getPageNumber() {
//        return this.page;
//    }
//
//    public int getOffset() {
//        return this.page * this.size;
//    }
//
//    public boolean hasPrevious() {
//        return this.page > 0;
//    }
//
//    public Pageable previousOrFirst() {
//        return (Pageable)(this.hasPrevious() ? this.previous() : this.first());
//    }
//}
