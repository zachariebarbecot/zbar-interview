package fr.zbar.interview.app.data.postgres.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@Entity
@Table(name = "candidate")
public class CandidateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	@NaturalId
	@Column(name = "reference", nullable = false, unique = true)
	private String reference;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "language", nullable = false)
	private String language;
	@Column(name = "experience", nullable = false)
	private Integer experience;
}
