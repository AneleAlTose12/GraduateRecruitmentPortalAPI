package za.ac.cput.model;

/*
   User.java
   Damone Hartnick
 */

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder(toBuilder = true)
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;
    protected String firstName;
    protected String surname;
//    @Column(unique = true)
    protected String email;
    protected String password;
    protected String cellphone;
    protected String userRole;
}
