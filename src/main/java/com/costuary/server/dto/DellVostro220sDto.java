package com.costuary.server.dto;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Tim.Zhang
 * Health info DTO for Dell vostro-220s with Intel Q8200 CPU assembled.
 */
@Data
@Builder
public class DellVostro220sDto {

	private String cpu1;

	private String cpu2;

	private String cpu3;

	private String cpu4;

	private String fan1;

	private String fan2;

	private String ipv4;
}
