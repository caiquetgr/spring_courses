package com.in28minutes.springboot.aspect;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableCustom implements Pageable {

    private @Getter @Setter Pageable pageable;
    private @Getter Boolean todos;
    private Sort sort;

    public PageableCustom(Pageable pageable, Boolean todos) {
        this.pageable = pageable;
        this.todos = todos;
        this.sort = pageable.getSort();
    }

    @Override
    public boolean isPaged() {
        return false;
    }

    @Override
    public boolean isUnpaged() {
        return false;
    }

    @Override
    public int getPageNumber() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Override
    public long getOffset() {
        return 0;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
