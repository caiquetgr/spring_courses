package com.in28minutes.springboot.aspect;

import org.apache.commons.lang.BooleanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Aspect
@Component
public class AspectTest {

    @Pointcut("execution( * *.findAll(org.springframework.data.domain.Pageable))")
    private void chamouRepository() {}

    @Around("chamouRepository()")
    public Object beforeChamouRepository(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("entrou no aspect");

        String name = joinPoint.getSignature().getName();
        System.out.println("metodo chamador: "+ name);

        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof PageableCustom) {
                System.out.println("PageableCustom!! " + args[i].toString());

                PageableCustom pageableCustom = (PageableCustom) args[i];

                if (BooleanUtils.isFalse(pageableCustom.getTodos()) || Objects.isNull(pageableCustom.getTodos())) {
                    args[i] = pageableCustom.getPageable();
                } else {
                    Object target = joinPoint.getTarget();
                    if (target instanceof JpaRepository) {
                        List list = ((JpaRepository)target).findAll(pageableCustom.getSort());
                        return new PageImpl(list);
                    }
                }
            }
        }

        return joinPoint.proceed(args);
    }

}
