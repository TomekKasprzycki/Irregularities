package pl.malopolska.irregularities.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class IrregularityTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @NotNull
    private String name;
    @ManyToMany
    @JoinColumn(name="irregularity_ID", referencedColumnName = "id")
    List<Irregularity> irregularityList;

}
