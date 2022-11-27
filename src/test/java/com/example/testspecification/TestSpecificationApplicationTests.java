package com.example.testspecification;

import com.example.testspecification.model.State;
import com.example.testspecification.model.User;
import com.example.testspecification.repo.UserRepository;
import com.example.testspecification.specifications.SearchCriteria;
import com.example.testspecification.specifications.UserSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.metamodel.SingularAttribute;
import java.util.List;



@SpringBootTest
class TestSpecificationApplicationTests {

	@Autowired
	private UserRepository repository;

	@Test
	void to_find_users_with_given_last_name() {
		UserSpecification spec =
				new UserSpecification(new SearchCriteria("lastName", ":", "doe"));
		UserSpecification spec2 =
				new UserSpecification(new SearchCriteria("age", ">", "25"));

		List<User> results = repository.findAll(spec2);

		System.out.println("======================================");
		if (!results.isEmpty())
			results.forEach(u -> System.out.println(u.getLastName() + " " + u.getAge() + " " + u.getState()));
		System.out.println("======================================");

		Long count = repository.countByState(State.SLAVE);
		System.out.println("count = " + count);




	}

}
