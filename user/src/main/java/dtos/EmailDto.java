package dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class EmailDto {

	private UUID userId;
	private String name;
	private String subject;
	private String text;
}
