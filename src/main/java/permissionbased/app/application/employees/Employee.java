package permissionbased.app.application.employees;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@ToString
@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "employee_tab")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_last_name")
    private String lastName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "employee_email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_last_name")
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "employee_email")
    private String password;
}
