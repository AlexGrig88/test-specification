package com.example.testspecification.repo;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.metamodel.SingularAttribute;
import java.util.Map;

public interface CustomizedGroupCountRepository {
    Map<Object, Long> groupAndCount(SingularAttribute singularAttribute, Specification where);
}
