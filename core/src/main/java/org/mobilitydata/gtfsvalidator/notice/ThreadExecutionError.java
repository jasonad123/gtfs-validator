package org.mobilitydata.gtfsvalidator.notice;

import com.google.common.collect.ImmutableMap;

/**
 * Describes an ExecutionException during multithreaded validation.
 *
 * <p>{@link java.util.concurrent.ExecutionException} is thrown when attempting to retrieve the
 * result of a task that aborted by throwing an exception.
 *
 * <p>Severity: {@code SeverityLevel.ERROR}
 */
public class ThreadExecutionError extends SystemError {
  public ThreadExecutionError(String exceptionClassName, String message) {
    super(ImmutableMap.of("exception", exceptionClassName, "message", message));
  }
}
