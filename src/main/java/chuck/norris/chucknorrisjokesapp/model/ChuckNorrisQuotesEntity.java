package chuck.norris.chucknorrisjokesapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Quotes")
public class ChuckNorrisQuotesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idChuck;
    private String quotesChuck;
}
