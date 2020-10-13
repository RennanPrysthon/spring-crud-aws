package br.prysthon.aws.project.models;

import br.prysthon.aws.project.enums.UserStatus;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @OneToMany
    private Set<House> casas = new HashSet<>();
}
