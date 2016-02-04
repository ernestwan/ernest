package cn.openjpa.demos.utils;

/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Java 5 enumeration of HTTP status codes.
 *
 * <p>The HTTP status code series can be retrieved via {@link #series()}.
 *
 * @author Arjen Poutsma
 * @author Sebastien Deleuze
 * @see HttpStatus.Series
 * @see <a href="http://www.iana.org/assignments/http-status-codes">HTTP Status Code Registry</a>
 * @see <a href="http://en.wikipedia.org/wiki/List_of_HTTP_status_codes">List of HTTP status codes - Wikipedia</a>
 */
public class HttpStatus {

	// 1xx Informational

	/**
	 * {@code 100 Continue}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.2.1">HTTP/1.1: Semantics and Content, section 6.2.1</a>
	 */
	public static final int CONTINUE = 100;
	/**
	 * {@code 101 Switching Protocols}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.2.2">HTTP/1.1: Semantics and Content, section 6.2.2</a>
	 */
	public static final int SWITCHING_PROTOCOLS = 101;
	/**
	 * {@code 102 Processing}.
	 * @see <a href="http://tools.ietf.org/html/rfc2518#section-10.1">WebDAV</a>
	 */
	public static final int PROCESSING = 102;
	/**
	 * {@code 103 Checkpoint}.
	 * @see <a href="http://code.google.com/p/gears/wiki/ResumableHttpRequestsProposal">A proposal for supporting
	 * resumable POST/PUT HTTP requests in HTTP/1.0</a>
	 */
	public static final int CHECKPOINT = 103;

	// 2xx Success

	/**
	 * {@code 200 OK}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.1">HTTP/1.1: Semantics and Content, section 6.3.1</a>
	 */
	public static final int OK = 200;
	/**
	 * {@code 201 Created}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.2">HTTP/1.1: Semantics and Content, section 6.3.2</a>
	 */
	public static final int CREATED = 201;
	/**
	 * {@code 202 Accepted}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.3">HTTP/1.1: Semantics and Content, section 6.3.3</a>
	 */
	public static final int ACCEPTED = 202;
	/**
	 * {@code 203 Non-Authoritative Information}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.4">HTTP/1.1: Semantics and Content, section 6.3.4</a>
	 */
	public static final int NON_AUTHORITATIVE_INFORMATION = 203;
	/**
	 * {@code 204 No Content}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.5">HTTP/1.1: Semantics and Content, section 6.3.5</a>
	 */
	public static final int NO_CONTENT = 204;
	/**
	 * {@code 205 Reset Content}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.6">HTTP/1.1: Semantics and Content, section 6.3.6</a>
	 */
	public static final int RESET_CONTENT = 205;
	/**
	 * {@code 206 Partial Content}.
	 * @see <a href="http://tools.ietf.org/html/rfc7233#section-4.1">HTTP/1.1: Range Requests, section 4.1</a>
	 */
	public static final int PARTIAL_CONTENT = 206;
	/**
	 * {@code 207 Multi-Status}.
	 * @see <a href="http://tools.ietf.org/html/rfc4918#section-13">WebDAV</a>
	 */
	public static final int MULTI_STATUS = 207;
	/**
	 * {@code 208 Already Reported}.
	 * @see <a href="http://tools.ietf.org/html/rfc5842#section-7.1">WebDAV Binding Extensions</a>
	 */
	public static final int ALREADY_REPORTED = 208;
	/**
	 * {@code 226 IM Used}.
	 * @see <a href="http://tools.ietf.org/html/rfc3229#section-10.4.1">Delta encoding in HTTP</a>
	 */
	public static final int IM_USED = 226;
	// 3xx Redirection

	/**
	 * {@code 300 Multiple Choices}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.1">HTTP/1.1: Semantics and Content, section 6.4.1</a>
	 */
	public static final int MULTIPLE_CHOICES = 300;
	/**
	 * {@code 301 Moved Permanently}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.2">HTTP/1.1: Semantics and Content, section 6.4.2</a>
	 */
	public static final int MOVED_PERMANENTLY = 301;
	/**
	 * {@code 302 Found}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.3">HTTP/1.1: Semantics and Content, section 6.4.3</a>
	 */
	public static final int FOUND = 302;
	/**
	 * {@code 303 See Other}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.4">HTTP/1.1: Semantics and Content, section 6.4.4</a>
	 */
	public static final int SEE_OTHER = 303;
	/**
	 * {@code 304 Not Modified}.
	 * @see <a href="http://tools.ietf.org/html/rfc7232#section-4.1">HTTP/1.1: Conditional Requests, section 4.1</a>
	 */
	public static final int NOT_MODIFIED = 304;
	/**
	 * {@code 307 Temporary Redirect}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.7">HTTP/1.1: Semantics and Content, section 6.4.7</a>
	 */
	public static final int TEMPORARY_REDIRECT = 307;
	/**
	 * {@code 308 Permanent Redirect}.
	 * @see <a href="http://tools.ietf.org/html/rfc7238">RFC 7238</a>
	 */
	public static final int PERMANENT_REDIRECT = 308;

	// --- 4xx Client Error ---

	/**
	 * {@code 400 Bad Request}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.1">HTTP/1.1: Semantics and Content, section 6.5.1</a>
	 */
	public static final int BAD_REQUEST = 400;
	/**
	 * {@code 401 Unauthorized}.
	 * @see <a href="http://tools.ietf.org/html/rfc7235#section-3.1">HTTP/1.1: Authentication, section 3.1</a>
	 */
	public static final int UNAUTHORIZED = 401;
	/**
	 * {@code 402 Payment Required}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.2">HTTP/1.1: Semantics and Content, section 6.5.2</a>
	 */
	public static final int PAYMENT_REQUIRED = 402;
	/**
	 * {@code 403 Forbidden}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.3">HTTP/1.1: Semantics and Content, section 6.5.3</a>
	 */
	public static final int FORBIDDEN = 403;
	/**
	 * {@code 404 Not Found}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.4">HTTP/1.1: Semantics and Content, section 6.5.4</a>
	 */
	public static final int NOT_FOUND = 404;
	/**
	 * {@code 405 Method Not Allowed}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.5">HTTP/1.1: Semantics and Content, section 6.5.5</a>
	 */
	public static final int METHOD_NOT_ALLOWED = 405;
	/**
	 * {@code 406 Not Acceptable}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.6">HTTP/1.1: Semantics and Content, section 6.5.6</a>
	 */
	public static final int NOT_ACCEPTABLE = 406;
	/**
	 * {@code 407 Proxy Authentication Required}.
	 * @see <a href="http://tools.ietf.org/html/rfc7235#section-3.2">HTTP/1.1: Authentication, section 3.2</a>
	 */
	public static final int PROXY_AUTHENTICATION_REQUIRED = 407;
	/**
	 * {@code 408 Request Timeout}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.7">HTTP/1.1: Semantics and Content, section 6.5.7</a>
	 */
	public static final int REQUEST_TIMEOUT = 408;
	/**
	 * {@code 409 Conflict}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.8">HTTP/1.1: Semantics and Content, section 6.5.8</a>
	 */
	public static final int CONFLICT = 409;
	/**
	 * {@code 410 Gone}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.9">HTTP/1.1: Semantics and Content, section 6.5.9</a>
	 */
	public static final int GONE = 410;
	/**
	 * {@code 411 Length Required}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.10">HTTP/1.1: Semantics and Content, section 6.5.10</a>
	 */
	public static final int LENGTH_REQUIRED = 411;
	/**
	 * {@code 412 Precondition failed}.
	 * @see <a href="http://tools.ietf.org/html/rfc7232#section-4.2">HTTP/1.1: Conditional Requests, section 4.2</a>
	 */
	public static final int PRECONDITION_FAILED = 412;
	/**
	 * {@code 413 Payload Too Large}.
	 * @since 4.1
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.11">HTTP/1.1: Semantics and Content, section 6.5.11</a>
	 */
	public static final int PAYLOAD_TOO_LARGE = 413;
	/**
	 * {@code 414 URI Too Long}.
	 * @since 4.1
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.12">HTTP/1.1: Semantics and Content, section 6.5.12</a>
	 */
	public static final int URI_TOO_LONG = 414;
	/**
	 * {@code 415 Unsupported Media Type}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.13">HTTP/1.1: Semantics and Content, section 6.5.13</a>
	 */
	public static final int UNSUPPORTED_MEDIA_TYPE = 415;
	/**
	 * {@code 416 Requested Range Not Satisfiable}.
	 * @see <a href="http://tools.ietf.org/html/rfc7233#section-4.4">HTTP/1.1: Range Requests, section 4.4</a>
	 */
	public static final int REQUESTED_RANGE_NOT_SATISFIABLE = 416;
	/**
	 * {@code 417 Expectation Failed}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.14">HTTP/1.1: Semantics and Content, section 6.5.14</a>
	 */
	public static final int EXPECTATION_FAILED = 417;
	/**
	 * {@code 418 I'm a teapot}.
	 * @see <a href="http://tools.ietf.org/html/rfc2324#section-2.3.2">HTCPCP/1.0</a>
	 */
	public static final int I_AM_A_TEAPOT = 418;
	/**
	 * {@code 422 Unprocessable Entity}.
	 * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.2">WebDAV</a>
	 */
	public static final int UNPROCESSABLE_ENTITY = 422;
	/**
	 * {@code 423 Locked}.
	 * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.3">WebDAV</a>
	 */
	public static final int LOCKED = 423;
	/**
	 * {@code 424 Failed Dependency}.
	 * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.4">WebDAV</a>
	 */
	public static final int FAILED_DEPENDENCY = 424;
	/**
	 * {@code 426 Upgrade Required}.
	 * @see <a href="http://tools.ietf.org/html/rfc2817#section-6">Upgrading to TLS Within HTTP/1.1</a>
	 */
	public static final int UPGRADE_REQUIRED = 426;
	/**
	 * {@code 428 Precondition Required}.
	 * @see <a href="http://tools.ietf.org/html/rfc6585#section-3">Additional HTTP Status Codes</a>
	 */
	public static final int PRECONDITION_REQUIRED = 428;
	/**
	 * {@code 429 Too Many Requests}.
	 * @see <a href="http://tools.ietf.org/html/rfc6585#section-4">Additional HTTP Status Codes</a>
	 */
	public static final int TOO_MANY_REQUESTS = 429;
	/**
	 * {@code 431 Request Header Fields Too Large}.
	 * @see <a href="http://tools.ietf.org/html/rfc6585#section-5">Additional HTTP Status Codes</a>
	 */
	public static final int REQUEST_HEADER_FIELDS_TOO_LARGE = 431;

	// --- 5xx Server Error ---

	/**
	 * {@code 500 Internal Server Error}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.1">HTTP/1.1: Semantics and Content, section 6.6.1</a>
	 */
	public static final int INTERNAL_SERVER_ERROR = 500;
	/**
	 * {@code 501 Not Implemented}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.2">HTTP/1.1: Semantics and Content, section 6.6.2</a>
	 */
	public static final int NOT_IMPLEMENTED = 501;
	/**
	 * {@code 502 Bad Gateway}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.3">HTTP/1.1: Semantics and Content, section 6.6.3</a>
	 */
	public static final int BAD_GATEWAY = 502;
	/**
	 * {@code 503 Service Unavailable}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.4">HTTP/1.1: Semantics and Content, section 6.6.4</a>
	 */
	public static final int SERVICE_UNAVAILABLE = 503;
	/**
	 * {@code 504 Gateway Timeout}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.5">HTTP/1.1: Semantics and Content, section 6.6.5</a>
	 */
	public static final int GATEWAY_TIMEOUT = 504;
	/**
	 * {@code 505 HTTP Version Not Supported}.
	 * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.6">HTTP/1.1: Semantics and Content, section 6.6.6</a>
	 */
	public static final int HTTP_VERSION_NOT_SUPPORTED = 505;
	/**
	 * {@code 506 Variant Also Negotiates}
	 * @see <a href="http://tools.ietf.org/html/rfc2295#section-8.1">Transparent Content Negotiation</a>
	 */
	public static final int VARIANT_ALSO_NEGOTIATES = 506;
	/**
	 * {@code 507 Insufficient Storage}
	 * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.5">WebDAV</a>
	 */
	public static final int INSUFFICIENT_STORAGE = 507;
	/**
	 * {@code 508 Loop Detected}
	 * @see <a href="http://tools.ietf.org/html/rfc5842#section-7.2">WebDAV Binding Extensions</a>
 	 */
	public static final int LOOP_DETECTED = 508;
	/**
	 * {@code 509 Bandwidth Limit Exceeded}
 	 */
	public static final int BANDWIDTH_LIMIT_EXCEEDED = 509;
	/**
	 * {@code 510 Not Extended}
	 * @see <a href="http://tools.ietf.org/html/rfc2774#section-7">HTTP Extension Framework</a>
	 */
	public static final int NOT_EXTENDED = 510;
	/**
	 * {@code 511 Network Authentication Required}.
	 * @see <a href="http://tools.ietf.org/html/rfc6585#section-6">Additional HTTP Status Codes</a>
	 */
	public static final int NETWORK_AUTHENTICATION_REQUIRED = 511;



	private final int value;

	private final String reasonPhrase;


	private HttpStatus(int value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	/**
	 * Return the integer value of this status code.
	 */
	public int value() {
		return this.value;
	}

	/**
	 * Return the reason phrase of this status code.
	 */
	public String getReasonPhrase() {
		return reasonPhrase;
	}

	/**
	 * Whether this status code is in the HTTP series
	 * {@link org.springframework.http.HttpStatus.Series#INFORMATIONAL}.
	 * This is a shortcut for checking the value of {@link #series()}.
	 */
	public boolean is1xxInformational() {
		return (Series.INFORMATIONAL.equals(series()));
	}

	/**
	 * Whether this status code is in the HTTP series
	 * {@link org.springframework.http.HttpStatus.Series#SUCCESSFUL}.
	 * This is a shortcut for checking the value of {@link #series()}.
	 */
	public boolean is2xxSuccessful() {
		return (Series.SUCCESSFUL.equals(series()));
	}

	/**
	 * Whether this status code is in the HTTP series
	 * {@link org.springframework.http.HttpStatus.Series#REDIRECTION}.
	 * This is a shortcut for checking the value of {@link #series()}.
	 */
	public boolean is3xxRedirection() {
		return (Series.REDIRECTION.equals(series()));
	}


	/**
	 * Whether this status code is in the HTTP series
	 * {@link org.springframework.http.HttpStatus.Series#CLIENT_ERROR}.
	 * This is a shortcut for checking the value of {@link #series()}.
	 */
	public boolean is4xxClientError() {
		return (Series.CLIENT_ERROR.equals(series()));
	}

	/**
	 * Whether this status code is in the HTTP series
	 * {@link org.springframework.http.HttpStatus.Series#SERVER_ERROR}.
	 * This is a shortcut for checking the value of {@link #series()}.
	 */
	public boolean is5xxServerError() {
		return (Series.SERVER_ERROR.equals(series()));
	}

	/**
	 * Returns the HTTP status series of this status code.
	 * @see HttpStatus.Series
	 */
	public Series series() {
		return Series.valueOf(this);
	}

	/**
	 * Return a string representation of this status code.
	 */
	@Override
	public String toString() {
		return Integer.toString(value);
	}

	/**
	 * Java 5 enumeration of HTTP status series.
	 * <p>Retrievable via {@link HttpStatus#series()}.
	 */
	public static enum Series {

		INFORMATIONAL(1),
		SUCCESSFUL(2),
		REDIRECTION(3),
		CLIENT_ERROR(4),
		SERVER_ERROR(5);

		private final int value;

		private Series(int value) {
			this.value = value;
		}

		/**
		 * Return the integer value of this status series. Ranges from 1 to 5.
		 */
		public int value() {
			return this.value;
		}

		public static Series valueOf(int status) {
			int seriesCode = status / 100;
			for (Series series : values()) {
				if (series.value == seriesCode) {
					return series;
				}
			}
			throw new IllegalArgumentException("No matching constant for [" + status + "]");
		}

		public static Series valueOf(HttpStatus status) {
			return valueOf(status.value);
		}

	}

}

