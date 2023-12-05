package dtos;

import java.util.UUID;

public record EmailRecordDto(UUID userid, String emailTo, String subject, String text) {
}
