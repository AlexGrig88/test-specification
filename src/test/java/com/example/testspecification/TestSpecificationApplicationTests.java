package com.example.testspecification;

import com.example.testspecification.model.DocumentState;
import com.example.testspecification.model.Stage;
import com.example.testspecification.model.StateCounter;
import com.example.testspecification.model.User;
import com.example.testspecification.repo.UserRepository;
import com.example.testspecification.specifications.SearchCriteria;
import com.example.testspecification.specifications.UserSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class TestSpecificationApplicationTests {

	@Autowired
	private UserRepository repository;

	@Test
	void to_find_users_with_given_last_name() {
		UserSpecification spec =
				new UserSpecification(new SearchCriteria("lastName", ":", "doe"));
		UserSpecification spec2 =
				new UserSpecification(new SearchCriteria("age", ">", "5"));

		List<User> results = repository.findAll(spec2);

		System.out.println("======================================");
		if (!results.isEmpty())
			results.forEach(u -> System.out.println(u.getLastName() + " " + u.getAge() + " " + u.getDocumentState()));
		System.out.println("======================================");


		List<StateCounter> results2 = repository.findAllByState1("");
		System.out.println("======================================");
		System.out.println(results2.isEmpty());
		if (!results2.isEmpty())
			results2.forEach(u -> System.out.println(u.getState() + " : " + u.getCounter()));
		System.out.println("======================================");

		Map<Stage, Long> map = new HashMap<>();
		for (var stateCounter : results2) {
			var stage = Stage.fromState(stateCounter.getState());
			map.compute(stage, (k, v) -> v == null ? stateCounter.getCounter() : v + stateCounter.getCounter());
		}

		System.out.println("======================================");
		System.out.println("===============MAP======================");
		map.forEach((k, v) -> System.out.println(k + " : " + v));


	}

}
