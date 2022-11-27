package com.example.testspecification.repo;

import com.example.testspecification.model.State;
import com.example.testspecification.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CustomizedGroupCountRepositoryImpl implements CustomizedGroupCountRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Map<Object, Long> groupAndCount(SingularAttribute singularAttribute, Specification where) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        final Root<User> root = query.from(User.class);
        final Path<State> expression = root.get(singularAttribute);

        query.multiselect(expression, criteriaBuilder.count(root));
        query.select(criteriaBuilder.tuple(expression, criteriaBuilder.count(root)));
        query.where(where.toPredicate(root, query, criteriaBuilder));
        query.groupBy(expression);

        final List<Tuple> resultList = entityManager.createQuery(query).getResultList();
        return resultList.stream()
                .collect(toMap(
                        t -> t.get(0, singularAttribute.getJavaType()),
                        t -> t.get(1, Long.class))
                );

    }
}
