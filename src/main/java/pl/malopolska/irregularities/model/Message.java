package pl.malopolska.irregularities.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;
    private Long caseID;
    @ManyToOne
    @JoinColumn(name="creator_id",referencedColumnName = "id")
    private User creator;
    @ManyToOne
    @JoinColumn(name="addressee_id",referencedColumnName = "id")
    private User addressee;


}
