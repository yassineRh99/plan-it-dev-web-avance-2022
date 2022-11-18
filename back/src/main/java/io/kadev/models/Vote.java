package io.kadev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private VoteType.Vote_Type voteType = VoteType.Vote_Type.NOT_DECIDED_YET;
    private Date date_voted;
    @OneToOne(fetch = FetchType.EAGER)
    private User user = new User();

}
