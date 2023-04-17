package permissionbased.app.application.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import permissionbased.app.application.employees.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    @Query(value = "select * from nmt_employee where lower(username) = :username", nativeQuery = true)
    Employee findByUsername(String username);
}
