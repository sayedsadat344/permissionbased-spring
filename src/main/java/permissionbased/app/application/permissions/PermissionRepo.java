package permissionbased.app.application.permissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PermissionRepo extends JpaRepository<Permission,Long> {
    @Query(value = "select distinct(nmt_employee_permission.name) from nmt_employee inner join employee_group on employee_group.employee_id = nmt_employee.employee_id " +
            "inner join nmt_employee_group on nmt_employee_group.id = employee_group.group_id inner join group_role on " +
            "            group_role.group_id = employee_group.group_id inner join role_permission " +
            "            on role_permission.role_id = group_role.role_id inner join nmt_employee_permission " +
            "            on nmt_employee_permission.id = role_permission.permission_id where nmt_employee.employee_id=:userId", nativeQuery = true)
    List<String> findAllByEmployeeId(Long userId);
}
