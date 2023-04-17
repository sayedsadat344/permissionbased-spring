package permissionbased.app.application.permissions;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@ToString
@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "permission_tab")
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "p_name")
    private String name;
}
