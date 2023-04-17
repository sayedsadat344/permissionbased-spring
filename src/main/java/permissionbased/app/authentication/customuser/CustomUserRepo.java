package permissionbased.app.authentication.customuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import permissionbased.app.application.employees.Employee;


@Repository
public interface CustomUserRepo extends JpaRepository<Employee, Long> {



}