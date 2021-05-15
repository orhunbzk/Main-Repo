package mbeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.CreateDataService;

@RequestScoped
@Named
public class CreateDataBean {

	@Inject
	private CreateDataService createDataService;

	@PostConstruct
	public void firstMethod() {

	}

	public void createData() {
		createDataService.createTestData();
	}

	@PreDestroy
	public void destroy() {

	}
}
