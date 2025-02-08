package com.adi.library.Handlers;

import java.util.Map;
import java.util.Set;

public record ErrorResponse(
Map<String, String> errors
) {

}