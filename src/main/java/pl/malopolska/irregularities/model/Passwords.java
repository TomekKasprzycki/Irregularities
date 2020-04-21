package pl.malopolska.irregularities.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Passwords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private LocalDate createdDate;
    @ManyToOne
    @JoinColumn(name = "user_ID",referencedColumnName = "id")
    private User user;
}
