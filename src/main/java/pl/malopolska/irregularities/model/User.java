package pl.malopolska.irregularities.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    @NotNull
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    Role role;
    @NotNull
    private String password;
    private boolean active;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="institution_id",referencedColumnName = "id")
    Institution institution;

    @OneToMany(mappedBy = "creator")
    List<Irregularity> irregularityList;

    public void setPassword(String unHashedPassword){
        this.password=BCrypt.hashpw(unHashedPassword, BCrypt.gensalt());
    }

    public Boolean checkPassword(String unHashedPassword){
        return BCrypt.checkpw(unHashedPassword,this.password);
    }

}
