package fr.zbar.interview.app.data.domain;

import fr.zbar.interview.common.Id;
import fr.zbar.interview.common.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDGenerator implements IdGenerator {

	@Override
	public Id<?> generate() {
		return new Id<>(UUID.randomUUID());
	}
}
