package permissionbased.app.authentication.customuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import permissionbased.app.application.employees.Employee;
import permissionbased.app.application.employees.EmployeeRepo;
import permissionbased.app.application.permissions.PermissionRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomUserRepo customUserRepo;
    @Autowired
    EmployeeRepo employeeRepository;
    @Autowired
    PermissionRepo permissionRepo;



    @Override
    public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);

        List<String> employeePermissionCollection = permissionRepo.findAllByEmployeeId(employee.getId());

        return new CustomUser(employee.getUsername(), employee.getPassword(), getGrantedAuthorities(employeePermissionCollection));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> employeePermissions) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String perName : employeePermissions) {
            authorities.add(new SimpleGrantedAuthority(perName.trim()));
        }
        return authorities;
    }

}