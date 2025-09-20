package fr.zbar.interview.app.api;

import fr.zbar.interview.candidate.command.CreateCandidateCommand;
import fr.zbar.interview.common.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = CandidateController.CANDIDATE_PATH)
public class CandidateController {

	public static final String CANDIDATE_PATH = "candidates";
	private final CommandBus commandBus;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void createCandidate(@RequestBody CandidateCreatedDto dto) {
		commandBus.send(new CreateCandidateCommand(dto.name(), dto.email(), dto.language(), dto.experience()));
	}

	public record CandidateCreatedDto(String name, String email, String language, Integer experience) {
	}
}
