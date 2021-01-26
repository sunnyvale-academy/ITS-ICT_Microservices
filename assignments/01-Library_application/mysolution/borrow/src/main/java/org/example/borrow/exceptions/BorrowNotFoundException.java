package org.example.borrow.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Borrow not found")
public class BorrowNotFoundException extends RuntimeException {
}
