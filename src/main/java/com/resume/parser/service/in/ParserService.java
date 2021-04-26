package com.resume.parser.service.in;

import com.resume.parser.ResponseWrapper;
import org.springframework.web.multipart.MultipartFile;

public interface ParserService {

  ResponseWrapper parseResume(MultipartFile file);
}
